/**
 * Escrbe unha aplicación que solicite ao usuario a cantidade de números que desexa introducir. A continuación introducirase por teclado esa cantidade de números decimais. Por último imprime os números introducidos en orde inversa. Debes imprimir un por liña.
 * 
 * ||NOTA: Coidado senón se quere introducir ningún número. Non se debería imprimir nada||
 */

import java.util.Scanner;

public class Exer1 {
 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese a cantidade de números que desexa introducir: ");
        int cantNum = scanner.nextInt();

        float[] numeros = new float[cantNum];

        for (int i=0; i < cantNum ;i++) {
            System.out.println(numeros[i] + ", ");
        }

        scanner.close();
    }

}
