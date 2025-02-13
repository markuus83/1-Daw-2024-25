package Fechas.Horas;

import java.time.*;

public class HorasDuration {
    
    public static void main(String[] args) {
        
        Duration tresHoras = Duration.ofHours(3);
        Duration cincoMinutos = Duration.ofMinutes(5);

        System.out.println(tresHoras);
        System.out.println(cincoMinutos);


        //Duration entre dúas instancias temporais
        LocalTime inicio = LocalTime.of(14, 30);
        LocalTime fin = LocalTime.of(18, 45);
        Duration duracion = Duration.between(inicio, fin);
        System.out.println("\n" + duracion);


        //Outros métodos de Duration
        long horas = duracion.toHours();
        long minutos = duracion.toMinutes();
        long segundos = duracion.toSeconds();
        System.out.println("\nTiempo en horas: " + horas);
        System.out.println("Tiempo en minutos: " + minutos);
        System.out.println("Tiempo en segundos: " + segundos);


        //Sumar ou restar unha Duration
        LocalDateTime dataHora = LocalDateTime.of(2023, 10, 17, 14, 0);
        System.out.println(""+dataHora);
        LocalDateTime novaDataHora = dataHora.plus(Duration.ofMinutes(90)); 
        System.out.println(novaDataHora);
    }

}
