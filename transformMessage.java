package com.gabriel.cursojava.aula14;

package Utils;


import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.regex.Pattern;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class messageTransform  extends AbstractMediator {

	private static final Log log = LogFactory.getLog(messageTransform.class);

	private static String queryTag= "«QUERY»";
	private static String allObjectTag= "«tag»allObject«tag»";
	private static String singleTag= "«tag»";
	private static String subQueryTag= "«SUBQUERY»";
	private String queryInput = null;
	private String jdbcName = null;
	private String payload = null;
	public static final String messageTransformed = "messageTransformed";

	public boolean mediate(MessageContext msgCtx) {
		log.info("\n=======================================CONNECT TO DA DATASOURCE START=============================================\n");

		ResultSet rs = null;
		Connection connObj = null;
		Statement st = null;
		String internalPayload = null;
		try {   
			queryInput=(String)msgCtx.getProperty("queryInput");
			jdbcName=(String)msgCtx.getProperty("jdbcName");
			payload="<root>"+(String)msgCtx.getProperty("payload")+"</root>";

			log.info("Query: " + queryInput);
			log.info("jdbcName: " + jdbcName);
			Hashtable environment = new Hashtable();
			environment.put("java.naming.factory.initial", "org.wso2.carbon.tomcat.jndi.CarbonJavaURLContextFactory");
			Context initContext = new InitialContext(environment);
			DataSource ds = (DataSource) initContext.lookup(jdbcName);

			connObj = ds.getConnection();
			st = connObj.createStatement();
			st.execute(queryInput);
	    	rs = st.getResultSet();
	    	if (rs.next()) {
		    	internalPayload = "<root>"+(String) rs.getObject(1)+"</root>";
		    	 msgCtx.setProperty(messageTransformed, mapping(internalPayload,payload,st,rs));
		    	} else {
		    		msgCtx.setProperty(messageTransformed, "");
		    	}
			
			
            log.info("n=======================================CONNECT TO DA DATASOURCE END=============================================\\n"); 
		   
            return true;
        } catch(Exception sqlException) {
        	log.info(sqlException);
            sqlException.printStackTrace();
            return true;
        } finally {
            try {
                // Closing ResultSet Object
                if(rs != null) {
                    rs.close();
                }
                // Closing PreparedStatement Object
                if(st != null) {
                    st.close();
                }
                // Closing Connection Object
                if(connObj != null) {
                    connObj.close();
                }
                return true;  
            } catch(Exception sqlException) {
                sqlException.printStackTrace();
            }
        }
	}

		private static String mapping(String internalPayload, String payload, Statement st, ResultSet rs) {
			try {
				XPathFactory xfact = XPathFactory.newInstance();
				XPath xpath = xfact.newXPath();

				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db;
				Document docPayload;
				Document docInternal;
				db = dbf.newDocumentBuilder();
				InputSource is = new InputSource();
				is.setCharacterStream(new StringReader(internalPayload));
				docInternal = db.parse(is);
				is.setCharacterStream(new StringReader(payload));
				docPayload = db.parse(is);

				String value = xpath.evaluate("//*", docInternal);
				int count = StringUtils.countMatches(value, singleTag)/2;

				while (count>0) {
					if (StringUtils.countMatches(value, allObjectTag)>0) {
						int locateAllObject = internalPayload.indexOf(allObjectTag);
						String tag = internalPayload.substring(0, locateAllObject-1);
						tag = tag.substring(tag.lastIndexOf("<")+1,tag.length());
						String allObject = payload.substring(payload.indexOf("<"+tag+">")+1+tag.length()+1, payload.indexOf("</"+tag+">"));
						internalPayload = internalPayload.replaceAll(Pattern.quote(allObjectTag), allObject);
						is.setCharacterStream(new StringReader(internalPayload));
						docInternal = db.parse(is);
						value = xpath.evaluate("//*", docInternal);
						count = StringUtils.countMatches(value, singleTag)/2;
					} else {

						String xpathSearch = internalPayload.substring(internalPayload.indexOf(singleTag)+singleTag.length()).substring(0, internalPayload.substring(internalPayload.indexOf(singleTag)+singleTag.length()).indexOf(singleTag));
						String replaceValue = xpath.evaluate("//"+xpathSearch+"/text()", docPayload);
						if (replaceValue.length()>0) {
							internalPayload = internalPayload.replaceAll(Pattern.quote(singleTag+xpathSearch+singleTag), StringEscapeUtils.escapeXml(replaceValue));
						} else {internalPayload = internalPayload.replaceAll(Pattern.quote(singleTag+xpathSearch+singleTag), "null");}
						is.setCharacterStream(new StringReader(internalPayload));
						docInternal = db.parse(is);
						value = xpath.evaluate("//*", docInternal);
						count = StringUtils.countMatches(value, singleTag)/2;

					}
				}
				count = StringUtils.countMatches(value, subQueryTag)/2;
	            while (count>0) {
	                String queryToRun = internalPayload.substring(internalPayload.indexOf(subQueryTag)+subQueryTag.length()).substring(0, internalPayload.substring(internalPayload.indexOf(subQueryTag)+subQueryTag.length()).indexOf(subQueryTag));
	                System.out.println(queryToRun);
	                st.execute(StringEscapeUtils.unescapeXml(queryToRun));
	                rs = st.getResultSet();
	                if (rs.next()) {
	                String resultQuery = (String) rs.getObject(1).toString();
	                internalPayload = internalPayload.replaceAll(Pattern.quote(subQueryTag+queryToRun+subQueryTag), StringEscapeUtils.escapeXml(resultQuery));
	                }
	                else {internalPayload = internalPayload.replaceAll(Pattern.quote(subQueryTag+queryToRun+subQueryTag), "");}
	               
	                is.setCharacterStream(new StringReader(internalPayload));
	                docInternal = db.parse(is);
	                value = xpath.evaluate("//*", docInternal);
	                count = StringUtils.countMatches(value, subQueryTag)/2;
	            }
				
				count = StringUtils.countMatches(value, queryTag)/2;
				while (count>0) {
					String queryToRun = internalPayload.substring(internalPayload.indexOf(queryTag)+queryTag.length()).substring(0, internalPayload.substring(internalPayload.indexOf(queryTag)+queryTag.length()).indexOf(queryTag));
					st.execute(StringEscapeUtils.unescapeXml(queryToRun));
					rs = st.getResultSet();
					if (rs.next()) {
				    	String resultQuery = (String) rs.getObject(1).toString();
				    	internalPayload = internalPayload.replaceAll(Pattern.quote(queryTag+queryToRun+queryTag), StringEscapeUtils.escapeXml(resultQuery));
				    	}
				    	else {internalPayload = internalPayload.replaceAll(Pattern.quote(queryTag+queryToRun+queryTag), "");}

					is.setCharacterStream(new StringReader(internalPayload));
					docInternal = db.parse(is);
					value = xpath.evaluate("//*", docInternal);
					count = StringUtils.countMatches(value, queryTag)/2;
				}

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			internalPayload = internalPayload.substring(internalPayload.indexOf("<root>") + "<root>".length(),internalPayload.indexOf("</root>"));
			log.info("Transformed: "+internalPayload);
			return internalPayload;
		}

	}

