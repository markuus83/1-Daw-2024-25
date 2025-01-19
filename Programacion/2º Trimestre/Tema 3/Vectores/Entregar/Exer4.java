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

        //Establecemos a cantidade de alumnos
        System.out.print("Ingrese a cantidade de alumnos: ");
        int alumno = scanner.nextInt();

        //Establecemos a cantidade de módulos
        System.out.print("Ingrese a cantidade de módulos: ");
        int modulo = scanner.nextInt();

        if(alumno <=0 && modulo<=0){
            System.out.println("Erro: Necesitamos ingresar alumnos ou módulos.");
        }

        System.out.println();
        System.out.println("Suponemos que las notas a ingresar son las finales, por lo cual solamente aceptamos valores enteros.");

        //Inicializamos o array bidimensional
        int[][] matriz = new int[alumno][modulo];

       // Ingresar elemento fila por fila validando si la nota ingresada es correcta o no
        for (int i = 0; i < alumno; i++) {
            for (int j = 0; j < modulo; j++) {
                //Para poder utilizar el do-while, tenemos que declarar la nota fuera del bucle, e inicializarla dentro
                int nota;
                do {
                    System.out.print("Elemento [" + i + "][" + j + "]: ");
                    nota = scanner.nextInt();
                    if (nota < 0 || nota > 10) {
                        System.out.println("Erro: a nota debe estar entre 0 e 10. Inténtao de novo.");
                    }
                } while (nota < 0 || nota > 10);
                matriz[i][j] = nota;
            }
        }

        //Amosar o contido do array bidimensional
        for(int i=0;i<alumno; i++) {
            for (int j = 0; j < modulo; j++) {
                //Engadimos un tabulado para aliñar as notas e mellorar a lexibilidade na salida por consola
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        //Establecemos o bucle para amosar o menú
        while (true) {

            System.out.println("\n\nMenu: ");
            System.out.println("1) Media dun alumno.");
            System.out.println("2) Porcentaxe de aprobados");
            System.out.println("3) Saír.");

            //Pedímoslle ao usuario que escollar a opción desexada
            System.out.print("\nIngrese a opción a escoller: ");
            int option = scanner.nextInt();

            switch (option) {

                //Amosar a media dun alumno
                case 1:
                    System.out.print("Ingrese o índice do alumno: ");
                    int indice = scanner.nextInt();

                    if(indice<0 || indice > alumno -1){
                        System.out.println("Erro: indice inválido.");
                        break;
                    } else{
                        int suma = 0;

                        //Almacenamos nunha variable a lonxitude da fila seleccionada
                        int elementos = matriz[indice].length;

                        for(int i=0; i<elementos;i++){
                            suma += matriz[indice][i];
                        }

                        double media = suma/elementos;

                        //Aunque se haya inicializado como un 'double', en la salida por consola redondea directamente a un valor entero
                        System.out.println("\nLa media del alumno " + indice + " es: " + media);
                    }
                    break;

                //Calcular a porcentaxe de aprobados
                case 2:
                    System.out.print("Ingrese el índice del módulo (0 a " + (modulo - 1) + "): ");
                    int indiceModulo = scanner.nextInt();

                    // Validamos que el índice sea válido
                    if (indiceModulo < 0 || indiceModulo >= modulo) {
                        System.out.println("Erro: índice de módulo inválido.");
                        break;
                    }

                    // Contamos cuántos alumnos están aprobados en ese módulo
                    int aprobados = 0;
                    for (int i = 0; i < alumno; i++) {
                        if (matriz[i][indiceModulo] >= 5) { // Consideramos aprobados con nota >= 5
                            aprobados++;
                        }
                    }

                    // Calculamos el porcentaje de aprobados
                    double porcentajeAprobados = (double) aprobados / alumno * 100;

                    // Mostramos el resultado
                    System.out.println("Porcentaje de aprobados en el módulo " + indiceModulo + ": " + porcentajeAprobados + "%");
                    break;

                //Saír do menú
                case 3:
                    System.out.println("Saíndo...");
                    return;

                    //Erro no caso de ingresar un valor inválido
                default:
                    System.out.println("Erro: ingrese unha opción válida.");
                    break;
            }
            scanner.close();
        }
    }
}