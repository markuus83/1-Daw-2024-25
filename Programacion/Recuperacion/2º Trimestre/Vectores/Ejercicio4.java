/**
 * Deséxase xestionar aas notas de estudantes dun curso mediante matrices en java. o exercicio consiste en almacenar as notas de varios estudantes en diferentes diferentes módulos.
 * 
 *  · Primeiro indicaranse o número de estudantes.
 * 
 *  · A continuación indicaranse o número de módulos.
 * 
 *  · A continuación engadiranse as notas de cada estudantes módulo a módulo.
 * 
 *  · Unha vez introducisos as notas do alumnado mostrarase o seguinte menú:
 * 
 *      a) Media dun alumno: pedirase o índice dun alumno e calcularase a media das súas notas.
 * 
 *      b) Porcentaxe de aprobados: Calcularase a porcentaxe de aprobados do módulo do que se introduza o índice.
 */

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Pedimos datos
        System.out.print("Ingrese o número de alumnos: ");
        int alumnos = scanner.nextInt();

        System.out.print("Ingrese o número de módulos: ");
        int modulos = scanner.nextInt();

        if (alumnos <= 0 || modulos <= 0) {
            System.out.println("Erro");

            scanner.close();
            return;
        }

        // Inicializamos a Matriz
        int matriz[][] = new int[alumnos][modulos];

        
        // Enchemos os datos
        System.out.println("\nIngrese as notas de alumno módulo a módulo:");
        for (int a = 0; a < alumnos; a++) {
            for (int m = 0; m < modulos; m++) {
                int nota;
                do {
                    System.out.print("Elemento [" + a + "][" + m + "]: ");
                    nota = scanner.nextInt();

                    if (nota < 0 || nota > 10) {
                        System.out.println("Erro: a nota debe estar entre 0 e 10. Inténtao de novo.");
                    }

                } while (nota < 0 || nota>10);
                matriz[a][m]=nota;
            }
        }


        // Observamos os datos da matriz
        mostrarMatriz(matriz);

        // Comezamos co menú
        boolean menuActivo = true;
        while (menuActivo) {
            System.out.println("\nEscolla a opción desexada: ");
            System.out.println("\t1. Media dun alumno");
            System.out.println("\t2. Porcentaxe de aprobados");
            System.out.println("\t3. Saír");

            System.out.print("> ");

            int option = scanner.nextInt();

            switch (option) {

                /**
                 * Media dun alumno
                 */
                case 1 -> {

                    // Para observar datos
                    mostrarMatriz(matriz);

                    System.out.print("Ingrese un índice para calcular a media dun alumno: ");
                    int indice = scanner.nextInt();

                    // Calculamos un índice válido
                    if (indice>alumnos || indice<0) {
                        System.out.println("Erro!");
                        break;
                    }

                    int sumaAlumno = 0; 
                    
                    for (int m = 0; m < modulos; m++) {
                        sumaAlumno += matriz[indice][m];
                    }
                    
                    // Calculamos la media, haciendo una suma de todos los valores entre la cantidad de columnas de dicho índice
                    double media = sumaAlumno/matriz[indice].length;

                    // Amosamos por consola
                    System.out.println("A media do alumno do índice "+indice+" é: "+media);

                    break;
                }
                    

                /**
                 * Porcentaxe de aprobados dun módulo
                 */
                case 2 -> {

                    // Para observar datos
                    mostrarMatriz(matriz);

                    // Pedimos o índice
                    System.out.print("Ingrese o índice do módulo a avaliar: ");
                    int indice = scanner.nextInt();

                    // Avaliamos datos
                    if (indice > modulos || indice < 0) {
                        System.out.println("Erro.");
                        break;
                    }



                    int aprobados = 0;

                    for (int a = 0; a < alumnos; a++) {
                        if (matriz[a][indice] >= 5) {
                            aprobados++;
                        }
                    }

                    // Calculamos a porcentaxe de aprobados
                    double porcentaxeAprobados = (double) aprobados/alumnos * 100;

                    System.out.println("No módulo "+indice+" hai un "+porcentaxeAprobados+"% e aprobados.");
                }


                /**
                 * saír
                 */
                case 3 -> {
                    menuActivo = false;
                    System.out.println("Saíndo...");
                }
            
                /**
                 * Erro
                 */
                default-> {
                    System.out.println("Erro. Opción inválida!");
                    break;
                }
            }
            
        }
        scanner.close();
    }

    /**
     * Método encargado de amosar por consola os datos dunha matriz bidimensional
     * 
     * @param array
     */
    public static void mostrarMatriz(int [][] array){
        
        System.out.println("\nNotas da clase: ");
        for (int a = 0; a < array.length; a++) {
            for (int m = 0; m < array[a].length; m++) {
                System.out.print("   "+array[a][m]);
            }
            System.out.println();
        }
    }
}