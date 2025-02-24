/**
 * 
 * Deséxase realizar un programa para realizar enquisas. O programa contará cun menú cas seguintes opcións:
 * 
 *  a) Engadir pregunta: Cada pregunta consta de número indeterminado de respostas. O programa primeiro pedirá a pregunta, e a continuación pedirá un mínimo de 2 respostas. A partir de aí, cada vez que se engada unha resposta preguntaráselle ao usuario se desexa engadir alguna resposta posible máis.
 * 
 *  b) Responder cuestionario: Débense mostrar tódalas preguntas cas súas respectivas respostas. Para cada unha delas o usuario debe de poder seleccionar nun menú unha das posibles respostas
 * 
 *  c) Mostrar resultados: Débense mostrar tódalas preguntas cas súas respectivas respostas, e para cada resposta a porcentaxe de selección de dita resposta.
 * 
 *  d) Saír
 * 
 * 
 * Introduce ao comezo do programa datos de proba
 */

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
        ArrayList<Resposta> respostas = new ArrayList<Resposta>();

        System.out.println("\nOpcións: ");
        System.out.println("\t1. Engadir pregunta");
        System.out.println("\t2. Responder cuestionario");
        System.out.println("\t3. Mostrar resultados");
        System.out.println("\t4. Saír");

        System.out.print("Escolla a opción deseada : ");
        int option = scanner.nextInt();

        switch (option) {

            /**
             *  · Engadir pregunta:
             * 
             *  Cada pregunta consta de número indeterminado de respostas. O programa primeiro pedirá a pregunta, e a continuación pedirá un mínimo de 2 respostas. A partir de aí, cada vez que se engada unha resposta preguntaráselle ao usuario se desexa engadir alguna resposta posible máis.
             */
            case 1 -> {

                System.out.print("Ingrese o enunciado da pregunta: ");
                String enunciado = scanner.nextLine();

                


                
            
                

                break;
                


            }
               
            /**
             *  · Responder cuestionario:
             * 
             *  Débense mostrar tódalas preguntas cas súas respectivas respostas. Para cada unha delas o usuario debe de poder seleccionar nun menú unha das posibles respostas
             * 
             */
            case 2 -> {


                break;
            }
            
            /**
             *  · Mostrar resultados:
             * 
             *  Débense mostrar tódalas preguntas cas súas respectivas respostas, e para cada resposta a porcentaxe de selección de dita resposta.
             * 
             */
            case 3 -> {


                break;
            }

            /**
             *  · Saír
             */
            case 4 -> {
                System.out.println("Saíndo...");
                return;
            }

            /**
             * Valor por defecto
             */
            default -> {
                System.out.println("Erro: Opción non contemplada.");
                break;
            }
                
        }
    }

    
    
}
