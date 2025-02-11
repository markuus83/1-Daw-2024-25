package Pruebas.Horas;

import java.time.Period;
import java.time.*;

public class HorasPeriod {
    
    public static void main(String[] args) {
        
        /**
         * CLASE PERIOD
         */

        Period tresAnosDousMesesCincoDias = Period.of(3, 2, 5);

        System.out.println(tresAnosDousMesesCincoDias);


        //Period para obter o tempo entre dúas datas

        LocalDate inicio = LocalDate.of(2020, 1, 1);
        LocalDate fin = LocalDate.of(2023, 10, 17);

        Period intervalo = Period.between(inicio, fin);
        System.out.println(intervalo);

        
        //Obter valores precisos da resta:
        int anos = intervalo.getYears();
        int meses = intervalo.getMonths();
        int dias = intervalo.getDays();
        System.out.println("\nAnos: " + anos);
        System.out.println("Meses: " + meses);
        System.out.println("Dias: " + dias);

    }

}
