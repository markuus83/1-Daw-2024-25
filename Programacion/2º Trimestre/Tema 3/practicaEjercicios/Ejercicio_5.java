/**
 * Pedir 3 números por pantalla e imprimir en orde de maior a menor
 */

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio_5 {
            
    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner (System.in);
    	
    	System.out.print("Ingrese 1 números enteiro: ");
    	int num1 = scanner.nextInt();
    	System.out.print("Ingrese outro número enteiro: ");
    	int num2 = scanner.nextInt();
    	System.out.print("Ingrese un último número enteiro: ");
    	int num3 = scanner.nextInt();
    	
    	int[] numeros = {num1,num2,num3}; //almacenamos os números nun array
    	
    	Arrays.sort(numeros); //Ordenamos o array
    	
    	System.out.println(numeros[0] + ", " + numeros[1] + ", " + numeros[2]);
    }
}
