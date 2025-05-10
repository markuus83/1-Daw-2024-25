package vista;

public class MenuAdministradorBiblioteca extends Menu{

    @Override
    protected void mostrar() {

        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println("\n-----------------------");
            System.out.println("\nBenvido ao menu de Administradores de Bibliotecas: ");
            System.out.println("\t1. Ver exemplares dun libro: ");
            System.out.println("\t2. Realizar préstamo: ");
            System.out.println("\t3. Saír: ");

            int option = getInt("> ");

            switch (option) {

                /**
                 * Ver exemplares dun libro
                 */
                case 1 -> {
                    int idBiblioteca = getInt("Ingrese o ID da biblioteca: ");
                    break;

                }

                /**
                 * Realizar préstamo
                 */
                case 2 -> {

                    break;
                }

                /**
                 * Saír
                 */
                case 3 -> {
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
