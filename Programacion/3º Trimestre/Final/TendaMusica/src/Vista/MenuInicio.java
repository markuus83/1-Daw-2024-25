package Vista;

import Controlador.TendaMusica;
import Modelo.Excepcions.UsuarioExistente;

public class MenuInicio extends Menu {

    @Override
    protected void mostrar() {

        boolean menuActivo = true;

        while (menuActivo) {

            System.out.println("\n-----------------");
            System.out.println("Benvido a Musi.com!");
            System.out.println("\t1. Inicio de sesión: ");
            System.out.println("\t2. Rexistrarse: ");
            System.out.println("\t3. Saír: ");
    
            int option = getInt("> ");

            switch (option) {

                /**
                 * Iniciar sesión
                 */
                case 1 -> {

                    System.out.println("\nIniciar sesión: ");
                    System.out.println("\t1. Cliente");
                    System.out.println("\t2. Administrador");

                    int tipoCliente = getInt("> ");
                    String nome = getString("Nome de usuario: ");
                    String contrasinal = getString("Contrasinal: ");
                    
                    switch (tipoCliente) {

                        /**
                         * Cliente
                         */
                        case 1 -> {

                            //Comprobar que existe o usuario
                            try {

                                if (!(TendaMusica.getInstance().existeNomeUsuario(nome))) {
                                    System.out.println("Erro. Non existe o usuario!");
                                    break;
                                }

                            } catch (UsuarioExistente e) {
                                System.out.println("Erro: " + e.getMessage());
                            }

                            //Comprobar que o usuario é un Cliente
                            if (!(TendaMusica.getInstance().usuarioECliente(nome))) {
                                System.out.println("Erro. O usuario non é un cliente!");
                                break;
                            }
                            
                            //Comprobamos que os datos coinciden
                            if (!TendaMusica.getInstance().comprobarDatosInicio(nome, contrasinal)) {
                                System.out.println("Erro. Datos incorrectos!");
                                break;
                            }
                            
                            //Cambiar de Menu
                            menuActivo = false;
                            new Vista.MenuCliente().run();
                            break;
                        }

                        /**
                         * Administrador
                         */
                        case 2 -> {

                            //Comprobar que existe o usuario
                            try {

                                if (!(TendaMusica.getInstance().existeNomeUsuario(nome))) {
                                    System.out.println("Erro. Non existe o usuario!");
                                    break;
                                }

                            } catch (UsuarioExistente e) {
                                System.out.println("Erro: " + e.getMessage());
                            }

                            //Comprobar que o usuario é un Cliente
                            if (TendaMusica.getInstance().usuarioECliente(nome)) {
                                System.out.println("Erro. O usuario non é un cliente!");
                                break;
                            }

                            //Comprobamos que os datos coinciden
                            if (!TendaMusica.getInstance().comprobarDatosInicio(nome, contrasinal)) {
                                System.out.println("Erro. Datos incorrectos!");
                                break;
                            }

                            //Cambiar de Menu
                            menuActivo = false;
                            new Vista.MenuAdministrador().run();
                            break;
                        }
                    
                        default -> {
                            System.out.println("Erro. Opción inválida!");   
                            break;
                        }
                    }
                    break;
                }
    
                /**
                 * Rexistrarse
                 */
                case 2 -> {

                    boolean menuRexistro = true;

                    String nome = getString("Nome de usuario: ");
                    String contrasinal = getString("Contrasinal: ");

                    while (menuRexistro) {
                        
                        System.out.println("\nQue tipo de usuario quere rexistrar?");
                        System.out.println("\t1. Cliente");
                        System.out.println("\t2. Administrador");
                        int tipoCliente = getInt("> ");

                        switch (tipoCliente) {

                            /**
                             * Cliente
                             */
                            case 1 -> {

                                try {

                                    if (TendaMusica.getInstance().existeNomeUsuario(nome)) {
                                        System.out.println("Erro. Nome de usuario xa existe!");
                                        break;
                                    }

                                } catch (UsuarioExistente e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                    
                                TendaMusica.getInstance().ingresarCliente(nome, contrasinal);
                                System.out.println("Cliente rexistrado correctamente!");
                        
                                menuRexistro = false;

                                break;
                            }

                            /**
                             * Administrador
                             */
                            case 2 -> {

                                try {

                                    if (TendaMusica.getInstance().existeNomeUsuario(nome)) {
                                        System.out.println("Erro. Nome de usuario xa existe!");
                                        break;
                                    }
                                    
                                } catch (UsuarioExistente e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }

                                TendaMusica.getInstance().ingresarAdministrador(nome, contrasinal);
                                System.out.println("Administrador rexistrado correctamente!");
                                    
                                menuRexistro = false;
                                
                                break;
                            } 

                            default -> {
                                System.out.println("Erro. Opción inválida!");
                                break;
                            }
                        }
                    }
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
                 * Inválido
                 */
                default -> {
                    System.out.println("Erro. Opción inválida!");
                    break;
                }
            }
        }
    }
}
