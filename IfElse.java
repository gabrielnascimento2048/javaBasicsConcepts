package com.gabriel.cursojava.aula14;

import java.util.Scanner;

public class IfElse {

	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
	/*System.out.println("Digite a sua idade");
	int idade = scan.nextInt();
	
	if (idade >= 18){
		
		System.out.println("É maior de idade");
	} else {
		
		System.out.println("Não é maior de idade");
	}
	
	*/
		
	System.out.println("Entre com o preço do Item");
	 double valor = scan.nextDouble();
	
	 if(valor<=10) {
		 
		 System.out.println("barato, pode comprar");
	 } else if (valor > 10 && valor <15) {
		 
		 System.out.println("Pode Negociar!");
	 } else if (valor >=15 && valor <17) {
		 
		 System.out.println("Pesquisar mais");
	 } else {
		 
		 System.out.println("Está muito caro");
	 }
	
	
	
	
	
	}

}
