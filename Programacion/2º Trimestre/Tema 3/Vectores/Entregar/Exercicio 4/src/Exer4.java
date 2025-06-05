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

        // Establecemos a cantidade de alumnos
        System.out.print("Ingrese a cantidade de alumnos: ");
        int alumno = scanner.nextInt();

        // Establecemos a cantidade de módulos
        System.out.print("Ingrese a cantidade de módulos: ");
        int modulo = scanner.nextInt();

        // Validamos que las dimensiones de la matriz sean correctas
        if (alumno <= 0 || modulo <= 0) {
            System.out.println("Erro: A lonxitude da matriz non pode ser negativa ou cero.");

            // Pechamos o Scanner
            scanner.close();
            return;
        }

        System.out.println();

        // Inicializamos o array bidimensional
        int[][] matriz = new int[alumno][modulo];

        // Ingresar notas fila por fila, validando que sean correctas
        for (int i = 0; i < alumno; i++) {
            for (int j = 0; j < modulo; j++) {
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

        // Amosar o contido do array bidimensional
        for (int i = 0; i < alumno; i++) {
            for (int j = 0; j < modulo; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        // Establecemos o bucle para amosar o menú
        while (true) {

            System.out.println("\nMenu: ");
            System.out.println("1) Media dun alumno.");
            System.out.println("2) Porcentaxe de aprobados");
            System.out.println("3) Saír.");

            // Pedímoslle ao usuario que escolla a opción desexada
            System.out.print("\nIngrese a opción a escoller: ");
            int option = scanner.nextInt();

            switch (option) {

            // Amosar a media dun alumno
            case 1:
                System.out.print("Ingrese o índice do alumno: ");
                int indice = scanner.nextInt();

                if (indice < 0 || indice >= alumno) {
                    System.out.println("Erro: índice inválido.");
                    break;
                    
                } else {
                    
                    float suma = 0;

                    // Calculamos a suma das notas do alumno
                    for (int i = 0; i < matriz[indice].length; i++) {
                        suma += matriz[indice][i];
                    }

                    float media = suma / matriz[indice].length;

                    System.out.println("\nLa media del alumno " + indice + " es: " + media);
                }
                break;

            // Calcular a porcentaxe de aprobados
            case 2:
                System.out.print("Ingrese el índice del módulo: ");
                int indiceModulo = scanner.nextInt();

                // Calculamos que o índice sexa válido
                if (indiceModulo < 0 || indiceModulo >= modulo) {
                    System.out.println("Erro: índice de módulo inválido.");
                    break;
                }

                // Contamos cantos alumnos están aprobados nese módulo
                int aprobados = 0;
                for (int i = 0; i < alumno; i++) {
                    if (matriz[i][indiceModulo] >= 5) {
                        aprobados++;
                    }
                }

                // Calculamos o porcentaxe de aprobados
                double porcentajeAprobados = (double) aprobados / alumno * 100;

                // Mostramos o resultado
                System.out.println(
                        "Porcentaje de aprobados en el módulo " + indiceModulo + ": " + porcentajeAprobados + "%");
                break;

            // Saír do menú
            case 3:
                System.out.println("\nSaíndo...");
                return;

            // Erro no caso de ingresar un valor inválido
            default:
                System.out.println("Erro: ingrese unha opción válida.");
                break;
            }
        }
    }
}