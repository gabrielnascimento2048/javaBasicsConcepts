package objectConcept;

public class employee {

    public String firstName;
    public String lastName;
    public int time;
    public double valuePerHour;

    public double total(){
     return time * valuePerHour;
    }


}
