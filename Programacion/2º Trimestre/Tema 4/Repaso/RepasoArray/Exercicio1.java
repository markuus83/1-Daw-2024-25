package RepasoArray;

import java.util.Scanner;

/**
 * Escribe unha aplicación que solicite ao usuario a cantidade de números que desexa introducit. A continuación introducirase por teclado esa cantidade de números decimais. Por último imprime os números introducidos en orde inversa. Debes imprimir un por liña.
 */

public class Exercicio1 {
    
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nCantos números desexa introducir: ");
        int cantidade = scanner.nextInt();


        int [] numeros  = new int[cantidade];

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingrese un número: ");
            numeros[i] = scanner.nextInt();
        }

        System.out.println("\n\n----------------");
        System.out.println("Array: ");

        //Imprimimos o Array
        for (int i : numeros) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n----------------");
        System.out.println("Array á inversa: ");

        //Imprimimos o Array á inversa
        for (int i = numeros.length -1; i >= 0; i--) {
            System.out.print(numeros[i] + " ");
        }
        
        scanner.close();
    }
}