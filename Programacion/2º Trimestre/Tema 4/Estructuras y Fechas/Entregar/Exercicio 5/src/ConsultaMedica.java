import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsultaMedica {
    private ArrayList<String> pacientes;
    private ArrayList<LocalDateTime> citas;

    public ConsultaMedica() {
        pacientes = new ArrayList<>();
        citas = new ArrayList<>();
    }

    public void engadirCita(String nome, LocalDateTime cita) {
        if (cita.getDayOfWeek().getValue() == 6 || cita.getDayOfWeek().getValue() == 7) {
            System.out.println("Non se poden engadir citas en sábado ou domingo.");
            return;
        }

        for (LocalDateTime c : citas) {
            if (Math.abs(cita.compareTo(c)) < 30) {
                System.out.println("Xa existe unha cita 30 minutos antes ou despois.");
                return;
            }
        }

        pacientes.add(nome);
        citas.add(cita);
        System.out.println("Cita engadida correctamente.");
    }

    public void eliminarCita(int index) {
        if (index >= 0 && index < citas.size()) {
            pacientes.remove(index);
            citas.remove(index);
            System.out.println("Cita eliminada correctamente.");
        } else {
            System.out.println("Índice de cita non válido.");
        }
    }

    public void seleccionarData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).toLocalDate().equals(data)) {
                System.out.println(pacientes.get(i) + " - " + citas.get(i).format(formatter));
            }
        }
    }

    public static void main(String[] args) {
        ConsultaMedica consulta = new ConsultaMedica();
        consulta.engadirCita("Paciente 1", LocalDateTime.of(2023, 10, 25, 10, 0));
        consulta.engadirCita("Paciente 2", LocalDateTime.of(2023, 10, 25, 11, 0));
        consulta.engadirCita("Paciente 3", LocalDateTime.of(2023, 10, 26, 10, 0));

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (true) {
            System.out.println("Menú:");
            System.out.println("a) Engadir cita");
            System.out.println("b) Eliminar cita");
            System.out.println("c) Seleccionar data");
            System.out.println("d) Saír");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "a":
                    System.out.print("Nome do paciente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data e hora da cita (HH:mm dd/MM/yyyy): ");
                    String citaStr = scanner.nextLine();
                    LocalDateTime cita = LocalDateTime.parse(citaStr, dateTimeFormatter);
                    consulta.engadirCita(nome, cita);
                    break;
                case "b":
                    for (int i = 0; i < consulta.citas.size(); i++) {
                        System.out.println(i + ") " + consulta.pacientes.get(i) + " - " + consulta.citas.get(i).format(dateTimeFormatter));
                    }
                    System.out.print("Índice da cita a eliminar: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    consulta.eliminarCita(index);
                    break;
                case "c":
                    System.out.print("Data (dd-MM-yyyy): ");
                    String dataStr = scanner.nextLine();
                    LocalDate data = LocalDate.parse(dataStr, dateFormatter);
                    consulta.seleccionarData(data);
                    break;
                case "d":
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción non válida.");
            }
        }
    }
}