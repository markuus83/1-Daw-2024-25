/**
 * 
 * A cadea de restaurantes Pollos Hermanos pídenos facer un programa para xestionar as reservas de ceas (só ceas) dos seus restaurantes. Polo tanto deberemos facer un programa en Java co seguinte menú: 
 * 
 *  a) Engadir Restaurante -> Deberemos engadir un restaurante. Deberemos almacenar a cidade e o número de telefono deste.
 * 
 * 
 *  b) facer unha reserva -> Poderemos anotar unha reserva para un día nun restaurante. O día da reserva engadirase no formato dd/mm/yyyy e deberase introducir o nome da cidade para realizar a selección do restaurante. Na reserva deberemos indicar o número de comensais. Debemos ter en conta que cada restaurante tan só pode acoller nun mesmo día a 20 comensais. Se a reserva sobrepasa o límite de comensais non se poderá realizar a reserva. Ademais tamén se debe indicar o nome de quen se realiza a reserva.
 * 
 * 
 *  c) Ver número de comensais do día -> Debes de mostrar o número de comensais que hai para o día actual indicando a cidade do restaurante.
 * 
 * 
 *  d) Ver primeiro día deste mes sen reservas -> Indicarase o mes do primeiro día dende o día actual no que non hai reservas pero tan só deste mes indicando a cidade do restaurante. Devolve un obxecto da clase Optional xa que pode ser que non haxa ningún día.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Restaurante> restaurantes = new ArrayList<>();

        while (true) { 
            
            System.out.println("-----------------");
            System.out.println("\nMenú: ");
            System.out.println("\t1. Engadir restaurante: ");
            System.out.println("\t2. Facer unha reserva: ");
            System.out.println("\t3. Ver número de comensais do día: ");
            System.out.println("\t4. Ver primeiro día deste mes sen reservas: ");
            System.out.println("\t5. Saír : ");


            System.out.print("\nIngrese a opción desexada: ");
            int option = scanner.nextInt();

            switch (option) {

                /**
                 *  · Engadir restaurante: 
                 * 
                 *  Deberemos engadir un restaurante. Deberemos almacenar a cidade e o número de telefono deste.
                 * 
                 */
                case 1 -> {

                    //Limpamos o búfer do Scanner
                    scanner.nextLine();

                    System.out.print("Engada a cidade do restaurante: ");
                    String cidade = scanner.nextLine();

                    System.out.print("Engada o número de telefono do restaurante: ");
                    String telefono = scanner.nextLine();

                    if(restaurantes.add(new Restaurante(cidade, telefono))){
                        System.out.println("\nCorrecto!");
                    } else{
                        System.out.println("\nIncorrecto!");
                    }

                    break;
                }


                /**
                 *  · Facer unha reserva -> Poderemos anotar unha reserva para un día nun restaurante. O día da reserva engadirase no formato dd/mm/yyyy e deberase introducir o nome da cidade para realizar a selección do restaurante. Na reserva deberemos indicar o número de comensais. Debemos ter en conta que cada restaurante tan só pode acoller nun mesmo día a 20 comensais. Se a reserva sobrepasa o límite de comensais non se poderá realizar a reserva. Ademais tamén se debe indicar o nome de quen se realiza a reserva.
                 * 
                 * 
                 */
                case 2 -> {

                    //Limpamos o búfer do Scanner
                    scanner.nextLine();

                    break;
                }


                /**
                 * 
                 * 
                 */
                case 3 -> {

                    //Limpamos o búfer do Scanner
                    scanner.nextLine();

                    break;
                }


                /**
                 * 
                 * 
                 */
                case 4 -> {

                    //Limpamos o búfer do Scanner
                    scanner.nextLine();

                    break;
                }


                /**
                 * Saír do programa
                 */
                case 5 -> {

                    System.out.println("\nSaíndo...");
                    return;
                }
                    
                    
                default -> {

                    System.out.println("Erro: opción inválida.");
                    break;
                }
                    
            }

        }

    }

}
