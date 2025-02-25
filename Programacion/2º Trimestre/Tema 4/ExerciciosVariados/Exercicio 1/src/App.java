
/**
 * 
 * Deséxase realizar un programa para realizar enquisas. O programa contará cun menú cas seguintes opcións:
 * 
 *  1. Engadir pregunta: Cada pregunta consta de número indeterminado de respostas. O programa primeiro pedirá a pregunta, e a continuación pedirá un mínimo de 2 respostas. A partir de aí, cada vez que se engada unha resposta preguntaráselle ao usuario se desexa engadir alguna resposta posible máis.
 * 
 *  2. Responder cuestionario: Débense mostrar tódalas preguntas cas súas respectivas respostas. Para cada unha delas o usuario debe de poder seleccionar nun menú unha das posibles respostas
 * 
 *  3. Mostrar resultados: Débense mostrar tódalas preguntas cas súas respectivas respostas, e para cada resposta a porcentaxe de selección de dita resposta.
 * 
 *  4. Saír
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

        while (true) {

            System.out.println("\nOpcións: ");
            System.out.println("\t1. Engadir pregunta");
            System.out.println("\t2. Responder cuestionario");
            System.out.println("\t3. Mostrar resultados");
            System.out.println("\t4. Saír");

            System.out.print("Escolla a opción deseada : ");
            int option = scanner.nextInt();

            switch (option) {

                /**
                 * · Engadir pregunta:
                 * 
                 * Cada pregunta consta de número indeterminado de respostas. O programa
                 * primeiro pedirá a pregunta, e a continuación pedirá un mínimo de 2 respostas.
                 * A partir de aí, cada vez que se engada unha resposta preguntaráselle ao
                 * usuario se desexa engadir alguna resposta posible máis.
                 */
                case 1 -> {
                    scanner.nextLine(); // Limpiamos el búfer del scanner

                    System.out.print("Ingrese o enunciado da pregunta: ");
                    String enunciado = scanner.nextLine();

                    Pregunta pregunta = new Pregunta(enunciado);
                    preguntas.add(pregunta);

                    while (pregunta.precisoMaisRespostas()) {
                        System.out.print("Ingrese un mínimo de dúas respostas: ");
                        String resposta = scanner.nextLine();

                        // Engadimos a resposta para a pregunta
                        pregunta.engadirResposta(new Resposta(resposta));
                    }

                    System.out.println("\n\tDesexa engadir máis respostas?: ");
                    System.out.println("1. Sí ");
                    System.out.println("2. No ");

                    int option2 = scanner.nextInt();
                    scanner.nextLine(); // Limpamos o búfer

                    while (option2 == 1) { // Entramos únicamente cando o usuario elixe Sí
                        System.out.print("Ingrese unha resposta adicional: ");
                        String resposta = scanner.nextLine();
                        pregunta.engadirResposta(new Resposta(resposta));

                        System.out.println("\n\tDesexa engadir máis respostas?: ");
                        System.out.println("1. Sí ");
                        System.out.println("2. No ");

                        option2 = scanner.nextInt();
                        scanner.nextLine(); // Limpamos o búfer
                    }

                    System.out.println("Entendido, moitas grazas!");
                }

                /**
                 * · Responder cuestionario:
                 * 
                 * Débense mostrar tódalas preguntas cas súas respectivas respostas. Para cada
                 * unha delas o usuario debe de poder seleccionar nun menú unha das posibles
                 * respostas
                 * 
                 */
                case 2 -> {

                    // Se non hay preguntas non podemos executar o segundo caso
                    if (preguntas.size() == 0) {
                        System.out.println("Non hai preguntas dispoñibles.");
                        break;
                    }

                    // Recorremos o array de preguntas e indexamos cada pregunta
                    for (int i = 0; i < preguntas.size(); i++) {
                        Pregunta pregunta = preguntas.get(i);
                        System.out.println("Pregunta " + (i + 1) + ": " + pregunta.getEnunciadoPregunta());

                        // Recorremos as respostas de cada pregunta e as indexamos
                        ArrayList<Resposta> respostas = pregunta.getRespostas();
                        for (int j = 0; j < respostas.size(); j++) {
                            System.out.println("\t" + (j + 1) + ". " + respostas.get(j).getContidoResposta());
                        }

                        // Solicitamos ao usuario que seleccione unha resposta
                        System.out.print("Seleccione unha resposta (1-" + respostas.size() + "): ");
                        int seleccion = scanner.nextInt();

                        // Validamos a selección do usuario
                        if (seleccion < 1 || seleccion > respostas.size()) {
                            System.out.println("Selección inválida. Por favor, intente de novo.");
                            i--; // Volvemos a preguntar a mesma pregunta
                        } else {
                            // Incrementamos o contador de seleccións da resposta seleccionada
                            respostas.get(seleccion - 1).incrementarSeleccion();
                        }
                    }
                    break;
                }

                /**
                 * · Mostrar resultados:
                 * 
                 * Débense mostrar tódalas preguntas cas súas respectivas respostas, e para cada
                 * resposta a porcentaxe de selección de dita resposta.
                 * 
                 */
                case 3 -> {
                    // Verificamos si hay preguntas disponibles
                    if (preguntas.isEmpty()) {
                        System.out.println("Non hai preguntas dispoñibles.");
                        break;
                    }

                    // Recorremos la lista de preguntas
                    int numPregunta = 1;
                    for (Pregunta pregunta : preguntas) {
                        System.out.println("Pregunta " + numPregunta + ": " + pregunta.getEnunciadoPregunta());
                        numPregunta = numPregunta + 1;

                        // Calculamos el total de selecciones para esta pregunta
                        int totalSeleccions = 0;
                        for (Resposta resposta : pregunta.getRespostas()) {
                            totalSeleccions = totalSeleccions + resposta.getContador();
                        }

                        // Recorremos la lista de respuestas para mostrar los resultados
                        int numResposta = 1;
                        for (Resposta resposta : pregunta.getRespostas()) {
                            double porcentaxe = 0;
                            if (totalSeleccions > 0) {
                                porcentaxe = (resposta.getContador() * 100.0) / totalSeleccions;
                            }

                            // Mostramos la respuesta con su número de selecciones y porcentaje sin
                            // formatear
                            System.out.println("\t" + numResposta + ". " + resposta.getContidoResposta() + " (" +
                                    resposta.getContador() + " seleccións, '" + porcentaxe + "' %)");

                            numResposta = numResposta + 1;
                        }
                    }
                    break;
                }

                /**
                 * · Saír
                 */
                case 4 -> {
                    System.out.println("\nSaíndo...");
                    scanner.close();
                    return;
                }

                /**
                 * Valor por defecto
                 */
                default -> {
                    System.out.println("\nErro: Opción non contemplada.");
                    break;
                }

            }
        }
    }

}

/**
 * #TODO:
 * Terminar el case 2 -> Necesito ser capaz de cubrir el cuestionario
 * HACER EL CASE -> 3
 */