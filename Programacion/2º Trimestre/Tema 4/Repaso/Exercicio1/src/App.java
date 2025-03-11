/**
 * A cadea de restaurantes Pollos Hermanos pídenos facer un programa para xestionar as reservas de ceas (só ceas) dos seus restaurantes. Polo tanto deberemos facer un programa en Java co seguinte menú:
 * 
 *  a) Engadir restaurante: Deberemos engadir un restaurante. Deberemos almacenar a cidade e o número de teléfono deste.
 * 
 * 
 *  b) Facer unha reserva: Poderemos anotar unha reserva para un día nun restaurante. O día da reserva egadirase no formato <dd/MM/yyyy> e deberase introducr o nome da cidade para realizar a selección do restaurante. Na reserva deberemos indicar o número de comensais. Debemos ter en conta que cada restaurante tan só pode acoller nun mesmo día a 20 comensais. Se a reserva sobrepasa o límite de comensais non se poderá realizar a reserva. Ademáis tamén se debe indicar o nome de quen realiza a reserva.
 * 
 * 
 *  c) Ver número de comensais do día: Debes de mostrar o número de comensais que hai para o día actua indicando a cidade do restaurante.
 * 
 * 
 *  d) Ver primeiro día do mes sen reservas: Indicarase o número de mes do primeiro día dende o día actual no que non hai reservas pero tan só deste mes indicando a cidade do restaurante. Devolve un obxecto da clase Optional xa que pode ser que non haxa ningún día.
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args){

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        ArrayList <Restaurante> restaurantes = new ArrayList<>();

        while (true) {
            System.out.println("-------------------");
            System.out.println("\nMenú:");
            System.out.println("\t1. Engadir restaurante: ");
            System.out.println("\t2. Facer unha reserva: ");
            System.out.println("\t3. Ver número de comensais do día: ");
            System.out.println("\t4. Ver primeiro día deste mes sen reservas: ");
            System.out.println("\t5. Saír");

            int option = scanner.nextInt();

            switch (option) {

                /**
                 * Engadir restaurante: 
                 * 
                 * Deberemos engadir un restaurante. Deberemos almacenar a cidade e o número de teléfono deste.
                 */
                case 1 -> {

                    //Limpamos o búfer
                    scanner.nextLine();

                    System.out.print("Ingrese o nome do restaurante: ");
                    String nomeRestaurante = scanner.nextLine();

                    System.out.print("Ingrese o número de teléfono: ");
                    String telefonoRestaurante = scanner.nextLine();

                    restaurantes.add(new Restaurante(nomeRestaurante, telefonoRestaurante));
                    
                    break;
                } 
                
                /**
                 * Facer unha reserva: 
                 * 
                 * Poderemos anotar unha reserva para un día nun restaurante. O día da reserva egadirase no formato <dd/MM/yyyy> e deberase introducr o nome da cidade para realizar a selección do restaurante. Na reserva deberemos indicar o número de comensais. Debemos ter en conta que cada restaurante tan só pode acoller nun mesmo día a 20 comensais. Se a reserva sobrepasa o límite de comensais non se poderá realizar a reserva. Ademáis tamén se debe indicar o nome de quen realiza a reserva.
                 * 
                 */
                case 2 -> {

                    break;
                } 


                /**
                 * Ver número de comensais do día: 
                 * 
                 * Debes de mostrar o número de comensais que hai para o día actual indicando a cidade do restaurante.
                 * 
                 */
                case 3 -> {

                    
                    break;
                } 


                /**
                 * Ver primeiro día deste mes sen reservas: 
                 * 
                 * Indicarase o número de mes do primeiro día dende o día actual no que non hai reservas pero tan só deste mes indicando a cidade do restaurante. Devolve un obxecto da clase Optional xa que pode ser que non haxa ningún día.
                 */
                case 4 -> {

                    break;
                } 

                case 5 -> {

                    System.out.println("\nSaíndo...");
                    break;
                } 

                default -> {

                    System.out.println("Erro: Option non válida");
                    break;
                }
                    
            }
        }

    }
}