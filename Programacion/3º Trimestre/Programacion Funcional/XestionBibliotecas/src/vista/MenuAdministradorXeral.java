package vista;

import controlador.XestionBibliotecas;
import utiles.enumerandos.TipoLinguaLibros;
import utiles.excepcions.ISBNIncorrecto;
import utiles.excepcions.LibroExistente;

public class MenuAdministradorXeral extends Menu{

    @Override
    protected void mostrar() {
        
        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println("\n-----------------------");
            System.out.println("\nBenvido ao menu de Administradores Xerais: ");
            System.out.println("\t1. Nova Biblioteca: ");
            System.out.println("\t2. Novo Libro: ");
            System.out.println("\t3. Saír: ");

            int option = getInt("> ");

            switch (option) {

                /**
                 * Nova Biblioteca
                 */
                case 1 -> {

                    String nome = getString("\nIngrese o nome: ");
                    String direccion = getString("Ingrese a dirección: ");
                    String cidade = getString("Ingrese a cidade: ");
                    String provincia = getString("Ingrese a provincia: ");

                    try {
                        XestionBibliotecas.getInstance().ingresarBiblioteca(nome, direccion, cidade, provincia);
                    } catch (Exception e) {
                        System.out.println("Erro: "+e.getMessage());
                        break;
                    }

                }


                /**
                 * Novo Libro
                 */
                case 2 -> {
                    String titulo = getString("\nIngrese o título: ");
                    String editorial = getString("Ingrese a editorial: ");
                    String isbn = getString("Ingrese o ISBN: ");

                    System.out.println("\nEn que lingua está o libro?");
                    System.out.println("\t1. Galego: ");
                    System.out.println("\t2. Castelán: ");
                    System.out.println("\t3. Ingés: ");

                    int optionLingua = getInt("> ");

                    TipoLinguaLibros tipo;

                    switch (optionLingua) {

                        case 1 -> {
                            tipo = TipoLinguaLibros.GALEGO;
                        }

                        case 2 -> {
                            tipo = TipoLinguaLibros.CASTELAN;
                        }

                        case 3 -> {
                            tipo = TipoLinguaLibros.INGLES;
                        }
                    
                        default -> {
                            System.out.println("Erro: Opción inválida!");
                            continue;
                        }
                    }
                    
                    try {

                        XestionBibliotecas.getInstance().existeLibro(isbn);

                        XestionBibliotecas.getInstance().ingresarLibro(titulo, editorial, isbn, tipo);

                    } catch (ISBNIncorrecto | LibroExistente e) {
                        System.out.println("Erro: "+e.getMessage());
                        break;
                    }
                    System.out.println("Libro creado exitosamente!");
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
