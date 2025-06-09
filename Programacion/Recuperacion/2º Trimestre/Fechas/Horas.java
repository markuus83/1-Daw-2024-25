import java.time.LocalTime;

public class Horas {
    public static void main(String[] args) {
        

        LocalTime horaActual = LocalTime.now();

        System.out.println("\n\tTipado de clase -> "+horaActual.getClass());
        System.out.println("\n\tHoras -> "+horaActual.getHour());
        System.out.println("\n\tMinutos -> "+horaActual.getMinute());
        System.out.println("\n\tSegundos -> "+horaActual.getSecond());
        System.out.println("\n\tNanosegundos -> "+horaActual.getNano());
    }
}
