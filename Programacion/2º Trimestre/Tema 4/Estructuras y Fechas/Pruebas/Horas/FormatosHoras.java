package Pruebas.Horas;

import java.time.LocalDateTime;
import java.time.format.*;
import java.util.Locale;

public class FormatosHoras {
    
    public static void main(String[] args) {
        
        DateTimeFormatter formatoISO = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter formatoCompleto = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        //Obtener hora con patrones personalizados
        DateTimeFormatter formatoPersonalizado = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


        //********CONVERTER UN OBXECTO DE HORA EN FORMATO DE TEXTO
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String dataFormateada = agora.format(formato1);
        System.out.println("Data e hora formateada: " + dataFormateada);


        //********CONVERTER UN FORMATO DE TEXTO NUN OBXECTO DE DATA E HORA
        String texto = "17-10-2023 14:30:00";
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            //Convertemos unha varaible de string a unha data, co comando .parse(), especificándolle o formato seleccionado
        LocalDateTime dataHora = LocalDateTime.parse(texto, formato2);
        System.out.println("\nData e hora: " + dataHora);


        //FORMATO DE HORA SEFUNDO O PAÍS
        DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.forLanguageTag("es"));
        System.out.println("\nFormato de España: "+formato3);
    }

}
