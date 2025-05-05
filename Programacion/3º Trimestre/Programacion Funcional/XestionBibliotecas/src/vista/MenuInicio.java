package vista;

public class MenuInicio extends Menu{

    @Override
    protected void mostrar() {

        boolean menuActivo = true;
        while (menuActivo) {

            System.out.println("\nBenvidos a xestión de Bibliotecas galegas: ");
            System.out.println("\t1. Iniciar sesión: ");
            System.out.println("\t2. Rexistrarse: ");
            System.out.println("\t3. Saír: ");

            int option = getInt("> ");

            switch (option) {

                /**
                 * Iniciar Sesión
                 */
                case 1 -> {
                    
                }

                /**
                 * Rexistrarse
                 */
                case 2 -> {
                    
                    
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
                default-> {
                    System.out.println("Erro. Opción inválida!");
                    break;
                }
            }
        }
    }
   
}
