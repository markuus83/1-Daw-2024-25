import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Fai un programa en Java que reciba o día de nacemento dunha peroa no fotmato <dd-mm-yyyy> e indique:
 * 
 *  · A idade da persoa.
 *  · O tempo en días para o seu aniversario se aínda non se produciu neste ano. Se este ano xa pasou, indicaranse os días que fau que pasou. En caso que hoxe sexa o día do seu aniversario indicarase por pantalla.
 * 
 *  · O día da semana do seu próximo aniversario, sexa o ano actual ou no seguinte. Se hoxe está de aniversario mostrarase o do ano que ven. 
 */

public class Exercicio2Solucion {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese a data de nacemento da persoa (dd-mm-yyyy): ");
        String dataNacementoString = scanner.nextLine();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        LocalDate dataNacemento = LocalDate.parse(dataNacementoString, formato);

        LocalDate ahora = LocalDate.now();

        Period diferenza = Period.between(dataNacemento, ahora);

        System.out.println("A idade da persoa é: " + diferenza.getYears() + " anos.");

        LocalDate proximoAniversario = dataNacemento.withYear(ahora.getYear());
        if (proximoAniversario.isBefore(ahora) || proximoAniversario.isEqual(ahora)) {
            proximoAniversario = proximoAniversario.plusYears(1);
        }

        long diasParaAniversario = java.time.temporal.ChronoUnit.DAYS.between(ahora, proximoAniversario);
        if (diasParaAniversario == 0) {
            System.out.println("Hoxe é o día do seu aniversario!");
        } else if (proximoAniversario.getYear() == ahora.getYear()) {
            System.out.println("Faltan " + diasParaAniversario + " días para o seu aniversario.");
        } else {
            System.out.println("O seu aniversario foi fai " + Math.abs(diasParaAniversario) + " días.");
        }

        System.out.println("O día da semana do seu próximo aniversario é: " + proximoAniversario.getDayOfWeek());

        scanner.close();
    }
}