package Vista;

import Controlador.TendaMusica;

public class MenuInicio extends Menu {

    @Override
    protected void mostrar() {

        boolean menuActivo = true;

        System.out.println("\n-----------------");
        System.out.println("Benvido a Musi.com!");
        System.out.println("\t1. Inicio de sesión: ");
        System.out.println("\t2. Rexistrarse: ");

        int option = getInt("> ");

        while (menuActivo) {

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

                            break;
                        }

                        /**
                         * Administrador
                         */
                        case 2 -> {
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

                    while (menuRexistro) {
                        System.out.println("\nQue tipo de usuario quere rexistrar?");
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
                                
                                

                                System.out.println("Cliente rexistrado correctamente!");
                                menuRexistro = false;
                                break;
                            }
                            
                            /**
                             * Administrador
                             */
                            case 2 -> {

                                

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
