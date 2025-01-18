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

        System.out.print("Ingrese a cantidade de alumnos: ");
        int alumno = scanner.nextInt();

        System.out.print("Ingrese a cantidade de módulos: ");
        int modulo = scanner.nextInt();

        float[][] matriz = new float[alumno][modulo];

        //Ingresar elemento fila por fila
        for(int i=0; i<alumno; i++){
            for(int j=0; j<modulo; j++){
                System.out.print("Elemento [" + i + "][" + j +"]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        //Amosar o contido do array bidimensional
        for(int i=0;i<alumno; i++) {
            for (int j = 0; j < modulo; j++) {
                //engadimos un tabulado para aliñar as notas e mellorar a lexibilidade na salida por
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();

        while (true) {

            Scanner scanner2 = new Scanner(System.in);

            System.out.println("Menu: ");
            System.out.println("1) Media dun alumno.");
            System.out.println("2) Porcentaxe de aprobados");



            System.out.print("\nIngrese a opción a escoller desexada: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese o índice do alumno: ");
                    int indice = scanner2.nextInt();

                    if(indice<0 || indice>alumno){
                        System.out.println("Erro: indice inválido.");
                    } else{

                    }
                    
                    

                    break;

                case 2:
                    
                    break;

                default:
                    System.out.println("Erro: ingrese unha opción válida.");
                    break;
            }
            scanner2.close();
        }
        
    }
}
