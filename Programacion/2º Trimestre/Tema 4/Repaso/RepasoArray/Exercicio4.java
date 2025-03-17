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

        // INGRESAR AS NOTAS FILA POR FILA
        System.out.println("Ingrese os elementos da matriz: ");

        // Recorremos as filas
        for (int i = 0; i < alumnos; i++) {

            // Recorremos as columnas
            for (int j = 0; j < modulos; j++) {

                // Inicializamos nota aqui para poder utilizar as súas propiedades no buble
                // DoWhile
                int nota;
                do {

                    System.out.print("Elemento [" + i + "] - [" + j + "]: ");
                    nota = scanner.nextInt();

                    if (nota > 10 || nota < 0) {
                        System.out.println("Erro.");
                    }

                } while (nota < 0 || nota > 10);
                clase[i][j] = nota;

            }

        }

        while (true) {
            System.out.println("\n----------");
            System.out.println("Menú: ");
            System.out.println("\t1. Media dun alumno: ");
            System.out.println("\t2. Porcentaxe de aprobados: ");
            System.out.println("\t3. Saír: ");

            System.out.print("Ingrese a opción desexada: ");
            int option = scanner.nextInt();

            switch (option) {

                /**
                 * MEDIA DUN ALUMNO
                 */
                case 1 -> {

                    // Limpamos o búfer
                    scanner.next();

                    System.out.print("Ingrese o índice do alumno ");
                    int indice = scanner.nextInt();

                    if (indice > alumnos || indice < 0) {
                        System.out.println("Erro");
                    } else {

                        double suma = 0;

                        // calculamos a suma das notas do alumno
                        for (int i = 0; i < clase[indice].length; i++) {
                            suma += clase[indice][i];
                        }

                        double media = suma / clase[indice].length;

                        System.out.println("La media es: " + media);
                    }
                    break;
                }

                /**
                 * PORCENTAXE DE APROBADOS
                 */
                case 2 -> {

                    // Limpamos o búfer
                    scanner.next();

                    System.out.print("Ingrese el índice del módulo: ");
                    int indiceModulo = scanner.nextInt();

                    // Calculamos que o índice sexa válido
                    if (indiceModulo < 0 || indiceModulo >= modulos) {
                        System.out.println("Erro: índice de módulo inválido.");
                        break;
                    }

                    // Contamos cantos alumnos están aprobados nese módulo
                    int aprobados = 0;
                    for (int i = 0; i < alumnos; i++) {
                        if (clase[i][indiceModulo] >= 5) {
                            aprobados++;
                        }
                    }

                    // Calculamos o porcentaxe de aprobados
                    double porcentajeAprobados = (double) aprobados / alumnos * 100;

                    // Mostramos o resultado
                    System.out.println(
                            "Porcentaje de aprobados en el módulo " + indiceModulo + ": " + porcentajeAprobados + "%");

                    break;
                }

                case 3 -> {

                    System.out.println("Saíndo");

                    return;
                }

                default -> {
                    System.out.println("Erro.");
                    break;
                }
            }
        }
    }
}
