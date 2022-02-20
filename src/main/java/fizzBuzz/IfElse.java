package fizzBuzz;

import java.util.Scanner;

public class IfElse {

	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);

	System.out.println("Entre com o pre�o do Item");
	 double valor = scan.nextDouble();
	
	 if(valor<=10) {
		 
		 System.out.println("barato, pode comprar");
	 } else if (valor > 10 && valor <15) {
		 
		 System.out.println("Pode Negociar!");
	 } else if (valor >=15 && valor <17) {
		 
		 System.out.println("Pesquisar mais");
	 } else {
		 
		 System.out.println("Est� muito caro");
	 }
	
	
	
	
	
	}

}
