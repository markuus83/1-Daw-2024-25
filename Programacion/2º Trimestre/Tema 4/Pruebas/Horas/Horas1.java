package Pruebas.Horas;

import java.time.LocalDateTime;

public class Horas1 {
    
    public static void main(String[] args) {
        
        LocalDateTime horaActual = LocalDateTime.now();

        int horas = horaActual.getHour();
        int minutos = horaActual.getMinute();
        int segundos = horaActual.getSecond();
        int nanosegundos = horaActual.getNano();

        System.out.println(horas);
        System.out.println(minutos);
        System.out.println(segundos);
        System.out.println(nanosegundos);
    }

}
