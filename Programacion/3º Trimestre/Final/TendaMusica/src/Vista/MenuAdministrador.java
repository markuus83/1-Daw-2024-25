package Vista;

import Controlador.TendaMusica;
import Modelo.Excepcions.IndiceInvalido;
import Modelo.Excepcions.StockNegativo;

public class MenuAdministrador extends Menu {

    @Override
    protected void mostrar() {

        boolean menuActivo = true;

        while (menuActivo) {

            System.out.println("\nPrema a opción desexada: ");
            System.out.println("\t1. Engadir un produto");
            System.out.println("\t2. Ver produtos");
            System.out.println("\t3. Ver a información dun produto (Identificador): ");
            System.out.println("\t4. Engadir stock a un produto (Identificador): ");
            System.out.println("\t5. Eliminar stock a un produto (Identificador): ");
            System.out.println("\t6. Saír: ");

            int option = getInt("> ");

            switch (option) {

                /**
                 * Engadir produtos
                 */
                case 1 -> {
                    menuActivo = false;
                    new MenuEngadirProduto().run();
                    break;
                }

                /**
                 * Ver produtos
                 */
                case 2 -> {                    
                    menuActivo = false;
                    new MenuVerProdutos().run();
                    break;
                }

                /**
                 * Ver información dun produto
                 */
                case 3 -> {

                    int indice = getInt("Indique o índice do produto: ");

                    try {
                        System.out.println(TendaMusica.getInstance().verInformacionProduto(indice));
                        
                    } catch (IndiceInvalido e) {
                        System.out.println("Erro: "+e.getMessage());
                    }
                    
                    break;
                }

                /**
                 * Engadir stock
                 */
                case 4 -> {

                    int indice = getInt("Indique o índice do produto: "); 
                    int stock = getInt("Indique o stock a aumentar: ");

                    try {
                        TendaMusica.getInstance().aumentarStock(indice, stock);
                    } catch (IndiceInvalido e) {
                        System.out.println("Erro: "+e.getMessage());
                    }

                    break;
                }

                /**
                 * Eliminar stock
                 */
                case 5 -> {
                    
                    int indice = getInt("Indique o índice do produto: ");
                    int stock = getInt("Indique o stock a eliminar: ");

                    try {
                        TendaMusica.getInstance().eliminarStock(indice, stock);

                    } catch (IndiceInvalido | StockNegativo e) {
                        System.out.println("Erro: "+e.getMessage());
                    }

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
                default -> {
                    System.out.println("Erro. Opción inválida!");
                    break;
                }
            }
        }
    }
}
