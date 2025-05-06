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
            System.out.println("\t34. Saír: ");

            int option = getInt("> ");

            switch (option) {

                /**
                 * Nova Biblioteca
                 */
                case 1 -> {

                    break;

                }

                /**
                 * Novo Libro
                 */
                case 2 -> {

                    break;
                }

                /**
                 * Novo Libro
                 */
                case 3 -> {

                    break;
                }

                /**
                 * Saír
                 */
                case 4 -> {
                    System.out.println("Saíndo...");
                    menuActivo = false;
                    break;
                }
            
                /**
                 * Erro
                 */
                default -> {
                    System.out.println("Erro: Opción inválida!");
                    break;
                }
            }
        }
        
    }
    
}
