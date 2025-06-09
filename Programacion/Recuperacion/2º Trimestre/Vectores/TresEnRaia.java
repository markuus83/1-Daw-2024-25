import java.util.Scanner;

/**
 * Implanta un xogo de tres en Raia utilizando arrays bidimensionais para represnetar o taboleiro de xogo. O programa debe permitir que dous xogadores humanos xoguen entre eles alternando quendas ata que un deles consiga gañar ou que o taboleiro quede completo, resultando nun empate.
 * 
 *  · Utiliza un vector bidimensional 3x3 de enteiros apra representar o taboleiro
 * 
 *  · Inicialmente, cada posición do taboliero debe estar baliera, representada cun 0 no vector.
 * 
 *  · Alterna entre os dous xogadores, representados polos números 1 e 2.
 * 
 *  · Amosa o taboleiro despos de cada movemento. Os espazos baleiros represéntaos con - e os xogadores con X para o xogador1 e 0 para o xogador2.
 * 
 *  · Verifica e amosa unha mensaxe cando un xogador gaña ou se hai un empate se se encheron todos os ocos.
 * 
 */

public class TresEnRaia {
    public static void main(String[] args) {

        int taboleiro [][] = new int[3][3];
        int xogador = 1;   
        boolean ganador = false;
        boolean taboleiroCompleto = false;

        Scanner scanner = new Scanner(System.in);
        
        boolean xogoActivo = true;
        while(xogoActivo){

            System.out.println("\nC1\tC2\tC3");

            for (int fila = 0; fila < 3; fila++) {

                System.out.println("F"+fila+"\t");

                for (int columna = 0; columna < 3; columna++) {
                    
                    // Se está vacío -> -
                    if (taboleiro[fila][columna] == 0) {
                        
                        System.out.println("-\t");

                    // Se está ocupado polo 1 -> X
                    } else if (taboleiro[fila][columna] == 1) {
                    
                        System.out.println("X\t");

                    // Se está ocupado polo 2 -> 0
                    } else {

                        System.out.println("0\t");

                    }
                }
                System.out.println();
            }


            // COMPROBAMOS QUE HAI GAÑADOR
            if (ganador || taboleiroCompleto) {
                
                if (ganador) {
                    System.out.println("\nO xogador"+xogador+"gañou!");
                } 
                System.out.println("Empate!");
            }


            for (int i = 0; i < 3; i++) {

                //Comprobamos filas
                if (taboleiro[i][0] == xogador && taboleiro[i][1] == xogador && taboleiro[i][2] == xogador) {
                    ganador = true;
                }

                // Comprobamos columnas
                if (taboleiro[0][i] == xogador && taboleiro[1][i] == xogador && taboleiro[2][i] == xogador) {
                    ganador = true;
                }

                // Comprobamos unha diagonal
                if (taboleiro[0][0] == xogador && taboleiro[1][1] == xogador && taboleiro[2][2] == xogador) {
                    ganador = true;
                }

                // Comprobamos a outra diagonal
                if (taboleiro[0][2] == xogador && taboleiro[1][1] == xogador && taboleiro[2][0] == xogador) {
                    ganador = true;
                }
            }

            //FIN DO XOGO



            // ENCHER TABOLEIRO

            System.out.println("\tTurno do xogador"+xogador+": ");

            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3 || taboleiro[fila][columna] != 0) {

                System.out.println("Erro: Movemento inválido.");
                continue;
            }
            //taboleiro[fila][columna] = taboleiro;



            // CAMBIO DE XOGADOR
            if (!ganador) {
                if (xogador == 1) {
                    xogador = 2;
                } else{
                    xogador = 1;
                }
            }

        }
    }
}
