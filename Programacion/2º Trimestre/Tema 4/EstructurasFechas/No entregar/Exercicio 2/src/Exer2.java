import java.time.LocalDate;
import java.time.Period;
import java.time.format.*;
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
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        //Pedimos a idade
        System.out.print("\nIngrese a data de nacemento (dd-mm-yyyy): ");
        String dataNacementoStr = scanner.nextLine();

        scanner.close();
        
        //Convertimos a idade a tipado de Date
        LocalDate dataNacemento = LocalDate.parse(dataNacementoStr, formato);

        //Obtemos a data actual
        LocalDate ahora = LocalDate.now();

        //Calculamos a diferencia
        Period diferenza = Period.between(dataNacemento, ahora);

        System.out.println("\nA persona ten " + diferenza.getYears() + " anos.");


        int diaAno = ahora.getDayOfYear();
        int diaCumple = dataNacemento.withYear(ahora.getYear()).getDayOfYear(); // Ajustar al año actual
        LocalDate proximoAniversario;
        
        if (diaAno == diaCumple) {
            System.out.println("\nHappy Cum!");
            proximoAniversario = dataNacemento.withYear(ahora.getYear() + 1); // Si es hoy, usar el año siguiente

        } else if (diaAno > diaCumple) {
            int diasPasados = diaAno - diaCumple;
            System.out.println("\nO teu aniversario foi fai " + diasPasados + " días.");
            proximoAniversario = dataNacemento.withYear(ahora.getYear() + 1); // Próximo aniversario el próximo año
        
        } else {
            int diasRestantes = diaCumple - diaAno;
            System.out.println("\nFaltan " + diasRestantes + " días para o teu aniversario.");
            proximoAniversario = dataNacemento.withYear(ahora.getYear()); // Próximo aniversario este año
        }
        
        // Mostrar el día de la semana del próximo aniversario
        System.out.println("\nO día da semana do seu próximo aniversario é: " + proximoAniversario.getDayOfWeek());

        
    }
}