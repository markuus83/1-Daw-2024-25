package vista;

import controlador.XestionBibliotecas;
import modelo.usuarios.Usuario;
import utiles.excepcions.ClienteSancionado;
import utiles.excepcions.IndiceInvalido;
import utiles.excepcions.PrestamoActivo;
import utiles.excepcions.UsuarioExistente;

public class MenuAdministradorBiblioteca extends MenuUsuario{

    public MenuAdministradorBiblioteca(Usuario user){
        super(user);
    }
    
    protected void mostrar() {

        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println("\n-----------------------");
            System.out.println("\nBenvido ao menu de Administradores de Bibliotecas: "+this.getUsuario().getNomeUsuario());
            System.out.println("\t1. Ver exemplares libres dun libro: ");
            System.out.println("\t2. Realizar préstamo: ");
            System.out.println("\t3. Saír: ");

            int option = getInt("> ");

            switch (option) {

                /**
                 * Ver exemplares dun libro
                 */
                case 1 -> {

                    try {
                        String nomeUser = this.getUsuario().getNomeUsuario();
                    
                        //TODO - MODIFICADO AKI PARA FUTURA CORRECCIÓN
                        XestionBibliotecas.getInstance().existeUsuario(nomeUser);

                        System.out.println(XestionBibliotecas.getInstance().amosarExemplaresLibresDunhaBiblioteca(nomeUser));

                    } catch (UsuarioExistente e) {
                        System.out.println("Erro: "+e.getMessage());
                    }
                    
                }


                /**
                 * Realizar préstamo
                 */
                case 2 -> {

                    int idExemplar = getInt("Ingrese o id do exemplar a realizar o préstamo: ");
                    String dniUsuario = getString("Ingrese o DNI do usuario que vai realizar o préstamo: ");

                    try {

                        if (XestionBibliotecas.getInstance().tenPrestamoActivo(dniUsuario)) {
                            
                            XestionBibliotecas.getInstance().ingresarPrestamo(idExemplar, dniUsuario);

                        }
                    } catch (PrestamoActivo | IndiceInvalido | ClienteSancionado e) {
                        System.out.println("Erro: "+e.getMessage());
                        break;
                    }
                    System.out.println("Préstamo realizado correctamente!");

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
                 * Erro
                 */
                default -> {
                    System.out.println("Erro: Opción inválida!");
                    break;
                }
            }
        }
        
    }
    
}
