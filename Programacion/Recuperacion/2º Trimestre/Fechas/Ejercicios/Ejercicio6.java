import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Crea un programa en Java para xestionar as hora traballadas polos empregados. Deberás crear un HashMap onde a clave é o DNI dos empregados e o valor é unha ArrayList para almacenar as fixaches (tanto de entrada como de saída) de dito empregado. O programa contará co seguinte menú:
 * 
 *  a) Fichar Entrada/Saída
 * 
 *      O usuario introducirá o seu DNI e almacenarase a hora actual. Tanto as horas de entrada como de saída almacénase nunha mesma lista, polo tanto o primeiro elemento sería a fixache de entrada e o segundo elemento o de saída. Do mesmo modo, o terceito elemento sería unha fixache de entrada e o cuarto unha fixache de saída. O resto de fixaches seguen o mesmo mecanismo.
 * 
 *      
 */

public class Ejercicio6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        final double prezoHora = 12;
        final double pagoPorMinuto = prezoHora/60;

        HashMap<String, ArrayList<LocalDateTime>> rexistros = new HashMap<>();

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

                    // Pedimos o DNI
                    System.out.print("\nIngrese o seu DNI: ");
                    String dni = scanner.nextLine();

                    // Obtemos a hora actual
                    LocalDateTime horaActual = LocalDateTime.now();
                    
                    // Se existe a clave, engadimos a hora ao ArrayList
                    if (rexistros.containsKey(dni)) {
                        rexistros.get(dni).add(horaActual);

                        System.out.println("\n\t0 -> Fixache engadida correctamente");

                    // Se é unha nova persoa, engadimos os seus datos e inicializamos o seu ArrayList
                    } else {
                        ArrayList<LocalDateTime> fixaches = new ArrayList<>();
                        fixaches.add(horaActual);
                        rexistros.put(dni, fixaches);

                        System.out.println("\n\t1 -> Fixache engadida correctamente");
                    }

                }



                /**
                 * ELIMINAR CITA
                 */
                case "b" -> {

                    // HashMap baleiro
                    if (rexistros.isEmpty()) {
                        System.out.println("Non existen empregados!");
                    }                    

                    // Pedimos datos
                    System.out.print("\nIngrese o seu DNI: ");
                    String dni = scanner.nextLine();

                    // Comprobamos DNI
                    if (rexistros.containsKey(dni)) {

                        double salario = 0.0;

                        ArrayList<LocalDateTime> fixacheUser = rexistros.get(dni);

                        int lonxitude = fixacheUser.size();

                        /**
                         * Recorremos o ArrayList de 2 en 2
                         * 
                         * IMPORTANTE:
                         * 
                         * i + 1, vai ser a hora de fixache correspondente, polo que comprobabos se esta existe
                         */
                        for (int i = 0; i+1 < lonxitude; i = i+2) {
                            

                            LocalDateTime entrada = fixacheUser.get(i);
                            LocalDateTime saída = fixacheUser.get(i+1);

                            long minutos = entrada.until(saída, ChronoUnit.MINUTES);

                            double salarioDia = minutos*pagoPorMinuto;

                            salario += salarioDia;
                        }
                        
                        System.out.println("\n\tO teu salario é: "+salario);
                    } else{
                        System.out.println("Erro. Non existe ningún empregado con ese DNI!");
                    }

                }


                /**
                 * SAÍR
                 */
                case "c" -> {
                    System.out.println("Saíndo...");
                    scanner.close();
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
