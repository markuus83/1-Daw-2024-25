import java.util.Scanner;

public class Exer3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese a lonxitude das columnas: ");
        int columnas = scanner.nextInt();

        System.out.print("Ingrese a lonxitude das filas: ");
        int filas = scanner.nextInt();

        // Crear matriz
        int[][] array = new int[filas][columnas];

        // Introducir os valores fila por fila
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                System.out.print("Elemento [" + f + "][" + c + "]: ");
                array[f][c] = scanner.nextInt();
            }
        }

        // Mostrar o contido da matriz
        System.out.println("Contido da matriz: ");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        // Calcular e imprimir a suma de cada fila
        System.out.println("Suma de cada fila: ");
        for (int i = 0; i < filas; i++) {
            int sumaFila = 0;
            for (int j = 0; j < columnas; j++) { // Cambiado a columnas
                sumaFila += array[i][j];
            }
            System.out.println("Suma da fila " + i + ": " + sumaFila);
        }

        // Calcular e imprimir a suma de cada columna
        System.out.println("Suma de cada columna: ");
        for (int j = 0; j < columnas; j++) { // Cambiado a columnas como bucle externo
            int sumaColumna = 0;
            for (int i = 0; i < filas; i++) { // Cambiado a filas
                sumaColumna += array[i][j];
            }
            System.out.println("Suma da columna " + j + ": " + sumaColumna);
        }

        scanner.close();
    }
}
