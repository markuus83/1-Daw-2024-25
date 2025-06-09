import java.time.LocalDate;
import java.time.Period;

public class PeriodEjemplo {
    public static void main(String[] args) {
        
        /**
         * PRUEBA 1
         */
        LocalDate inicio = LocalDate.of(2020, 1, 1);
        LocalDate fin = LocalDate.of(2023, 10, 17);

        Period intervalo = Period.between(inicio, fin);

        int anos = intervalo.getYears();
        int meses = intervalo.getMonths();
        int dias = intervalo.getDays();
    
        System.out.println("\n\tAnos -> "+anos);
        System.out.println("\n\tMeses -> "+meses);
        System.out.println("\n\tDías -> "+dias);
    }
}
