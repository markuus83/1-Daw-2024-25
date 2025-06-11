import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Crea un programa en Java para xestionar as horas traballadas polos empregados. Deberás crear un HashMap onde a clave é o DNI dos empregados e o valor é unha ArrayList para almacenar as fixaches(tanto de entrada coma de saída) de dito empregado. O programa contará co seguinte menú.
 * 
 *  a) Fichar entrada/saída
 * 
 *      O usuaro introducirá o seu DNI e almacenarase a hora actual. Tanto as horas de entrada como de saída almacénase nunha mesma lista, polo tanto o primeiro elemento da lista sería a fixache de entrada e o segundo o de saída. Do mesmo modo, o terceiro elemento sería unha fixache de entrada e o cuarto unha fixache de saída. O resto de fixaches seguen o mesmo mecanismo.
 * 
 * 
 *  b) O usuario introducirá o seu DNI e indicarase o seu salario a percibir. Cada hora traballada págase a 12€, aínda que este salario se calcula en función dos minutos traballados. Para realizar o cálculo debes ter en conta só as xornadas terminadas, se por exemplo hai unha fixache de entrada sen a súa saída non se contabilizará.
 * 
 * 
 *  INTRODUCE AO COMEZO DO PROGRAMA DATOS DE PROBA
 * 
 *  NON É NECESARIO COMPROBAR QUE O DNI SEXA CORRECTO
 * 
 *  NON XEREDES NOVAS CLASES. FACEDE TODO NO MÉTODO MAIN()
 */

public class Ejercicio6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean menuActivo = true;
        while (menuActivo) {
            
            System.out.println("\n----------------------");
            System.out.println("BENVIDO A XESTIÓN DE HORAS");
            System.out.println("\ta) Fichar entrada/saída: ");
            System.out.println("\tb) Comprobar salario: ");
            System.out.println("\tc) Saír");

            System.out.print("> ");
            String option = scanner.nextLine();

            switch (option) {

                
                /**
                 * ENGADIR CITA
                 */
                case "a" -> {



                }



                /**
                 * ELIMINAR CITA
                 */
                case "b" -> {
                    
                    
                }



                /**
                 * SAÍR
                 */
                case "c" -> {
                    System.out.println("Saíndo...");
                    menuActivo = false;
                }



                /**
                 * ERRO
                 */
                default -> {
                    System.out.println("Erro. Opción inválida!");
                }
            }
        }
    }
}
