package RepasoArray;

import java.util.Scanner;

/**
 * IMplante un xogo de Tres en Raisa en Java utilizando Arrays bidimensionales para representar o taboleiro de xogo. O programa debe permitir que dous xogadores humanos xoguen entre eles alternando quendas ata que un deles consiga gañar ou que o taboleiro quede completo, resultando nun empate.
 * 
 *  · Utiliza un vector bidimensional 3x3 de enteiros para representar o taboleiro.
 * 
 *  · Inicialmente, cada posición do taboleiro debe estar baleira, representada un 0 no vector.
 * 
 *  · Alterna entre dous xogadores, representados polos números 1 e 2.
 * 
 *  · Amosa o taboleiro despois de cada movemento. Os espazos baleiros represéntaos con - e os xogadores con "X" para o xogador 1 e "0" para o xogador 2.
 * 
 *  · Verifica e amosa unha mensaxe cando un xogador gaña ou se hai un empate se se encheron todos os ocos.
 * 
 */

public class Exercicio5 {
 
    public static void main(String[] args) {
        

        int[][] taboleiro = new int[3][3];
        int xogador = 1;
        boolean ganador = false;
        boolean taboleiroCompleto = false;
        
        Scanner scanner = new Scanner(System.in);

        //XOGO
        while (true) {

            //AMOSAR TABOLEIRO
            System.out.println("\nC1\tC2\tC3");
            for (int fila = 0; fila < 3; fila++) {

                System.out.print("F" + fila + "\t");
                
                for (int columna = 0; columna < 3; columna++) {
                    
                    if (taboleiro[fila][columna] == 0) {
                        System.out.println("-\t");

                    } else if (taboleiro[fila][columna] == 1) {
                        System.out.println("X\t");
                    } else{
                        System.out.println("O\t");
                    }

                }
            }

            //ENCHER TABOLEIRO
            System.out.println("\nTurno do xogador " + xogador);
            System.out.print("Fila: ");
            int fila = scanner.nextInt();

            System.out.print("Columna: ");
            int columna = scanner.nextInt();

            if (fila < 0 || fila > 3 || columna < 0 || columna > 3 ) {
                System.out.println("Erro");
                continue;
            }

            taboleiro[fila][columna] = xogador;

            
        //COMPROBAMOS SE HAI GAÑADOR
            for (int i = 0; i < 3; i++) {

                //Iteramos FILA por FILA
                if (taboleiro[i][0] == taboleiro[i][1] && taboleiro[i][0] == taboleiro[i][2]) {

                    ganador = true;

                }

                //Iteramos COLUMNA por COLUMNA
                if (taboleiro[0][i] == taboleiro[1][i] && taboleiro[0][i] == taboleiro[2][i]) {

                    ganador = true;

                }
            }

            //Miramos diagonais
                //Diagonal Descendente
                if (taboleiro[0][0] == taboleiro[1][1] && taboleiro[0][0] == taboleiro[2][2]) {

                    ganador = true;

                }

                //Diagonal Acendente
                if (taboleiro[0][2] == taboleiro[1][1] && taboleiro[0][2] == taboleiro[2][0]) {

                    ganador = true;

                }

            // Cambiar de jugador
            if (ganador == false) {
                if (xogador == 1) {
                    xogador = 2;
                } else {
                    xogador = 1;
                }
            }

            //Cando termina o xogo, indicamos quen é o gañador ou se houbo empate
            if (ganador || taboleiroCompleto) {

                if (ganador) {
                    System.out.println("O xogador " + xogador + " gañou!");

                } else {
                    System.out.println("Empate!");
                }

                break;
            }
        }
    }

}
