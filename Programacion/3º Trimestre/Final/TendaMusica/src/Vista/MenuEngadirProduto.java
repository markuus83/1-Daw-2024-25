package Vista;

import Controlador.TendaMusica;
import Modelo.Excepcions.ISBNIncorrecto;
import Modelo.Excepcions.PrezoNegativo;
import Modelo.Excepcions.StockNegativo;
import Utiles.Enumerandos.TipoInstrumentoMusical;
import Utiles.Enumerandos.TipoSaxofon;

public class MenuEngadirProduto extends Menu{
    
    @Override
    protected void mostrar() {

        boolean menuActivo = true;
        while (menuActivo) { 
            System.out.println("\nEscolla a opción desexada: ");
            System.out.println("\t1. Frauta: ");
            System.out.println("\t2. Saxofón:");
            System.out.println("\t3. Trombón:");
            System.out.println("\t4. Libro:");
            System.out.println("\t5. Estoxo:");
            System.out.println("\t6. Saír: ");

            int option = getInt("> ");

            switch (option) {

                /**
                 * Frauta
                 */
                case 1 -> {
                    System.out.println();

                    String marca = getString("\nIngrese a marca: ");
                    String modelo = getString("Ingrese o modelo: ");
                    double prezo = getDouble("Ingrese o prezo: ");
                    int stock = getInt("Ingrese a cantidade en Stock: ");
                    String descricion = getString("Ingrese unha breve descrición: ");
                    String resposta = this.getString("A frauta ten pe? (Y/N) ");
                    boolean pds = resposta.equals("Y");

                    try {
                        TendaMusica.getInstance().engadirFrauta(marca, modelo, prezo, stock, descricion, pds);

                    } catch (PrezoNegativo | StockNegativo e) {
                        System.out.println("Erro: "+e.getMessage());
                        break;
                    }

                    System.out.println("Frauta engadida con éxito!");
                    break;
                }

                /**
                 * Saxofón
                 */
                case 2 -> {

                    String marca = getString("\nIngrese a marca: ");
                    String modelo = getString("Ingrese o modelo: ");
                    double prezo = getDouble("Ingrese o prezo: ");
                    int stock = getInt("Ingrese a cantidade en Stock: ");
                    String descricion = getString("Ingrese unha breve descrición: ");

                    TipoSaxofon tipo;

                    System.out.println("\nEscolla o tipo de saxofon: ");
                    System.out.println("\t1. Soprano: ");
                    System.out.println("\t2. Alto: ");
                    System.out.println("\t3. Tenor: ");
                    System.out.println("\t4. Barítono: ");

                    int optionSaxofon = getInt("> ");

                    switch (optionSaxofon) {

                        /**
                         * Soprano
                         */
                        case 1 -> {
                            tipo = TipoSaxofon.SOPRANO;
                        }

                        /**
                         * Alto
                         */
                        case 2 -> {
                            tipo = TipoSaxofon.ALTO;
                        }

                        /**
                         * Tenor
                         */
                        case 3 -> {
                            tipo = TipoSaxofon.TENOR;
                        }

                        /**
                         * Barítono
                         */
                        case 4 -> {
                            tipo = TipoSaxofon.BARITONO;
                        }
                    
                        /**
                         * Erro
                         */
                        default ->{
                            System.out.println("Erro. Opción inválida!");
                            continue;
                        }
                    }

                    try {
                        TendaMusica.getInstance().engadirSaxofon(marca, modelo, prezo, stock, descricion, tipo);
                    } catch (PrezoNegativo | StockNegativo e) {
                        System.out.println("Erro: "+e.getMessage());
                        break;
                    }

                    System.out.println("Saxofón engadido correctamente!");
                    break;
                }

                    
                /**
                 * Trombón
                 */
                case 3 -> {

                    String marca = getString("\nIngrese a marca: ");
                    String modelo = getString("Ingrese o modelo: ");
                    double prezo = getDouble("Ingrese o prezo: ");
                    int stock = getInt("Ingrese a cantidade en Stock: ");
                    String descricion = getString("Ingrese unha breve descrición: ");
                    String resposta = this.getString("O trombón ten transpositor? (Y/N) ");
                    boolean transpositor = resposta.equals("Y");

                    try {
                        TendaMusica.getInstance().engadirTrombon(marca, modelo, prezo, stock, descricion, transpositor);

                    } catch (PrezoNegativo | StockNegativo e) {
                        System.out.println("Erro: "+e.getMessage());
                        break;
                    }

                    System.out.println("Trombón engadido con éxito!");
                    break;
                }

                /**
                 * Libro
                 */
                case 4 -> {
                    double prezo = getDouble("\nIngrese o prezo: ");
                    int stock = getInt("Ingrese a cantidade en Stock: ");
                    String descricion = getString("Ingrese unha breve descrición: ");
                    String titulo = getString("Ingrese un título: ");
                    String autor = getString("Ingrese un autor: ");
                    String isbnLibro = getString("Ingrese un ISBN: ");

                    try {
                        TendaMusica.getInstance().engadirLibro(prezo, stock, descricion, titulo, autor, isbnLibro);

                    } catch (ISBNIncorrecto | StockNegativo| PrezoNegativo e) {
                        System.out.println("Erro: "+e.getMessage());
                        break;
                    }
                    System.out.println("Libro engadido con éxito!");
                    break;
                }

                /**
                 * Estoxo
                 */
                case 5 -> {
                    double prezo = getDouble("\nIngrese o prezo: ");
                    int stock = getInt("Ingrese a cantidade en Stock: ");
                    String descricion = getString("Ingrese unha breve descrición: ");
                    String marca = getString("Ingrese a marca: ");

                    TipoInstrumentoMusical tipo;

                    System.out.println("\nEscolla o instrumento ao cal pertence: ");
                    System.out.println("\t1. Frauta: ");
                    System.out.println("\t2. Saxofon: ");
                    System.out.println("\t3. Trombon: ");

                    int optionEstoxo = getInt("> ");

                    switch (optionEstoxo) {

                        /**
                         * Frauta
                         */
                        case 1 -> {
                            tipo = TipoInstrumentoMusical.FRAUTA;
                        }

                        /**
                         * Saxofon
                         */
                        case 2 -> {
                            tipo = TipoInstrumentoMusical.SAXOFON;
                        }

                        /**
                         * Trombon
                         */
                        case 3 -> {
                            tipo = TipoInstrumentoMusical.TROMBON;
                        }
                    
                        /**
                         * Erro
                         */
                        default ->{
                            System.out.println("Erro. Opción inválida!");
                            continue;
                        }
                    }

                    try {
                        TendaMusica.getInstance().engadirEstoxo(prezo, stock, descricion, marca, tipo);

                    } catch (StockNegativo | PrezoNegativo e) {
                        System.out.println("Erro: "+e.getMessage());
                        break;
                    }

                    System.out.println("Estoxo engadido con éxito!");
                    break;
                }

                /**
                 * Saír
                 */
                case 6 -> {
                    System.out.println("Saíndo...");
                    menuActivo = false;
                    break;
                }                   
                    
                /**
                 * Erro
                 */
                default ->{
                    System.out.println("Erro: Opción inválida!");
                    break;
                }
            }
        }
    }
}
