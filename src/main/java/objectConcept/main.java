package objectConcept;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        employee empl1 = new employee();
        employee empl2 = new employee();

        System.out.println("Information about first Employee:");
        System.out.println("firstName: ");
        empl1.firstName = sc.next();
        System.out.println("lastName: ");
        empl1.lastName = sc.next();
        System.out.println("hourWorked: ");
        empl1.time = sc.nextInt();
        System.out.println("valuePerHour: ");
        empl1.valuePerHour = sc.nextDouble();

        System.out.println("Information about Second Employee:");
        System.out.println("firstName: ");
        empl2.firstName = sc.next();
        System.out.println("lastName: ");
        empl2.lastName = sc.next();
        System.out.println("hourWorked: ");
        empl2.time = sc.nextInt();
        System.out.println("valuePerHour: ");
        empl2.valuePerHour = sc.nextDouble();

        double totalValue = empl1.total() + empl2.total();

        System.out.printf("Total = %.2f%n", totalValue);
    }
}
