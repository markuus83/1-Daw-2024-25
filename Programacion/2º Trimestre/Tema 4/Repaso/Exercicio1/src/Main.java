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
            System.out.println("\t2. Respondere cuestionario:");
            System.out.println("\t3. Mostrar resultados:");
            System.out.println("\t4. Saír:");
            
            System.out.print("Ingrese a opción desexada: ");
            int option = scanner.nextInt();

            switch (option) {

                /**
                 *  · Engadir Pregunta:
                 * 
                 *  Cada pregunta consta de número indeterminado de respostas. O porgrama primeiro pedirá a pregunta, e a continuación pedirá un número de 2 respostas. A partir de aí, cada vez que se engada unha resposta preguntaráselle ao usuario se desexa engadir algunha resposta máis.
                 */
                case 1 -> {

                    //Limpamos o búfer
                    scanner.nextLine();

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

                    break;
                }


                /**
                 *  · Mostrar resultados:
                 * 
                 *  Débense mostrar tódalas preguntas cas súas respectivas respostas e para cada resposta a porcentaxe de selección de dita resposta.
                 */
                case 3 -> {

                    //Limpamos o búfer
                    scanner.nextLine();

                    break;
                }
            
                default -> {
                    System.out.println("Erro");
                    break;
                }
            }
        }
    }
}
