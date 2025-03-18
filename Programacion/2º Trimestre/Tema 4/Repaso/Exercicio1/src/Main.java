import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pregunta> preguntas = new ArrayList<>();

        while (true) {

            System.out.println("-----------");
            System.out.println("\nMenú:");
            System.out.println("\t1. Engadir pregunta:");
            System.out.println("\t2. Responder cuestionario:");
            System.out.println("\t3. Mostrar resultados:");
            System.out.println("\t4. Saír:");
            
            System.out.print("\nIngrese a opción desexada: ");
            int option = scanner.nextInt();

            switch (option) {

                /**
                 *  · Engadir Pregunta:
                 * 
                 *  Cada pregunta consta de número indeterminado de respostas. O programa primeiro pedirá a pregunta, e a continuación, pedirá un número de 2 respostas. A partir de aí, cada vez que se engada unha resposta preguntaráselle ao usuario se desexa engadir algunha resposta máis.
                 */
                case 1 -> {

                    //Limpamos o búfer
                    scanner.nextLine();

                    System.out.print("\nEnunciado da pregunta: ");
                    String enunciado = scanner.nextLine();

                    //Engadimos o enunciado correspondente á pregunta
                    Pregunta pregunta = new Pregunta(enunciado);

                    preguntas.add(pregunta);

                    //Engadimos o mínimo de respostas á pregunta
                    while (pregunta.precisoMaisRespostas()) {
                        System.out.print("\nIngrese un mínimo de dúas respostas: ");
                        String contido = scanner.nextLine();

                        //Engadimos a resposta á pregunta correspondente
                        pregunta.engadirResposta(new Resposta(contido, pregunta));
                    }
                    
                    System.out.println("\nDesexa engadir máis respostas?: ");
                    System.out.println("\t1. Sí: ");
                    System.out.println("\t2. No: ");

                    int option2 = scanner.nextInt();
                    scanner.nextLine(); //Limpamos o búfer

                    while (option2 == 1) {
                        System.out.println("Ingrese a resposta adicional: ");
                        String contido = scanner.nextLine();
                        
                        //Engadimos a resposta á pregunta correspondente
                        pregunta.engadirResposta(new Resposta(contido, pregunta));

                        System.out.println("\n\tDesexa engadir máis respostas?: ");
                        System.out.println("1. Sí ");
                        System.out.println("2. No ");

                        option2 = scanner.nextInt();
                        scanner.nextLine(); //Limpamos o búfer
                    }

                    System.out.println("Entendido. Grazas!");
                    break;
                }


                /**
                 *  · Responder cuestionario:
                 * 
                 *  Débense mostrar tódalas preguntas cas súas respectivas respostas. Para cada unha delas o usuario debe de poder seleccionar nun menú unha das posibles respostas.
                 */
                case 2 -> {

                    //Limpamos o búfer
                    scanner.nextLine();

                    if (preguntas.isEmpty()) {
                        //Se non hai preguntas posibles, non as podemos responder.
                        System.out.println("\nNon hai preguntas dispoñibles. Engada primeiro unha pregunta");
                    }


                    //Recorremos o array de preguntas e indexamos cada unha

                    for (int i = 0; i < preguntas.size(); i++) {
                    
                        Pregunta pregunta = preguntas.get(i);
                        System.out.println("\nPregunta " + (i + 1) + ": " + pregunta.getEnunciado());

                        //Xeramos un ArrayList cas respostas para cada pregunta
                        ArrayList<Resposta> respostas = pregunta.getRespostas();
                        
                        //Recorremos o ArrayList de ditas respostas
                        for (int j = 0; j < respostas.size(); j++) {

                            //Indicamos o índice da resposta, accedemos a cada resposta e amosamos o seu contido.
                            System.out.println("\tResposta " + (j + 1) + ": " + respostas.get(j).getContido());
                        }

                        //Pedímoslle ao usuario que seleccione unha resposta
                        System.out.println("Seleccione unha resposta: ");
                        int seleccion = scanner.nextInt();

                        if (seleccion < 1 || seleccion > respostas.size()) {
                            System.out.println("\nErro. Fora de parámetros!");

                            //Volvemos a preguntar a mesma pregunta
                            i--;

                            /**
                             * IMPORTANTE:
                             * 
                             * De non poñer o "i--", o for seguiría iterando sobre a seguinte resposta, polo que quedaríamos sen responder a dita pregunta.
                             */

                        } else{

                            //Incrementamos o contador de dita resposta
                            respostas.get(seleccion - 1).incrementarSeleccion();
                        }
                    }


                    break;
                }


                /**
                 *  · Mostrar resultados:
                 * 
                 *  Débense mostrar tódalas preguntas cas súas respectivas respostas e para cada resposta a porcentaxe de selección de dita resposta.
                 */
                case 3 -> {
                    if (preguntas.isEmpty()) {
                        System.out.println("Non hai preguntas dispoñibles.");
                        break;
                    }
                
                    for (int i = 0; i < preguntas.size(); i++) {
                        Pregunta pregunta = preguntas.get(i);
                        System.out.println("Pregunta " + (i + 1) + ": " + pregunta.getEnunciado());
                
                        ArrayList<Resposta> respostas = pregunta.getRespostas();
                        for (int j = 0; j < respostas.size(); j++) {
                            Resposta resposta = respostas.get(j);
                            System.out.println("\t" + (j + 1) + ". " + resposta.getContido() + " -> " + resposta.calcularPorcentaxeRespostas() + "%");
                        }
                    }
                
                    break;
                }
            
                case 4 -> {

                    System.out.println("Saíndo...");
                }

                default -> {
                    System.out.println("Erro");
                    break;
                }
            }
        }
    }
}
