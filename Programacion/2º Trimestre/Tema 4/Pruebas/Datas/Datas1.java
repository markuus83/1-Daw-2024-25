package Pruebas.Datas;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Datas1 {
    
    public static void main(String[] args) {

        //Imprimimos
        LocalDate data1 = LocalDate.of(2016,2, 12);
        LocalDate ahora = LocalDate.now();
        System.out.println(data1 +  "\t" + ahora);

        //Podemos utilizar o nome do mes para imprimir o seu valor numérico
        LocalDate data2 = LocalDate.of(2016, Month.FEBRUARY, 12); 
        System.out.println("\n"+data2);

        //A través do valor dunha variable, podemos obter os seus atributos
        int ano = ahora.getYear();
        int mes = ahora.getMonthValue();
        int dia = ahora.getDayOfMonth();
        System.out.println("\nAno: " + ano + "|| Mes: " + mes + "|| Día: " + dia);

        //Tamén podemos obter os días da semana a través dunha variable
        DayOfWeek diaSemana = ahora.getDayOfWeek(); 
        System.out.println("\n"+diaSemana);

        //Podemos aumentar ou diminuír o valor dunha data
        LocalDate data3 = data1.plus(11,ChronoUnit.YEARS);
        System.out.println("\n"+data3);

        //Comparación de datas
        boolean eAntes = data1.isBefore(ahora);
        boolean eDespois = data1.isAfter(ahora);
        boolean eIgual = data1.isEqual(ahora);
        System.out.println("\n" + eAntes);
        System.out.println("\n" + eDespois);
        System.out.println("\n" + eIgual);
    }

}
