package Vista;

public class MenuCliente extends Menu {

    @Override
    protected void mostrar() {
        
        boolean menuActivo = true;
        
        while (menuActivo) {
            System.out.println("\nBenvido ao menú do Cliente!");
            System.out.println("\t1. Ver perfil");
            System.out.println("\t2. Ver produtos");
            System.out.println("\t3. Saír");

            int option = getInt("> ");

            switch (option) {
                case 1:
                    // Lógica para mostrar o perfil do cliente
                    System.out.println("Mostrando perfil...");
                    break;
                case 2:
                    // Lógica para mostrar produtos ou realizar outra acción
                    System.out.println("Mostrando produtos...");
                    break;
                case 3:
                    System.out.println("Saíndo...");
                    menuActivo = false;
                    break;
                default:
                    System.out.println("Opción inválida!");
                    break;
            }
        }
    }
}
