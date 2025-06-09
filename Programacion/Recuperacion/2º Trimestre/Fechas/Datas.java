import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Datas {
    public static void main(String[] args) {
        
        /**
         * PRIMERA PRUEBA
         */

        LocalDate data1 = LocalDate.now();

        DayOfWeek diaSemana = data1.getDayOfWeek();        

        if (diaSemana.equals(DayOfWeek.MONDAY)) {
            
            System.out.println("\n"+diaSemana.toString());
        }


        /**
         * SEGUNDA PRUEBA
         */

        LocalDate data2 = data1.plus(3,ChronoUnit.MONTHS);
        System.out.println("\n"+data2.getMonth());


        /**
         * TERCERA PRUEBA
         */
        LocalDate fecha1 = LocalDate.of(2025, 1, 1);
        LocalDate fecha2 = LocalDate.now();


        long dias = fecha1.until(fecha2, ChronoUnit.DAYS);
        System.out.println("\t"+dias);
    }
}
