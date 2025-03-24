import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ArrayList<Hotel> hoteles = new ArrayList<>();
        
        boolean menuActivo = true;

        while(menuActivo) {
            System.out.println("a) Dar de alta un hotel");
            System.out.println("b) Dar de alta unha habitación nun hotel");
            System.out.println("c) Buscador de habitacións libres nun hotel");
            System.out.println("d) Reservar unha habitación nun hotel");
            System.out.println("e) Ver porcentaxe de ocupación dun determinado día nun hotel");
            System.out.println("s) Sair");

            String opcion = sc.nextLine();

            switch (opcion) {

                /**
                 *  · Dar de alta un hotel:
                 * 
                 *  Tan só se deberá de indicar un nome.
                 */
                case "a" -> {

                    //Limpamos o búfer
                    sc.nextLine();

                    System.out.print("\nIngrese o nome do hotel: ");
                    String nomeHotel = sc.nextLine();

                    //Engadimos o hotel ao ArrayList
                    hoteles.add(new Hotel(nomeHotel));

                    System.out.println("Dado de alta correctamente!\n");
                } 

                /**
                 *  · Dar de alta unha habitación nun hotel:
                 * 
                 *  As habitacións poden ser individuais, dobres ou triples. ADemais deberá introducirse o hotel a cal pertence (seleccionando mediante un menú), número de habitación (deberas comprobar que no mesmo hotel non hai dúas habitacións co mesmo número) e o prezo da noite.
                 */
                case "b" ->  {

                    //Limpamos o búfer
                    sc.nextLine();

                    if (hoteles.isEmpty()) {
                        System.out.println("Erro. Non existen hoteis");
                    }

                    System.out.print("\nIngrese o tipo de habitación: (Simple - Dobre - Triple) ");
                    String tipoHabitacion = sc.nextLine();

                    if (!(tipoHabitacion.equals("Simple")) || (tipoHabitacion.equals("Dobre")) || (tipoHabitacion.equals("Triple"))) {
                        
                        //O valor por defecto dunha habitación será "Simple"
                        tipoHabitacion = "Simple";
                    }

                    System.out.print("Ingrese o ID da habitación: ");
                    int id = sc.nextInt();

                    System.out.print("Ingrese o prezo da habitación: ");
                    double prezo = sc.nextDouble();

                    //Facemos un salto de liña
                    System.out.println();

                    //Amosamos todos os hoteles dispoñibles
                    for (int i = 0; i < hoteles.size(); i++) {

                        Hotel h = hoteles.get(i);
                        System.out.println("Hotel " + (i) +": " + h.getNomeHotel());

                    }

                    System.out.println("\nIngrese a qué hotel desexa engadir a habitación: ");
                    int hotelEngadir = sc.nextInt();

                    if (hotelEngadir < 0 || hotelEngadir > hoteles.size()) {
                        System.out.println("Erro. Non existe ese hotel");

                    } else{

                        ArrayList<Habitacion> habitacions;
                        

                        Hotel h;
                        hoteles.add(hotelEngadir, h.engadirHabitacion(habitacions.add(new Habitacion(tipoHabitacion, id, prezo))));
                    }
                }

                /**
                 *  · Buscador de habitacións libres nun hotel:
                 * 
                 *  
                 */
                case "c" -> {

                    //Limpamos o búfer
                    sc.nextLine();

                }

                /**
                 *  · Reservar unha habitación nun hotel:
                 * 
                 *  
                 */
                case "d" -> {

                    //Limpamos o búfer
                    sc.nextLine();

                }

                /**
                 *  · Ver porcentaxe de ocupación dun determinado día nun hotel:
                 * 
                 *  
                 */
                case "e" -> {

                    //Limpamos o búfer
                    sc.nextLine();

                }


                /**
                 *  · Saír
                 */
                case "s" -> {
                    System.out.println("Saindo");
                    menuActivo = false;
                }

                default -> System.out.println("Opcion inválida");


            }
        }
        sc.close(); // Cerramos o teclado

    }


}
