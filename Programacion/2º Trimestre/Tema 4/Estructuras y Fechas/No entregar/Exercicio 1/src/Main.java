import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Fai un programa en Java que reciba e a hora de comezo dun programa de televisión no formato <HH :MM> e a súa duración en minutos e indique a hora de finalización no formato <HH:MM> .
 */

public class Main {
    public static void main(String[] args) {

        LocalDate data1 = LocalDate.of(2016, 2, 12);

        LocalDate data2 = data1.plus(10, ChronoUnit.YEARS);

        System.out.println(data2);
    }
}