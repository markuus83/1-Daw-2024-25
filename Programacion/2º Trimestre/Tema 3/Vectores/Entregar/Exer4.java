/**
 * Deséxase xestionar as notas de estudantes dun curso mediante matrices en java. O exercicio consiste en almacenar as notas de varios estudantes en diferentes módulos.
 * 
 * · Primeiro indicarase o número de estudantes
 * 
 * · A continuación indicarase o número de módulos
 * 
 * · A continuación engadiranse as notas de cada estudante módulo a módulo.
 * 
 * · Unha vez introducidos as notas do alumnado mostrarase o seguinte mení utilizando un switch:
 *      a) Media dun alumno: pedirase o índice do alumno e calcularase a media das súas notas
 *      b) Porcentaxe de aprobados: calcularase a porcentaxe de aprobados do módulo do que se introduza o índice.
 */

import java.util.Scanner;

public class Exer4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese o número de estudantes: ");
        int alumno = scanner.nextInt();

        System.out.print("Ingrese o número de modulos: ");
        int modulo = scanner.nextInt();

        int[][] curso = new int [alumno][modulo];
    }
}
