package Menus;

public class MenuPrincipal extends Menu {
    
    @Override
    protected void mostrar(){

        this.printMessage("Benvido a xestión da nosa tenda Musi.com!");
        boolean menuActivo = true;

        while (menuActivo) {
            this.printMessage("1. Iniciar sesión: ");
            this.printMessage("2. Rexistro de usuario: ");
            this.printMessage("3. Saír: ");

            int option = this.getInt(">");

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

                default -> {
                    throw new IllegalArgumentException("Erro. Opción non contemplada!");
                }
                    
            }
        }
    }
}
