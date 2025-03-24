import java.util.Scanner;

import Clases.Hotel;
import Utils.TipoHabitacion;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ArrayList<Hotel> hoteles = new ArrayList<>();

        boolean menuActivo = true;

        while(menuActivo) {
            System.out.println("\n------------------------------------------");
            System.out.println("MENÚ:");
            System.out.println("\t1. Dar de alta un hotel");
            System.out.println("\t2. Dar de alta unha habitación nun hotel");
            System.out.println("\t3. Buscador de habitacións libres nun hotel");
            System.out.println("\t4. Reservar unha habitación nun hotel");
            System.out.println("\t5. Ver porcentaxe de ocupación dun determinado día nun hotel");
            System.out.println("\t6. Sair");

            System.out.print("\nIngrese a opción desexada: ");
            int opcion = sc.nextInt();

            switch (opcion) {

                /**
                 *  · Dar de alta un hotel:
                 * 
                 *  Tan só se deberá de indicar un nome.
                 * 
                 */
                case 1 -> {
                    //Limpamos o búfer
                    sc.nextLine();

                    System.out.print("\nEngada un nome para o novo hotel: ");
                    String nome = sc.nextLine();

                    hoteles.add(new Hotel(nome));
                    System.out.println("Ingreso correcto!");
                    break;

                } 

                /**
                 *  · Dar de alta unha habitación nun hotel:
                 * 
                 *  As habitacións poden ser individuais, dobres ou triples. Ademais deberá introducirse o hotel a cal pertence (seleccionando mediante un menú), a un número de habitación (deberase comprobar que no mesmo hotel non hai dúas habitacións co mesmo número) e o prezo por noite. 
                 * 
                 */
                case 2 ->  {

                    //Limpamos o búfer
                    sc.nextLine();

                    System.out.println("\nQue tipo de habitación queres: ");
                    System.out.println("\t1. Simple");
                    System.out.println("\t2. Doble");
                    System.out.println("\t3. Triple");

                    System.out.print("Escolla: ");
                    int tipo = sc.nextInt();

                    TipoHabitacion tipo = TipoHabitacion.from


                }

                /**
                 *  · Buscador de habitacións libres nun hotel: 
                 * 
                 *  Débese indicar un día de entrada e un día de saída (ambos formatos como dd/mm/yyyy), o tipo de habitación que se desexa (individual, dobre ou triple) e o hotel (mediante un menú). Mostraranse os números das habitacións libres que coincidan ca busca. NOTA: unha habitación está libre para a entrada aínda que haxa unha reserva que remate ese día.
                 * 
                 */
                case 3 -> {

                    //Limpamos o búfer
                    sc.nextLine();



                }

                /**
                 *  · Reservar unha habitación nun hotel:
                 * 
                 * Introducirase o hotel (mediante un menú), o número de habitación, o día de entrada e saída (ambos formatos como dd/mm/yyyy) e o nome da persoa que realiza a reserva. Deberanse facer tódalas comprobacións necesarias para saber se se pode realizar ou non a reserva. En caso de poder realizarse levarase a cabo a reserva e en caso contrario indicarase por pantalla que non se puido realizar. Ademais cada reserva contará cun identificador único.
                 * 
                 */
                case 4 -> {

                    //Limpamos o búfer
                    sc.nextLine();



                }

                /**
                 *  · Ver porcentaxe de ocupación dun determinado día nun hotel:
                 * 
                 *  Introducirase unha data en formato dd/mm/yyyy e mediante menú seleccionarase un hotel. Indicarase por pantalla a porcentaxe de ocupación das habitacións do hotel ese día. Recorda que se a data de saída é o día indicado, a habitación está libre.
                 * 
                 */
                case 5 -> {
                    
                    //Limpamos o búfer
                    sc.nextLine();



                }


                /**
                 *  · Saír
                 */
                case 6 -> {
                    
                    System.out.println("Saindo");
                    menuActivo = false;
                }

                // Default
                default -> System.out.println("Opcion inválida");


            }
        }
        sc.close(); // Cerramos o teclado

    }
}
