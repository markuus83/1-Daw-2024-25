import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Fai un programa en Java que reciba a hora de comezo de un programa de televisión no formato HH:MM e a súa duración en minutos e indique a hora de finalización no formato HH:MM
 */

public class Ejercicio1 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Establecemos o formato desexado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        
        // Pedimos os datos
        System.out.print("\nIngrese a hora de comezo do programa: ");
        String inicioTexto = scanner.nextLine();

        System.out.print("Ingrese a súa duración en minutos: ");
        int minutos = scanner.nextInt();
        
        // Convertimos a cadea de texto nun obxecto tipo hora para poder operar con el
        LocalTime inicioFecha = LocalTime.parse(inicioTexto);

        // Calculamos o final
        LocalTime finPrograma = inicioFecha.plus(minutos, ChronoUnit.MINUTES);

        // Convertimos de novo a cadea de texto
        String finProgramaTexto = finPrograma.format(formato);

        // Amosamos por consola
        System.out.println("\nO programa rematará as -> "+finProgramaTexto);

        scanner.close();
    }

}