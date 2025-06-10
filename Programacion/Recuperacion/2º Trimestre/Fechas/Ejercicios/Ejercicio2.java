import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Fai un programa en Java que reciba o día de nacemento dunha persoa no formato dd-mm-yyyy e indique:
 * 
 *  · A idade da persoa.
 * 
 *  · O tempo en días para o seu aniversario se aínda non se produciu neste ano.
 * 
 *  · Se este ano xa pasou indicarase os días que fai que pasou.
 * 
 *  · En caso de que hoxe sexa o día do seu aniversario indicaráselle por pantalla.
 * 
 *  · O día da semana do seu próximo aniversario, sexa no ano actual ou no seguinte. Se hoxe está de aniversario mostrarase o do ano que ven
 */

public class Ejercicio2 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Pedimos os datos
        System.out.print("Ingrese o súa fecha de nacemento: ");
        String fechaTexto = scanner.nextLine();


        // Establecemos o formato desexado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    /**
     *  PRIMEIRO APARTADO
     */

        // Data en formato obxecto de Tempo
        LocalDate fecha = LocalDate.parse(fechaTexto, formato);

        // Dia actual para avaliar os datos
        LocalDate ahora = LocalDate.now();

        long idade = fecha.until(ahora, ChronoUnit.YEARS);
        System.out.println("\n\tA persoa ten -> "+idade+" anos.");


    /**
     * SEGUNDO APARTADO
     */
        // Creamos un nuevo objeto fecha con los datos de la fecha del cumpleaños para realizar las operaciones de forma más sencilla
        LocalDate proximoCumple = LocalDate.of(ahora.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());

        if (ahora.getDayOfYear() == proximoCumple.getDayOfYear()) {

            System.out.println("\n\tParabéns polo aniversario!");

            // Día da semana
            DayOfWeek diaSemana = ahora.plus(1,ChronoUnit.YEARS).getDayOfWeek();

            System.out.println("\t"+diaSemana);

        } else if (ahora.getDayOfYear() < proximoCumple.getDayOfYear()) {

            long dias = ahora.until(proximoCumple, ChronoUnit.DAYS);

            System.out.println("\n\tFaltan -> "+dias+" días para o aniversario!");

            // Día da semana
            LocalDate diaSemana = ahora.plus(dias, ChronoUnit.DAYS);

            System.out.println("\t"+diaSemana.getDayOfWeek());

        } else {

            long diasPasados = ChronoUnit.DAYS.between(proximoCumple, ahora);

            System.out.println("\n\tO cumpleanos pasou fai "+diasPasados+" días");
        }

          


    }
}
