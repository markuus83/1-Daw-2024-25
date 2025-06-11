import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Crea un programa que xestione as citas dunha consulta médica. Deberas almacenar para cada paciente o día e hora da súa cita. Utiliza un ArrayList para os nomes dos pacientes (ArrayList<string>) e outro para as citas (ArrayList<LocalDateTime>). O programa contará co seguinte menú:
 * 
 *  a) Engadir cita: 
 * 
 *      Engadirá o nome do paciente e a súa cita. A cita introducirase co seguinte formato -> HH:mm dd/MM/yyyy. Comprobarase que non existen citas 30 minutos antes ou 30 minutos despois. Ademais non se pode engadir unha cita un sábado ou domingo. Se acontecera algún destes casos informarase ao usuario que non se puido realizar a cita.
 * 
 *  b) Eliminar cita: 
 *  
 *      Mostraranse as citas, indicando o paciente e día e hora no seguinte formato dd/MM/yyyy HH:mm, nun menú para seleccionar a cita a eliminar.
 * 
 * 
 *  c) Seleccionar data: 
 * 
 *      Introducirase unha data co formato dd-MM-yyyy e mostraranse as citas dese día. Non teñen que mostrarse en orde.
 */

public class Ejercicio5 {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Estructuras de datos
        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<LocalDateTime> citas = new ArrayList<>();


        // Datos de proba
        clientes.add("Cliente 1");
        clientes.add("Cliente 2");
        clientes.add("Cliente 3");
        clientes.add("Cliente 4");
        clientes.add("Cliente 5");
        citas.add(LocalDateTime.of(2004, 1, 1, 12, 30));
        citas.add(LocalDateTime.of(2004, 1, 2, 12, 30));
        citas.add(LocalDateTime.of(2004, 1, 3, 12, 30));
        citas.add(LocalDateTime.of(2004, 1, 5, 12, 30));
        citas.add(LocalDateTime.of(2004, 1, 6, 12, 30));



        // Formatos
        DateTimeFormatter formatoEngadirCita = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        DateTimeFormatter formatoEliminarCita = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter formatoSeleccionarData = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        boolean menuActivo = true;
        while (menuActivo) {
            
            System.out.println("\n----------------------");
            System.out.println("BENVIDO A XESTIÓN DE CITAS DO SERGAS");
            System.out.println("\ta) Engadir cita: ");
            System.out.println("\tb) Eliminar cita: ");
            System.out.println("\tc) Seleccionar data: ");
            System.out.println("\td) Saír");

            System.out.print("> ");
            String option = scanner.nextLine();

            switch (option) {

                /**
                 * ENGADIR CITA
                 */
                case "a" -> {

                    // Pedimos os datos
                    System.out.print("\nIngrese o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Ingrese a súa cita (formato -> HH:mm dd/MM/yyyy): ");
                    String citaTexto = scanner.nextLine();


                    // Convertimos de cadea de texto a obxecto de Hora
                    LocalDateTime citaData = LocalDateTime.parse(citaTexto, formatoEngadirCita);

                    // Comprobamos que non é fin de semana
                    if (citaData.getDayOfWeek().equals(DayOfWeek.SATURDAY) || citaData.getDayOfWeek().equals(DayOfWeek.SUNDAY) ) {
                        System.out.println("Non se pode axenciar unha cita en fin de semana!");
                        break;
                    }

                    // Comprobamos que non existen citas nun rango de 30 min
                    boolean sePuedeEngadir = true;

                    for (LocalDateTime c : citas) {

                        if (c.isAfter(citaData.minusMinutes(30)) && c.isBefore(citaData.plusMinutes(30))) {
                            sePuedeEngadir = false;
                            break;
                        }
                    }

                    // Se existen citas non engadimos
                    if (!sePuedeEngadir) {
                        System.out.println("\nNon se pode engadir a cita");
                        break;
                    } 

                    // Engadimos o Cliente e a Cita 
                    clientes.add(nomeCliente);
                    citas.add(citaData);

                    System.out.println("\n\tCita engadida correctamente!");

                }


                /**
                 * ELIMINAR CITA
                 */
                case "b" -> {
                    
                    // Amosamos o contido do ArrayList
                    if (citas.isEmpty()) {
                        System.out.println("Non existen citas!");
                    }

                    for (int i = 0; i < citas.size(); i++) {
                        LocalDateTime c = citas.get(i);

                        String cita = c.format(formatoEliminarCita);
                        String cliente = clientes.get(i);

                        System.out.println("\n"+i+" - "+cliente+" -> "+cita);
                    }

                    // Pedimos o índice a eliminar
                    System.out.print("\nIngrese o índice da cita a eliminar: ");
                    int indice = scanner.nextInt();

                    // Comprobamos que índice é válido
                    if (indice < 0 || indice > citas.size()) {
                        System.out.println("\nErro. Índice inválido!");
                        break;
                    }

                    // Eliminamos
                    clientes.remove(indice);
                    citas.remove(indice);

                    System.out.println("\n\tCita eliminada exitosamente!");
                    break;
                }


                /**
                 * SELECCIONAR DATA
                 */
                case "c" -> {
                    
                    // Pedimos datos
                    System.out.print("\nIngrese unha data para ver as citas de ese día (dd-MM-yyyy): ");
                    String dataTexto = scanner.nextLine();

                    // Convertemos a obxecto de hora
                    LocalDate data = LocalDate.parse(dataTexto, formatoSeleccionarData);

                    // Recorremos o ArrayList de citas
                    for (LocalDateTime c : citas) {

                        LocalDate cita = LocalDate.of(data.getYear(), data.getMonth(), data.getDayOfMonth());



                        /**NOTE - 
                         * IMPORTANTE ->
                         * 
                         *  Tengo que convertir el objeto c en un LocalDate (antes era un LocalDateTime) par apoder realizar correctamente el .equals()
                         */
                        if (c.toLocalDate().equals(cita)) {
                            System.out.println("\n"+c.getDayOfMonth()+"/"+c.getMonthValue()+"/"+c.getYear());
                        }
                    }

                }


                /**
                 * SAÍR
                 */
                case "d" -> {
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
