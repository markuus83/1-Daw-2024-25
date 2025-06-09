import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args)  {

        ArrayList<Hotel> hoteles = new ArrayList<>();
        HashMap<Integer,Habitacion> habitacions = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        boolean menuActivo = true;

        while(menuActivo) {

            System.out.println("\n-------------------------");
            System.out.println("\nBenvido á Xestion de Hoteles");
            System.out.println("\ta) Dar de alta un hotel");
            System.out.println("\tb) Dar de alta unha habitación nun hotel");
            System.out.println("\tc) Buscador de habitacións libres nun hotel");
            System.out.println("\td) Reservar unha habitación nun hotel");
            System.out.println("\te) Ver porcentaxe de ocupación dun determinado día nun hotel");
            System.out.println("\ts) Sair");
            System.out.print("> ");
            String opcion = sc.nextLine();

            switch (opcion) {

                /**
                 * Dar de alta un hotel
                 */
                case "a" -> {
                    sc.nextLine();

                    System.out.print("\nIngrese o nome do novo hotel a engadir: ");
                    String nomeHotel = sc.nextLine();

                    hoteles.add(new Hotel(nomeHotel));
                    System.out.println("\nHotel engadido correctamente!");
                } 


                /**
                 * Dar de alta unha habitación
                 */
                case "b" ->  {
                    sc.nextLine();

                    // Ver todos os hoteles
                    verHoteles(hoteles);

                    // Obtemos o hotel
                    System.out.print("\nIngrese o id do hotel: ");
                    int idHotel = sc.nextInt();

                    if (idHotel<0 || idHotel>hoteles.size()|| hoteles.size() == 0) {
                        System.out.println("Erro. Non existe ningún hotel con ese id");
                        break;
                    }

                    
                    
                    // Escollemos o tipo de Habitacion
                    System.out.println("\nEscolla o tipo de habitación: ");
                    System.out.println("\t1. Individual");
                    System.out.println("\t2. Doble");
                    System.out.println("\t3. Triple");
                    System.out.print("> ");
                    String optionTipo = sc.nextLine();
                    

                    TipoHabitacion tipoHabitacion;
                    switch (optionTipo) {
                        case "1" -> {
                            tipoHabitacion = TipoHabitacion.INDIVIDUAL;
                        }
                        case "2" -> {
                            tipoHabitacion = TipoHabitacion.DOBLE;
                        }
                        case "3" -> {
                            tipoHabitacion = TipoHabitacion.TRIPLE;
                        }
                        default-> {
                            tipoHabitacion = TipoHabitacion.INDIVIDUAL;
                        }
                    }

                    // Obtemos o prezo por noite
                    System.out.println("\nIngrese o prezo por noite: ");
                    double prezoNoite = sc.nextDouble();

                    Hotel hotel = hoteles.get(idHotel);


                    Habitacion habitacion = new Habitacion(tipoHabitacion, hotel, prezoNoite);

                    hotel.engadirHabitacion(habitacion);
                    habitacions.put(habitacion.getIdHabitacion(), habitacion);

                    System.out.println("\nHabitación engadida correctamente!");
                }



                /**
                 * Buscar habitacións libres nun hotel
                 */
                case "c" -> {

                }



                /**
                 * Reservar unha habitación de hotel
                 */
                case "d" -> {

                }




                /**
                 * Ver porcentaxe de ocupación nun día dun hotel
                 */
                case "e" -> {

                }



                /**
                 * Saír
                 */
                case "s" -> {
                    System.out.println("Saíndo...");
                    menuActivo = false;
                }

                default -> System.out.println("Opcion inválida");
            }

        }
        sc.close(); 
    }

    public static void verHoteles(ArrayList <Hotel> hoteles){
        for (Hotel hotel : hoteles) {
            System.out.println("\n\t"+hotel.toString());  
        }
    }
}
