/**
 * Crea o segunte programa:
 * 
 * · Crea unha matriz bidimensional. O usuario introducirá o número de columnas e filas nesa orde.
 * 
 * · A continuación introducirá os valores columna a columna
 * 
 * · Calcula o valor da suma de cada columna. Imprime ese valores en orde.
 * 
 * · Calcula o valor da suma de cada fila. Imprime eses valores en orde.
 */


import java.util.Scanner;

public class Exer3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese a lonxitude das columnas: ");
        int lonxColumna = scanner.nextInt();

        System.out.print("Ingrese a lonxitude das filas: ");
        int lonxFila = scanner.nextInt();

        int[][] matriz = new int[lonxColumna][lonxFila];

        for(int i=0;i<lonxColumna;i++){
            System.out.print("Ingrese un número: ");
            matriz[i][null]=scanner.nextInt();
        }
    }
}
