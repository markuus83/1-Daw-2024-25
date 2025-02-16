/**
 * Crea un programa que xestiones as citas dunha consulta médica. Deberás almacenar para cada paciente o día e ahora da súa cita. Utiliza un ArrayList para os nomes dos pacientes (ArrayList de String) e o outro para as citas (ArrayList de LocalDataTime). O programa contarña co seguinte menú:
 * 
 *  a) Engadir cita: Engadirá o nome do paciente e a súa cita. A cita introducirase co seguinte formato <HH: mm dd/MM/yyyy>. Comprobarase que non existen citas 30 minutos antes ou 30 minutos despois. Ademais non se pode engadir unha cita un sábado ou domingo. Se acontecera algún destes casos informarase ao usuario que non se puido realizar a cita.
 * 
 *  b) Eliminar cita: Mostraranse as citas, indicando o paciente e día e hora no seguinte formato <dd/MM/yyyy HH:mm>, nun menú para seleccionar a cita a eliminar.
 * 
 *  c) Seleccionar data: Introducirase unha data co formato <dd-MM-yyyy> e mostraranse as citas dese día. Non teñen que mostrarse en orde.
 * 
 * Introduce ao comezo do programa datos de proba
 */

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Exercicio_5 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        ArrayList <String> nomes = new ArrayList<>();
        ArrayList <LocalDateTime> citas = new ArrayList<>();

        //Datos Iniciais

            //Nomes
                nomes.add("Nome_1");
                nomes.add("Nome_2");
                nomes.add("Nome_3");
                nomes.add("Nome_4");
                nomes.add("Nome_5");

            //Citas
                //año - Mes - Dia - Hora - Minuto
                citas.add(LocalDateTime.of(2025, 03, 15, 10, 00));
                citas.add(LocalDateTime.of(2025, 03, 15, 11, 30));
                citas.add(LocalDateTime.of(2025, 03, 16, 11, 00));
                citas.add(LocalDateTime.of(2025, 03, 16, 12, 45));
                citas.add(LocalDateTime.of(2025, 03, 17, 9, 50));

        DateTimeFormatter formatoEngadirCita = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        DateTimeFormatter formatoEliminarCita = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm ");
        DateTimeFormatter formatoSeleccionarData = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (true){
            System.out.println("\nIngrese a opción a escoller: ");
            System.out.println("\t1. Engadir cita: ");
            System.out.println("\t2. Eliminar cita: ");
            System.out.println("\t3. Seleccionar data");
            System.out.println("\t4. Saír.");

            System.out.print("Selecciona a opción a escoller: ");
            int option = scanner.nextInt();

            //Limpamos Buffer do Scanner
            scanner.nextLine();


            //Usamos unha estructura de Rule Switch
            switch (option) {

                /**
                 * Engadir cita:
                 * 
                 * Engadirá o nome do paciente e a súa cita. A cita introducirase co seguinte formato <HH:mm dd/MM/yyyy>. Comprobarase que non existen citas 30 minutos antes ou 30 minutos despois. Ademais non se pode engadir unha cita un sábado ou domingo. Se acontecera algún destes casos informarase ao usuario que non se puido realizar a cita.
                 */
                case 1 -> {
                    
                    //Pedimos e ingresamos nome
                    System.out.print("\nIngrese o seu nome: ");
                    String nome = scanner.nextLine();

                    nomes.add(nome);

                    //Pedimos e ingresamos cita
                    System.out.print("\nIngrese a cita co (HH:mm dd/MM/yyyy): ");
                    String citaString = scanner. nextLine();

                    //Validamos o formato da cita
                    LocalDateTime cita = LocalDateTime.parse(citaString, formatoEngadirCita);

                    DayOfWeek diaSemana = cita.getDayOfWeek();

                    //Establecemos condicións para axenciar a cita
                    if (diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY) {
                        System.out.println("Non se poden axenciar citas en Sábados ou Domingos.");

                    } else {

                        //Validamos que non existan citas 30 minutos antes ou 30 minutos despois
                        boolean citaValida = true;
                        
                        for (LocalDateTime c : citas) {

                            if (c.isAfter(cita.minusMinutes(30)) && c.isBefore(cita.plusMinutes(30))) {
                                citaValida = false;
                                break;
                            }
                        }

                        if (!citaValida) {
                            System.out.println("Xa existe unha cita 30 minutos antes ou despois.");

                        } else {
                            citas.add(cita);
                            System.out.println("Cita engadida correctamente.");
                        }
                    }
                    
                    break;
                }
                    
                    
                /**
                 * Eliminar cita:
                 * 
                 * Mostraranse as citas, indicando o paciente e día e hora no seguinte formato dd//MM/yyyy HH:mm, nun menú para seleccionar a cita a eliminar.
                 */
                case 2 -> {

                    System.out.println("\nCitas: ");
                    
                    for (LocalDateTime c : citas) {
                        System.out.println(citas.indexOf(c) + ". " + nomes.get(citas.indexOf(c)) + " - " + c.format(formatoEliminarCita));
                    }

                    System.out.print("\nSeleccione a cita a eliminar: ");
                    int index = scanner.nextInt();

                    if (index >= 0 && index < citas.size()) {
                        nomes.remove(index);
                        citas.remove(index);
                        System.out.println("Cita eliminada correctamente.");
                    } else {
                        System.out.println("Índice de cita non válido.");
                    }
                    break;
                }
                    
                
                /**
                 * Seleccionar data:
                 *
                 * Introducirase unha data co formato <dd-MM-yyyy> e mostraranse as citas dese día. Non teñen que mostrarse en orde.
                 */
                case 3 -> {
                    System.out.print("\nIntroduza a data (dd-MM-yyyy): ");
                    String dataString = scanner.nextLine();

                    LocalDateTime data = LocalDateTime.parse(dataString, formatoSeleccionarData);

                    for (LocalDateTime c : citas) {
                        if (c.toLocalDate().equals(data.toLocalDate())) {
                            System.out.println(nomes.get(citas.indexOf(c)) + " - " + c.format(formatoEliminarCita));
                        }
                    }

                    break;
                }
                    
                    
                // Saír
                case 4 -> {
                    System.out.println("\nSaíndo...");
                    return;
                }
                    

                //Erro
                default -> {

                    System.out.println("\nErro: Ingrese unha opción válida");
                    break;
                }
            }
        }
    }
}