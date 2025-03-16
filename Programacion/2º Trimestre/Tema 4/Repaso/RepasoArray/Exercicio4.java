/**
 * Deséxase xestionar as notas de estudantes dun curso mediante matrices en Java. O exercicio consiste en alamcenar as notas de varios estudantes en diferentes módulos.
 * 
 *  · Primeiro indicaranse os números de estudantes.
 * 
 *  · A continuación indicaranse o número de móduilos,
 * 
 *  · A continuación engadiranse as notas de cada estudante módulo a módulo.
 * 
 *  · Unha vez introducidas as notas do alumnado mostrarase o seguinte menú utilizando a estructura switch:
 * 
 *      a) Media dun alumno -> Pedirase o índice do alumno e calcularase a media das súas notas.
 * 
 *      b) Porcentaxe de aprobados -> Calcularase a porcentaxe de aprobados do módulo do que se introduza o índice:
 * 
 */

package RepasoArray;

import java.util.Scanner;

public class Exercicio4 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese o número de alumnos: ");
        int alumnos = scanner.nextInt();

        System.out.print("Ingrese o número de módulos: ");
        int modulos = scanner.nextInt();

        int clase[][] = new int[alumnos][modulos];

        while (true) { 
            System.out.println("Engada ");
        }
    }
}
