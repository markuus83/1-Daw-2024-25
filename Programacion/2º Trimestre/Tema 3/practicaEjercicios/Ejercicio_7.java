/**
 * Pide un número por consola e imprime por pantalla <Primo> se este é un número primo, e <Non primo> en caso contrario
 */

import java.util.Scanner;

public class Ejercicio_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número para calcular se é primo ou non: ");
        int numero = scanner.nextInt();

        if (numero<= 1){
            System.out.println("Non primo");
        }

        

        scanner.close();
    }
}
