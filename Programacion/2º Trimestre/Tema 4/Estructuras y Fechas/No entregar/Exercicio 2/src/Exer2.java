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

public class Exer2 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        //Obtemos a data de nacemento
        System.out.println("Ingrese a data de nacemento da persoa (dd-mm-yyyy): ");
        String dataNacementoString = scanner.nextLine();

        //Establecemos o formato
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        //Convertimos a data de nacemento en tipado Date
        LocalDate dataNacemento = LocalDate.parse(dataNacementoString, formato);

        //Obtemos a data actual
        LocalDate ahora = LocalDate.now();

        //Obtemos a diferenza entre a data de nacemento e a data actual
        Period diferenza = Period.between(dataNacemento, ahora);

        System.out.println("A idade da persoa é: " + diferenza.getYears() + " anos.");

        

        
        scanner.close();
    }
}