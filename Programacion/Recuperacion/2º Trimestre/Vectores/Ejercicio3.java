import java.util.Scanner;

public class Ejercicio3 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese o número de filas: ");
        int filas = scanner.nextInt();
        
        System.out.println("Ingrese o número de columnas: ");
        int columnas = scanner.nextInt();        


        // Creamos a matriz cos datos necesarios
        int[][] matriz = new int[filas][columnas];


        // Introducimos os valores fila por fila
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {

                System.out.print("Elemento [" + f + "][" + c + "]: ");
                matriz[f][c] = scanner.nextInt();
            }
        }


        // Amosamos o contido da Matriz
        System.out.println("\nMatriz: ");
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                System.out.print("\t"+matriz[f][c]);
            }
            System.out.println(); // Salto de liña entre fila e fila
        }
        
        
        // Calulamos e imprimimos a suma de cada fila
        System.out.println("\nSuma de cada fila:");
        for (int f = 0; f < filas; f++) {
            int sumaFila = 0;
            for (int c = 0; c < columnas; c++) {
                sumaFila += matriz[f][c];
            }
            System.out.println("A suma da fila "+f+": "+sumaFila);
            
        }

        // Calulamos e imprimimos a suma de cada fila
        System.out.println("\nSuma de cada columna:");
        for (int f = 0; f < columnas; f++) {
            int sumaFila = 0;
            for (int c = 0; c < filas; c++) {
                sumaFila += matriz[f][c];
            }
            System.out.println("A suma da columna "+f+": "+sumaFila);
            
        }

        scanner.close();
    }

}
