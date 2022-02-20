package fizzBuzz;

import objectConcept.employee;

import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        /*
            for(int i=1; i<=10; i++) {
                int result = N * i;
                System.out.println(i +" x " + N +" = "+ result);
            }

*/
        int totalCoelhos = 0;
        int totalRatos = 0;
        int totalSapos = 0;

        for (int i = 0; i < N; i++) {
            int quantia = sc.nextInt();
            char tipo = sc.next().charAt(0);

            if (tipo == 'C') {
                totalCoelhos += quantia;
            } else if (tipo == 'R') {
                totalRatos += quantia;
            } else {
                totalSapos += quantia;
            }
        }

        int totalGeral = totalCoelhos + totalRatos + totalSapos;

        double percentCoelhos = (double) totalCoelhos / totalGeral * 100.0;
        double percentRatos = (double) totalRatos / totalGeral * 100.0;
        double percentSapos = (double) totalSapos / totalGeral * 100.0;

        System.out.printf("Total: %d cobaias%n", totalGeral);
        System.out.printf("Total: de coelhos: %d%n", totalCoelhos);
        System.out.printf("Total: de ratos: %d%n", totalRatos);
        System.out.printf("Total: de sapos: %d%n", totalSapos);
        System.out.printf("Percentual de Coelhos: %.2f %%%n", percentCoelhos);
        System.out.printf("Percentual de Ratos: %.2f %%%n", percentRatos);
        System.out.printf("Percentual de Sapos: %.2f %%%n", percentSapos);

        sc.close();


    }
}
