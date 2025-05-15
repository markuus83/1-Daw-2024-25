package vista;

import controlador.XestionBibliotecas;
import modelo.usuarios.Usuario;

public class MenuCliente extends MenuUsuario {

    public MenuCliente(Usuario usuario) {
        super(usuario);
    }

    @Override
    protected void mostrar() {
        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println("\n-----------------------");
            System.out.println("\nBenvido ao menu de Clientes: "+this.getUsuario().getNomeUsuario());
            System.out.println("\t1. Buscar Libro por título: ");
            System.out.println("\t2. Buscar Libro por autor: ");
            System.out.println("\t3. Consultar data límite de devolución: ");
            System.out.println("\t4. Saír: ");

            int option = getInt("> ");

            switch (option) {

                /**
                 * Buscar libro por título
                 */
                case 1 -> {
                    String libro = getString("Ingrese o título do libro: ");
                    
                    System.out.println(XestionBibliotecas.getInstance().amosarExemplaresLibresOrdenadosTitulo(libro));
                }

                /**
                 * Buscar libro por autor
                 */
                case 2 -> {
                    String autor = getString("Ingrese o autor do libro: ");
                    
                    System.out.println(XestionBibliotecas.getInstance().amosarExemplaresLibresOrdenadosAutor(autor));
                }


                /**
                 * Consultar data de devolución;
                 */
                case 3 -> {

                    break;
                }

                /**
                 * Saír
                 */
                case 4 -> {
                    System.out.println("Saíndo...");
                    menuActivo = false;
                    break;
                }
            

                default -> {
                    System.out.println("\nErro: Opción inválida!");
                    break;
                }
            }
        }
        
    }
    
}
