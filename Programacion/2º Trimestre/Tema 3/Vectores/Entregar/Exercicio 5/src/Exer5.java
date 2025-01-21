/**
 * Implante un xogo de Tres en Raia en Java utilizando Arrays bidimensionales para representar o taboleiro de xogo. O programa debe permitir que dous xogadores humanos xoguen entre eles alternando quendas ata que un deles consiga gañar ou que o taboleiro quede completo, resultando nun empate.
 * 
 *  · Utiliza un vector bidimensional 3x3 de enteiros para representar o taboleiro.
 * 
 *  · Inicialmente, cada posicion do taboleiro debe estar baleira, representada cun 0 no vector.
 * 
 *  · Alterna entre dous xogadores, representados polos números 1 e 2.
 * 
 *  · Amosa o taboleiro despois de cada movemento. Os espazos baleiros represéntaos con - e os xogadores con "X" para o xogador 1 e "0" para o xogador 2.
 * 
 *  · Verifica e amosa unha mensaxe cando un xogador gaña ou se hai un empate se se encheron todos os ocos.
*/

import java.util.Scanner;

public class Exer5 {

    public static void main(String[] args) {

        int[][] tablero = new int[3][3];
        int jugador = 1;
        boolean ganador = false;
        boolean tableroCompleto = false;

        Scanner scanner = new Scanner(System.in);

        
        while (true) {

            //Amosamos o taboleiro
            System.out.println("\nC1\tC2\tC3");
            for (int fila = 0; fila < 3; fila++) {

                System.out.print("F" + fila + "\t");

                for (int columna = 0; columna < 3; columna++) {

                    if (tablero[fila][columna] == 0) {
                        System.out.print("-\t");

                    } else if (tablero[fila][columna] == 1) {
                        System.out.print("X\t");

                    } else {
                        System.out.print("O\t");
                    }
                }
                System.out.println();
            }

            //Cando termina o xogo, indicamos quen é o gañador ou se houbo empate
            if (ganador || tableroCompleto) {

                if (ganador) {
                    System.out.println("O xogador " + jugador + " gañou!");

                } else {
                    System.out.println("Empate!");
                }

                break;
            }

            //Pedimos por teclado as coordenadas a encher
            System.out.print("\nTurno do xogador " + jugador + ": ");

            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3 || tablero[fila][columna] != 0) {

                System.out.println("Erro: Movemento inválido.");
                continue;
            }
            tablero[fila][columna] = jugador;

            //Comprobamos se hai gañador 
            for (int i = 0; i < 3; i++) {

                //Iteramos FILA por FILA para ver se hay algunha completa co mesmo signo
                if (tablero[i][0] == jugador && tablero[i][1] == jugador
                        && tablero[i][2] == jugador) {
                    ganador = true;
                }

                //Iteramos COLUMNA por COLUMNA para ver se hay algunha completa co mesmo signo
                if (tablero[0][i] == jugador && tablero[1][i] == jugador
                        && tablero[2][i] == jugador) {
                    ganador = true;
                }
            }

            //Comprobamos se hay unha diagonal gañadora
            if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
                ganador = true;
            }

            //Comprobamos a outra diagonal
            if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
                ganador = true;
            }

            //Comprobamos se o taboleiro está completo
            tableroCompleto = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (tablero[i][j] == 0) {
                        tableroCompleto = false;
                    }
                }
            }

            // Cambiar de jugador
            if (ganador == false) {
                if (jugador == 1) {
                    jugador = 2;
                } else {
                    jugador = 1;
                }
            }
        }
        //Pechamos o Scanner
        scanner.close();
    }
}