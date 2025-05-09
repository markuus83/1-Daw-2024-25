package vista;

public class MenuCliente extends Menu {

    @Override
    protected void mostrar() {
        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println("\n-----------------------");
            System.out.println("\nBenvido ao menu de Clientes: ");
            System.out.println("\t1. Buscar Libro por título: ");
            System.out.println("\t2. Buscar Libro por autor: ");
            System.out.println("\t3. Consultar data límite de devolución: ");
            System.out.println("\t4. Saír: ");

            int option = getInt("> ");

            switch (option) {

                case 1 -> {

                    break;

                }

                case 2 -> {

                    break;
                }

                case 3 -> {

                    break;
                }

                case 4 -> {
                    System.out.println("Saíndo...");
                    menuActivo = false;
                    break;
                }
            
                default -> {
                    System.out.println("\nErro: Opción inválida!");
                    break;
                }
            }
        }
        
    }
    
}
