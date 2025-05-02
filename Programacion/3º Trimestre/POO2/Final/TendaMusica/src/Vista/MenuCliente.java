package Vista;

import Controlador.TendaMusica;
import Modelo.Excepcions.IdInvalido;
import Modelo.Excepcions.StockExcedente;
import Modelo.Excepcions.StockNegativo;

public class MenuCliente extends Menu {

    @Override
    protected void mostrar() {
        
        boolean menuActivo = true;
        
        while (menuActivo) {
            System.out.println("\n-----------------------");
            System.out.println("\nBenvido ao menú do Cliente!");
            System.out.println("\t1. Ver produtos");
            System.out.println("\t2. Comprar produtos");
            System.out.println("\t3. Saír");

            int option = getInt("> ");

            switch (option) {
                /**
                 * Ver Produtos
                 */
                case 1 -> {
                    // Como comparten as mesmas funcións, reutilizamos o mesmo menú que os administradores
                    new MenuVerProdutos().run();
                }

                /**
                 * Comprar Produtos
                 */
                case 2 -> {

                    System.out.println(TendaMusica.getInstance().mostrarProdutos());

                    int id = getInt("Selecciona o id do produto a comprar: ");
                    int cantidade = getInt("Selecciona a cantidade a comprar: ");

                    try {
                        TendaMusica.getInstance().comprarProdutos(id, cantidade);
                    } catch (StockExcedente | StockNegativo | IdInvalido e) {
                        System.out.println("Erro: "+e.getMessage());
                    }
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
