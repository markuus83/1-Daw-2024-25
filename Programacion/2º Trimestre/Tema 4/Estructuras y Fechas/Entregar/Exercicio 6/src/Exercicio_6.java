/**
 * Crea un programa en Java para xestionar as horas traballadas polos empregados. Deberás crear un HashMao onde a clave é o DNI dos empregados e o valor é unha ArrayList para almacenar as fixaches (tanto de entrada como de saída) de dito empregado. O programa contará co seguinte menú:
 *
 *  a) Fichar entrada/saída: o usuario introducirá o seu DNI e almacenarase a hora actual. Tanto as horas de entrada como de saída deberán ser almacenadas nunha mesma lista, polo tanto o primeiro elemento da lista sería a fixache de entrada e o segundo a de saída. Do mesmo modo, o terceiro elemento sería unha fixache de entrada e o cuarto unha fixache de saída. O resto de fixaches seguen o mesmo mecanismo.
 *
 * b) Comprobar salario: O usuario introducirá o seu DNI e indicarase o seu salario a percibir. Cada hora traballada págase a 12€, aínda que este salario se calcula en función dos minutos traballados. Para realizar o cálculo debes ter en conta tan só as xornadas terminadas, se por exemplo hai unha fichaxe de entrada sen a súa saída non se contabilizará.
 *
 * Introduce ao comezo do programa datos de proba.
 * Non é necesario comprobar que o DNI sexa correcto.
 */

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Exercicio_6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<LocalDateTime>> registros = new HashMap<>();

        //Datos de proba
        ArrayList<LocalDateTime> registrosA = new ArrayList<>();
        registrosA.add(LocalDateTime.now().minusHours(3));
        registrosA.add(LocalDateTime.now().minusHours(1));
        registros.put("11111111A", registrosA);

        ArrayList<LocalDateTime> registrosB = new ArrayList<>();
        registrosB.add(LocalDateTime.now().minusHours(2));
        registrosB.add(LocalDateTime.now());
        registros.put("22222222B", registrosB);

        ArrayList<LocalDateTime> registrosC = new ArrayList<>();
        registrosC.add(LocalDateTime.now().minusHours(4));
        registrosC.add(LocalDateTime.now().minusHours(2));
        registros.put("33333333C", registrosC);

        ArrayList<LocalDateTime> registrosD = new ArrayList<>();
        registrosD.add(LocalDateTime.now().minusHours(1));
        registrosD.add(LocalDateTime.now().minusMinutes(30));
        registros.put("44444444D", registrosD);

        ArrayList<LocalDateTime> registrosE = new ArrayList<>();
        registrosE.add(LocalDateTime.now().minusHours(5));
        registrosE.add(LocalDateTime.now().minusHours(3));
        registros.put("55555555E", registrosE);


        while (true) {
            
            System.out.println("Menú:");
            System.out.println("1. Fichar entrada/saída");
            System.out.println("2. Comprobar salario");
            System.out.println("3. Salir");

            String opcionStr = scanner.nextLine();
            int opcion = Integer.parseInt(opcionStr);

            switch (opcion) {

                /**
                 * Fichar entrada/saída:
                 * 
                 * O usuario introducirá o seu DNI e almacenarase a hora actual. Tanto as horas de entrada como de saída deberán ser almacenadas nunha mesma lista, polo tanto o primeiro elemento da lista sería a fixache de entrada e o segundo a de saída. Do mesmo modo, o terceiro elemento sería unha fixache de entrada e o cuarto unha fixache de saída. O resto de fixaches seguen o mesmo mecanismo.
                 */
                case 1 -> {

                    //Ingresar o DNI
                    System.out.print("Introduce tu DNI: ");
                    String dni = scanner.nextLine();

                    //Obtemos a hora actual
                    LocalDateTime ahora = LocalDateTime.now();

                    //Engadimos se non existe ou actualizamos se xa existe

                    /**
                     * A mellorar: Pódense sobrescribir as fichaxes xa que non se especifica que non se poden modificar
                     */
                    registros.putIfAbsent(dni, new ArrayList<>());
                    registros.get(dni).add(ahora);

                    System.out.println("Fichaje registrado a las " + ahora);
                }
                    
                /**
                 * Comprobar salario:
                 * 
                 * O usuario introducirá o seu DNI e indicarase o seu salario a percibir. Cada hora traballada págase a 12€, aínda que este salario se calcula en función dos minutos traballados. Para realizar o cálculo debes ter en conta tan só as xornadas terminadas, se por exemplo hai unha fichaxe de entrada sen a súa saída non se contabilizará.
                 */
                case 2 -> {
                    //Ingresar o DNI
                    System.out.print("Introduce tu DNI: ");
                    String dniSalario = scanner.nextLine();

                    //Comprobar se hai rexistros para o DNI
                    if (registros.containsKey(dniSalario)) {

                        ArrayList<LocalDateTime> fichajes = registros.get(dniSalario);
                        long minutosTrabajados = 0;


                        /**
                         * Calcular os minutos traballados co método until para que me calcule sempre a diferenza correcta
                         */
                        for (int i = 0; i < fichajes.size(); i += 2) {
                            if (i + 1 < fichajes.size()) {
                                minutosTrabajados += fichajes.get(i).until(fichajes.get(i + 1), ChronoUnit.MINUTES);
                                
                            }
                        }

                        //Calcular o salario
                        double salario = (minutosTrabajados / 60.0) * 12;
                        System.out.println("Salario a percibir: " + salario + "€");

                    } else {
                        System.out.println("No hay registros para el DNI proporcionado.");
                    }
                }
                
                //Saír
                case 3 -> {
                    System.out.println("Saliendo...");
                    return;
                }

                //Opción non válida
                default -> {
                    System.out.println("Erro: Opción no válida.");
                }
                    
            }
        }
    }
}