import java.time.Duration;
import java.time.LocalTime;

public class DurationEjemplo {
    public static void main(String[] args) {
        

        LocalTime inicio = LocalTime.of(14, 30);
        LocalTime fin = LocalTime.of(18, 45);

        Duration duracion = Duration.between(inicio, fin);

        long horas = duracion.toHours();
        long minutos = duracion.toMinutes();
        long segundos = duracion.toSeconds();

        System.out.println("\n\tHoras -> "+horas);
        System.out.println("\n\tMinutos -> "+minutos);
        System.out.println("\n\tSegundos -> "+segundos);
    }
}
