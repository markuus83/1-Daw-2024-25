package vista;

import java.util.Optional;

import controlador.XestionBibliotecas;
import modelo.usuarios.Usuario;
import utiles.enumerandos.TipoUsuario;
import utiles.excepcions.CorreoInvalido;
import utiles.excepcions.DNIIncorrecto;
import utiles.excepcions.DNIRepetido;
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

            XestionBibliotecas.getInstance().impri();

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

                    Optional<Usuario> usuario = XestionBibliotecas.getInstance().login(nomeUsuario, contrasinal);

                    if (usuario.isPresent()) {

                        if (usuario.get().getRol() == TipoUsuario.CLIENTE) {
                            System.out.println("Entra");
                            new MenuCliente(usuario.get()).run();

                        } else if (usuario.get().getRol() == TipoUsuario.ADMINISTRADOR_XERAL){
                            System.out.println("Entra");
                            new MenuAdministradorXeral(usuario.get()).run();
                            
                        } else{
                            System.out.println("Entra");
                            new MenuAdministradorBiblioteca(usuario.get()).run();
                        }
                    }
                    
                    else {
                        System.out.println("Non son as credenciais correctas");
                    }                 

                }


                /**
                 * Rexistrarse
                 */
                case 2 -> {
                    
                    String nomeUsuario = getString("\nIngrese o nome de usuario: ");
                    String contrasinal = getString("Ingrese o seu contrasinal: ");
                    String nome = getString("\nIngrese o nome do Cliente: ");
                    String apelidos = getString("Ingrese os apelidos: ");
                    String dni = getString("Ingrese o DNI: ");
                    String correo = getString("Ingrese o correo: ");

                    try {
                        
                        if(XestionBibliotecas.getInstance().existeUsuario(nomeUsuario) && XestionBibliotecas.getInstance().dniUnico(dni)){

                            XestionBibliotecas.getInstance().ingresarCliente(contrasinal, nomeUsuario, nome, apelidos, dni, correo);

                        }

                    } catch (UsuarioExistente | DNIIncorrecto | CorreoInvalido | DNIRepetido e) {
                        System.out.println("\nErro: "+e.getMessage());
                        break;
                    }

                    System.out.println("\nCliente ingresado con éxito!");
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
