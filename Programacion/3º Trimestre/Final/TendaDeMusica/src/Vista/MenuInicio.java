package Vista;

import Utils.TipoUsuario;

import java.util.HashMap;

import Modelo.Users.Usuario;

public class MenuInicio extends Menu {
    
    HashMap<String,Usuario> usuarios = new HashMap<>();

    @Override
    protected void mostrar() {

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
                            new MenuUsuario().run();
                            break; 
                        } else{
                            menuActivo = false;
                            new MenuAdministrador().run();
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


                    String nome = this.getString("\nIngrese o nome: ");
                    String contrasinal = this.getString("\nIngrese o contrasinal: ");

                    if (usuarios.containsKey(nome)) {
                        this.printMessage("Erro: Usuario xa existente!");
                    }

                    boolean menu2 = true;
                    TipoUsuario tipo = TipoUsuario.CLIENTE;

                    while(menu2) {

                        System.out.println();
                        System.out.println("\t1. Cliente: ");
                        System.out.println("\t2. Administrador: ");
    
                        int user = this.getInt("\nEscolla o tipo de usuario: ");
                        
                        switch (user) {
                            case 1 -> {
                                tipo = TipoUsuario.CLIENTE;
                                System.out.println("Ingresado con éxito!");
                                menu2 = false;

                            }

                            case 2 -> {
                                tipo = TipoUsuario.ADMINISTRADOR;
                                System.out.println("Ingresado con éxito!");
                                menu2 = false;
                            }

                            default -> System.out.println("Erro. Opción inválida");
                        }
                    }

                    usuarios.put(nome, new Usuario(nome, Utils.HashPasword.hashPassword(contrasinal), tipo));
                    
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
