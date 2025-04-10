package Menus;

import Enum.TipoUsuario;
import Users.Usuario;
import java.util.HashMap;

public class MenuInicio extends Menu {
    
    HashMap<String,Usuario> usuarios = new HashMap<>();

    @Override
    protected void mostrar() throws IllegalAccessException{

        this.printMessage("\nBenvido a xestión da nosa tenda Musi.com!");
        boolean menuActivo = true;

        while (menuActivo) {
            this.printMessage("\t1. Iniciar sesión: ");
            this.printMessage("\t2. Rexistro de usuario: ");
            this.printMessage("\t3. Saír: ");

            int option = this.getInt("> ");

            switch (option) {
                case 1 -> {


                    String nome = this.getString("\tIngrese o nome de usuario: ");
                    String contrasinal = this.getString("\tIngrese o contrasinal: ");

                    

                    break;
                }

                case 2 -> {

                    System.out.println();
                    System.out.println("\t1. Cliente: ");
                    System.out.println("\t2. Administrador: ");

                    int user = this.getInt("\nEscolla o tipo de usuario: ");
                    String nome = this.getString("\nIngrese o nome: ");
                    String contrasinal = this.getString("\nIngrese o contrasinal: ");

                    if (usuarios.containsKey(nome)) {
                        System.out.println("Este usuario xa existe no sistema.");
                    }

                    switch (user) {
                        case 1 -> {
                            usuarios.put(nome, new Usuario(nome, contrasinal, TipoUsuario.CLIENTE));
                            System.out.println("Ingresado con éxito!");
                        }

                        case 2 -> {
                            usuarios.put(nome, new Usuario(nome, contrasinal, TipoUsuario.ADMINISTRADOR));
                            System.out.println("Ingresado con éxito!");
                        }

                        default -> throw new IllegalAccessException("Erro. Opción inválida");
                    }
                    
                    break;
                }

                case 3 -> {
                    System.out.println("Saíndo...");
                    menuActivo = false;
                    break;
                }

                default -> {
                    throw new IllegalArgumentException("Erro. Opción non contemplada!");
                }
                    
            }
        }
    }
}
