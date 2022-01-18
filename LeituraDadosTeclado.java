package com.gabriel.cursojava.aula12;

import java.util.Scanner;

public class LeituraDadosTeclado {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite seu nome completo: ");
		String nomeCompleto = scan.nextLine();
		System.out.println("Seu nome completo é: " + nomeCompleto);

		System.out.println("Digite seu Primeiro nome : ");
		String primeiroCompleto = scan.next();
		System.out.println("Seu primeiro nome é: " + primeiroCompleto);
		
		System.out.println("Digite a sua idade");
		int idade = scan.nextInt();
		System.out.println("Sua idade é:" +idade);
	
		System.out.println("Digite a sua altura");
		double altura = scan.nextDouble();
		System.out.println("Sua altura é:" + altura);
			
		System.out.println("Digite seu Nome, idade, quantidade de filhos, altura e se viajou");
		String nome = scan.next();
		int age = scan.nextInt();
		byte qtdFilhos = scan.nextByte();
		float high = scan.nextFloat();
		boolean viajou = scan.hasNextBoolean();
		System.out.println("Nome: "+ nome);
		System.out.println("Idade: "+ age);
		System.out.println("filhos:" + qtdFilhos);
		System.out.println("Altura: " + high);
		System.out.println("Viajou: " + viajou);
		
		
	}

}
