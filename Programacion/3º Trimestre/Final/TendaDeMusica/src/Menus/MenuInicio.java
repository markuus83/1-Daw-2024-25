package Menus;

import Enum.TipoUsuario;
import Excepcions.UsuarioExistente;
import Users.Usuario;
import java.util.HashMap;

public class MenuInicio extends Menu {
    
    HashMap<String,Usuario> usuarios = new HashMap<>();

    @Override
    protected void mostrar() throws IllegalAccessException, UsuarioExistente{

        this.printMessage("\nBenvido a xestión da nosa tenda Musi.com!");
        boolean menuActivo = true;

        while (menuActivo) {
            this.printMessage("\t1. Iniciar sesión: ");
            this.printMessage("\t2. Rexistro de usuario: ");
            this.printMessage("\t3. Saír: ");

            int option = this.getInt("> ");

            switch (option) {

                /**
                 * INICIO SESION
                 */
                case 1 -> {
                    
                    //Pedimos os datos de inicio do user
                    String nome = this.getString("\tIngrese o nome de usuario: ");
                    String contrasinal = this.getString("\tIngrese o contrasinal: ");

                    //Comprobamos se o usuario existe no sistema
                    if (!usuarios.containsKey(nome)) {
                        System.out.println("Este usuario non existe no sistema!");
                    }

                    //Comprobamos que os datos ingresados son correctos
                    Usuario userComprobar = usuarios.get(nome);
                    if (userComprobar.login(nome, contrasinal)) {
                        
                        //Se o usuario é cliente amosamos o menu de cliente. De non selo, amosamos o menú de ADMINISTRADOR
                        if (userComprobar.getTipoUsuario() == TipoUsuario.CLIENTE) {
                            menuActivo = false;
                            new MenuUsuario();
                            break; 
                        } else{
                            menuActivo = false;
                            new MenuAdministrador();
                            break;
                        }

                    } else{
                        System.out.println("\nCredencias incorrectas!!");
                    }

                    break;
                }

                /**
                 * REXISTRO
                 */
                case 2 -> {

                    System.out.println();
                    System.out.println("\t1. Cliente: ");
                    System.out.println("\t2. Administrador: ");

                    int user = this.getInt("\nEscolla o tipo de usuario: ");
                    String nome = this.getString("\nIngrese o nome: ");
                    String contrasinal = this.getString("\nIngrese o contrasinal: ");

                    if (usuarios.containsKey(nome)) {
                        throw new UsuarioExistente("Erro: Usuario xa existente!");
                    }

                    switch (user) {
                        case 1 -> {
                            usuarios.put(nome, new Usuario(nome, Usuario.hashPassword(contrasinal), TipoUsuario.CLIENTE));
                            System.out.println("Ingresado con éxito!");
                        }

                        case 2 -> {
                            usuarios.put(nome, new Usuario(nome, Usuario.hashPassword(contrasinal), TipoUsuario.ADMINISTRADOR));
                            System.out.println("Ingresado con éxito!");
                        }

                        default -> throw new IllegalAccessException("Erro. Opción inválida");
                    }
                    
                    break;
                }

                /**
                 * SAIR
                 */
                case 3 -> {
                    System.out.println("Saíndo...");
                    menuActivo = false;
                    break;
                }

                /**
                 * CAPTURA DE POSIBLE EXCEPCIÓN
                 */
                default -> {
                    throw new IllegalArgumentException("Erro. Opción non contemplada!");
                }
            }
        }
    }
}
