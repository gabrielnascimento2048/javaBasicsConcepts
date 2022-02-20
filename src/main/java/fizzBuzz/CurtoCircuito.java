package fizzBuzz;

public class CurtoCircuito {

	public static void main(String[] args) {

		boolean verdadeiro = true;
		boolean falso = false;
		boolean resultado = verdadeiro & falso;
		boolean resultado1 = verdadeiro && falso;
		System.out.println(resultado);
		System.out.println(resultado1);

	}

	public static class OperadoresAritmeticos {

		public static void main(String[] args) {

			int resultado = 1+2;
			System.out.println(resultado);

			resultado = resultado-1;
			System.out.println(resultado);

			resultado = resultado*2;
			System.out.println(resultado);

			resultado = resultado/2;
			System.out.println(resultado);

			resultado = resultado+8;
			System.out.println(resultado);

			resultado = resultado % 7;
			System.out.println(resultado);

			String primeiraString = ("Est� � ");
			String segundaString = ("uma String concatenada");

			String terceiraString = primeiraString+segundaString;

			System.out.println(terceiraString);

			resultado = resultado + 1;
			System.out.println(resultado);

			resultado ++;
			System.out.println(resultado);

			System.out.println(resultado++);

			System.out.println(++resultado);


			System.out.println(resultado--);

			System.out.println(--resultado);
		}

	}
}
