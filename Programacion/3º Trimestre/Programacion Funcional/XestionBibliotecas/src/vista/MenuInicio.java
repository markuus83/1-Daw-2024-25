package vista;

import controlador.XestionBibliotecas;
import utiles.excepcions.BibliotecaTenAdmin;
import utiles.excepcions.BibliotecasNonExiste;
import utiles.excepcions.CorreoInvalido;
import utiles.excepcions.DNIIncorrecto;
import utiles.excepcions.IndiceInvalido;
import utiles.excepcions.UsuarioExistente;
import utiles.excepcions.UsuarioNonExiste;

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
                    String nomeUsuario = getString("\nIngrese o nome de usuario: ");
                    String contrasinal = getString("Ingrese o contrasinal: ");

                    try {

                        XestionBibliotecas.getInstance().nonExisteUsuario(nomeUsuario);
                        
                    } catch (UsuarioNonExiste e) {
                        System.out.println("\nErro: "+e.getMessage());
                        break;
                    }

                    //Comprobamos que os datos son correctos
                    if (!XestionBibliotecas.getInstance().comprobarDatos(nomeUsuario, contrasinal)) {
                        System.out.println("\nErro. O usuario ou o contrasinal son inválidos");
                        break;
                    }

                    //Iniciamos os seus respectivos menús
                    if (XestionBibliotecas.getInstance().eCliente(nomeUsuario)) {
                        new MenuCliente().run();

                    } else if (XestionBibliotecas.getInstance().eAdministradorXeral(nomeUsuario)){
                        new MenuAdministradorXeral().run();
                        
                    } else{
                        new MenuAdministradorBiblioteca().run();
                    }

                }

                /**
                 * Rexistrarse
                 */
                case 2 -> {
                    

                    boolean menuEscollaTipoUser = true;
                    
                    while (menuEscollaTipoUser) {
                        System.out.println("\nEscolla o tipo de usuario: ");
                        System.out.println("\t1. Cliente: ");
                        System.out.println("\t2. Administrador Xeral: ");
                        System.out.println("\t3. Administrador de Biblioteca");

                        int tipoUser = getInt("> ");

                        switch (tipoUser) {

                            /**
                             * Rexistro Cliente
                             */
                            case 1 -> {
                                String nomeUsuario = getString("\nIngrese o nome de usuario: ");
                                String contrasinal = getString("Ingrese o seu contrasinal: ");
                                String nome = getString("\nIngrese o nome do Cliente: ");
                                String apelidos = getString("Ingrese os apelidos: ");
                                String dni = getString("Ingrese o DNI: ");
                                String correo = getString("Ingrese o correo: ");

                                try {
                                    
                                    if(XestionBibliotecas.getInstance().existeUsuario(nomeUsuario)){

                                        XestionBibliotecas.getInstance().ingresarCliente(contrasinal, nomeUsuario, nome, apelidos, dni, correo);

                                    }

                                } catch (UsuarioExistente | DNIIncorrecto | CorreoInvalido e) {
                                    System.out.println("\nErro: "+e.getMessage());
                                    break;
                                }

                                System.out.println("\nCliente ingresado con éxito!");

                                menuEscollaTipoUser = false;
                                break;
                            }


                            /**
                             * Rexistro Administrador Xeral
                             */
                            case 2 -> {

                                try {
                                    String nomeUsuario = getString("\nIngrese o nome de usuario: ");
                                    String contrasinal = getString("Ingrese o seu contrasinal: ");

                                    if(XestionBibliotecas.getInstance().existeUsuario(nomeUsuario)){

                                        XestionBibliotecas.getInstance().ingresarAdministradorXeral(contrasinal, nomeUsuario);
                                        
                                    }

                                } catch (UsuarioExistente e) {
                                    System.out.println("\nErro: "+e.getMessage());
                                    break;
                                }

                                System.out.println("\nAdministrador Xeral ingresado con éxito!");

                                menuEscollaTipoUser = false;
                                break;
                            }
                            

                            /**
                             * Rexistro Administrador Biblioteca
                             */
                            case 3 -> {
                                String nomeUsuario = getString("\nIngrese o nome de usuario: ");
                                String contrasinal = getString("Ingrese o seu contrasinal: ");

                                if (XestionBibliotecas.getInstance().amosarBibliotecas().isEmpty()) {
                                    System.out.println("\nNon existen bibliotecas neste momento!");
                                    break;
                                }
                                System.out.println(XestionBibliotecas.getInstance().amosarBibliotecas());

                                int id = getInt("Ingrese o id da biblioteca a administrar: ");

                                try {
                                    XestionBibliotecas.getInstance().existenBibliotecas();

                                    if (!(XestionBibliotecas.getInstance().bibliotecaTenAdmin())) {

                                        XestionBibliotecas.getInstance().ingresarAdministradorBiblioteca(contrasinal, nomeUsuario, id);
                                    } 

                                } catch (BibliotecaTenAdmin |BibliotecasNonExiste |IndiceInvalido e) {
                                    System.out.println("\nErro: "+e.getMessage());
                                    break;
                                }

                                System.out.println("\nAdministrador de Biblioteca ingresado con éxito!");

                                menuEscollaTipoUser = false;
                                break;
                            }


                            /**
                             * Erro
                             */
                            default-> {
                                System.out.println("\nErro. Opción inválida!");
                                break;
                            }
                        }
                    }
                }

                /**
                 * Saír
                 */
                case 3 -> {
                    System.out.println("\nSaíndo...\nGrazas por usar a nosa rede de Bibliotecas!!");
                    menuActivo = false;
                    break;
                }
                
                /**
                 * Erro
                 */
                default-> {
                    System.out.println("\nErro. Opción inválida!");
                    break;
                }
            }
        }
    }
   
}
