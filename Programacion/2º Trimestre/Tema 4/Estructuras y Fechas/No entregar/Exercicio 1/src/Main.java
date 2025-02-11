import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 * Fai un programa en Java que reciba e a hora de comezo dun programa de televisión no formato <HH :MM> e a súa duración en minutos e indique a hora de finalización no formato <HH:MM> .
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Inicio do programa
        System.out.println("Introduce a hora de comezo do programa (HH:MM): ");
        String horaComezo = scanner.nextLine();

        //Duración do programa
        System.out.println("Introduce a duración en minutos: ");
        int duracion = scanner.nextInt();

        //Convertimos a hora ao formato
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaInicio = LocalTime.parse(horaComezo, formato);

        //Calculamos a hora de finalización
        LocalTime horaFin = horaInicio.plusMinutes(duracion);

        System.out.println("A hora de finalización do programa é: " + horaFin.format(formato));

        scanner.close();
    }
}