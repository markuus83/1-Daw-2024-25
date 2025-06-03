/**
 * Escribe una aplicación que solicite ao usuario a cantidade de números que desexa introducir. A continuación introducirase por teclado esa cantidade de números decimais. Por último imprime os números introducidos en orde inversa. Debes imprimir un liña por liña.
 * 
 */

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
     
        Scanner scanner = new Scanner(System.in);


        System.out.println("Cantos números desexas introducir: ");
        int total = scanner.nextInt();

        //Inicializamos o Array
        double array[] = new double[total];

        //ingresamos os datos
        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingrese un número para a posición "+ i +": ");
            array[i]= scanner.nextDouble();
        }

        System.out.println();

        // Amosamos en orde inversa
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}
