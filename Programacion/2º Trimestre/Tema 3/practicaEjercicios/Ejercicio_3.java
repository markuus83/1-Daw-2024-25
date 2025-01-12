/**
 * Queremos calcular o prezo dunha compra dunha froitería. Primeiro pediremos por pantalla os quilogramos comprados de mazás e despois os quilogramos de laranxas. Imprimirase por pantalla o importe a pagar. Os prezos das foritas son as seguintes:
 * 
 * · Mazás: 3,5 €/kg
 * · Laranxas: 1,6€/kg
 * 
 * ||NOTA: Utilizade o tipo de valor Double||
 */

import java.util.Scanner;

public class Ejercicio_3 {
        
    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.print("Ingrese a cantidade de quilogramos comprados de mazás: ");
    	double kgMaza = scanner.nextDouble();
    	
    	System.out.print("Ingrese a cantidade de quilogramos comprados de mazás: ");
    	double kgLaranxa= scanner.nextDouble();
    	
    	double prezoMaza = kgMaza * 3.5;
    	double prezoLaranxa = kgLaranxa * 1.6;
    	
    	System.out.println("O prezo a pagar de mazás é: " + prezoMaza + "€");
    	System.out.println("O prezo a pagar de laranxas é: " + prezoLaranxa + "€");
    	
    	scanner.close();
    	
    }

}
