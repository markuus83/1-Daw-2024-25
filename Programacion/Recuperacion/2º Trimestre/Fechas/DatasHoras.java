import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DatasHoras {
    public static void main(String[] args) {


        /**
         * PRUEBA 1
         */
        LocalDateTime horaActual = LocalDateTime.now();

        System.out.println("\n\tAños -> "+horaActual.getYear());

        if (horaActual.getMonth() == Month.JUNE) {
            System.out.println("\n\tMes -> Junio");
        }

        System.out.println("\n\tDías -> "+horaActual.getDayOfMonth());

        System.out.println("\n\tHoras -> "+horaActual.getHour());

        System.out.println("\n\tMinutos -> "+horaActual.getMinute());

        System.out.println("\n\tSegundos -> "+horaActual.getSecond());

        System.out.println("\n\tNanosegundos -> "+horaActual.getNano());



        /**
         * PRUEBA 2
         */

        LocalDateTime ahora = LocalDateTime.now();


        //Extraer só a data
        LocalDate data = ahora.toLocalDate();
        System.out.println("\nData -> "+data);


        //Extraer só a hora
        LocalTime hora = ahora.toLocalTime();
        System.out.println("\nHora -> "+hora);
    }
}
