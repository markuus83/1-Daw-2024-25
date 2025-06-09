import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatos {
    public static void main(String[] args) {
        

        /**
         * Obxecto de data e hora a cadea de texto
         */

        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


        LocalDateTime ahora = LocalDateTime.now();

        String dataFormateada = ahora.format(formato1);

        System.out.println("Data e hora formateada -> "+dataFormateada);



        /**
         * Cadea de texto a obxecto de data e hora
         */

        String texto = "17-10-2023 14:30:00";

        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        LocalDateTime datahora = LocalDateTime.parse(texto,formato2);

        System.out.println("Data e hora -> "+datahora);
    }
}
