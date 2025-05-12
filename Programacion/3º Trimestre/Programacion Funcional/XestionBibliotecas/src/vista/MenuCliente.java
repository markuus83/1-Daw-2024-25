package vista;

import controlador.XestionBibliotecas;
import modelo.usuarios.Usuario;
import utiles.excepcions.BibliotecasNonExiste;
import utiles.excepcions.IndiceInvalido;

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
                    int idBiblioteca = getInt("Ingrese o ID da biblioteca a buscar libros: ");
                    
                    try {
                        
                        if (XestionBibliotecas.getInstance().existenBibliotecas()) {
                            XestionBibliotecas.getInstance().amosarExemplaresLibresOrdenadosTitulo(idBiblioteca);
                        }

                    } catch (IndiceInvalido | BibliotecasNonExiste e) {
                        System.out.println("Erro: "+e.getMessage());
                        break;
                    }
                        
                }


                /**
                 * Buscar libro por autor
                 */
                case 2 -> {
                    int idBiblioteca = getInt("Ingrese o ID da biblioteca a buscar libros: ");
                    
                    try {
                        
                        if (XestionBibliotecas.getInstance().existenBibliotecas()) {
                            
                            XestionBibliotecas.getInstance().amosarExemplaresLibresOrdenadosAutor(idBiblioteca);
                        }

                    } catch (IndiceInvalido | BibliotecasNonExiste e) {
                        System.out.println("Erro: "+e.getMessage());
                        break;
                    }
                }


                /**
                 * Consultar data de devolución;
                 */
                case 3 -> {

                    break;
                }


                /**
                 * 
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
