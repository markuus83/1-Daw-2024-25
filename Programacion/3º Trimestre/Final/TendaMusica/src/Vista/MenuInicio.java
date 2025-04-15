package Vista;

import Controlador.TendaMusica;
import Modelo.Excepcions.UsuarioExistente;
import Modelo.Excepcions.UsuarioNonExiste;

public class MenuInicio extends Menu {

    @Override
    protected void mostrar() {

        boolean menuActivo = true;
        while (menuActivo) {

            System.out.println("\nBenivos a nosa tenda Musi.com");
            System.out.println("\t1. Iniciar sesión: ");
            System.out.println("\t2. Rexistrarse: ");
            System.out.println("\t3. Saír: ");

            int option = getInt("> ");

            switch (option) {

                /**
                 * Iniciar Sesión
                 */
                case 1 -> {
                    
                    String nome = getString("Ingrese o nome de usuario: ");
                    String contrasinal = getString("Ingrese o contrasinal: ");

                    boolean menuTipoUser = true;

                    while (menuTipoUser) { 

                        System.out.println("\n Escolla o tipo de usuario: ");
                        System.out.println("1. Cliente: ");
                        System.out.println("2. Administrador");
                        
                        int optionTipoUser = getInt("> ");

                        switch (optionTipoUser) {

                            /**
                             * Ingreso Cliente
                             */
                            case 1 -> {

                                //Comprobamos que existe o usuario
                                try {
                                    
                                    TendaMusica.getInstance().nonExisteUsuario(nome);
                                    
                                } catch (UsuarioNonExiste e) {
                                    System.out.println("Erro: "+e.getMessage());
                                }

                                //Comprobamos que os datos son correctos
                                if (!TendaMusica.getInstance().comprobarDatos(nome, contrasinal)) {
                                    System.out.println("Erro. O usuario ou o contrasinal son inválidos");  
                                }

                                new Vista.MenuCliente().run();
                                menuTipoUser = false;
                                menuActivo = false;
                                break;
                            }
                            
                            /**
                             * Ingreso Administrador
                             */
                            case 2 -> {

                                //Comprobamos que existe o usuario
                                try {
                                    
                                    TendaMusica.getInstance().nonExisteUsuario(nome);
                                    
                                } catch (UsuarioNonExiste e) {
                                    System.out.println("Erro: "+e.getMessage());
                                }

                                //Comprobamos que os datos son correctos
                                if (!TendaMusica.getInstance().comprobarDatos(nome, contrasinal)) {
                                    System.out.println("Erro. O usuario ou o contrasinal son inválidos");  
                                }

                                new Vista.MenuAdministrador().run();
                                menuTipoUser = false;
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

                /**
                 * Rexistrarse
                 */
                case 2 -> {
                    
                    String nome = getString("\nIngrese o seu nome de usuario: ");
                    String contrasinal = getString("Ingrese o seu contrasinal: ");

                    boolean menuEscollaTipoUser = true;

                    while (menuEscollaTipoUser) {

                        System.out.println("\nEscolla o tipo de usuario: ");
                        System.out.println("1. Cliente: ");
                        System.out.println("2. Administrador: ");

                        int tipoUser = getInt(">: ");

                        switch (tipoUser) {

                            /**
                             * Rexistro Cliente
                             */
                            case 1 -> {
                                
                                try {
                                    
                                    if(TendaMusica.getInstance().existeUsuario(nome)){
                                        TendaMusica.getInstance().ingresarCliente(nome, contrasinal);

                                        System.out.println("\nCliente ingresado con éxito!");
                                    }

                                } catch (UsuarioExistente e) {
                                    System.out.println("Erro: "+e.getMessage());
                                }

                                menuEscollaTipoUser = false;
                                break;
                            }

                            /**
                             * Rexistro Administrador
                             */
                            case 2 -> {

                                try {
                                    
                                    if(TendaMusica.getInstance().existeUsuario(nome)){
                                        TendaMusica.getInstance().ingresarAdministrador(nome, contrasinal);

                                        System.out.println("\nAdministrador ingresado con éxito!");
                                    }

                                } catch (UsuarioExistente e) {
                                    System.out.println("Erro: "+e.getMessage());
                                }

                                menuEscollaTipoUser = false;
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
                    break;
                }

                /**
                 * Saír
                 */
                case 3 -> {
                    System.out.println("Saíndo...");
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