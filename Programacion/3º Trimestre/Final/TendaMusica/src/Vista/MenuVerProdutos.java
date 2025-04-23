package Vista;

import Controlador.TendaMusica;

public class MenuVerProdutos extends Menu{

    @Override
    protected void mostrar() {

        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println("\nMenu para ver produtos: ");
            System.out.println("\t1. Ver todos os produtos: ");
            System.out.println("\t2. Ver todos os instrumentos: ");
            System.out.println("\t3. Ver todas as frautas: ");
            System.out.println("\t4. Ver todos os saxofóns: ");
            System.out.println("\t5. Ver todos os trombóns: ");
            System.out.println("\t6. Ver todos os complementos: ");
            System.out.println("\t7. Ver todos os libros");
            System.out.println("\t8. Ver todos os estoxos: ");
            System.out.println("\t9. Saír: ");

            int option = getInt("> ");

            switch (option) {

                /**
                 * Todos os PRODUTOS
                 */
                case 1 -> {
                    System.out.println(TendaMusica.getInstance().mostrarProdutos());
                    break;
                }

                /**
                 * Todos os INSTRUMENTOS
                 */
                case 2 -> {
                    break;
                }

                /**
                 * Todas as FRAUTAS
                 */
                case 3 -> {
                    break;  
                }

                /**
                 * Todos os SAXOFÓNS
                 */
                case 4 -> {
                    break;  
                }

                /**
                 * Todos os TROMBÓNS
                 */
                case 5 -> {
                    break;  
                }

                /**
                 * Todos os COMPLEMENTOS
                 */
                case 6 -> {
                    break;  
                }

                case 7 -> {
                    break;  
                }

                case 8 -> {
                    break;  
                }

                case 9 -> {
                    System.out.println("Saíndo...");
                    menuActivo = false;
                    break;  
                }
            
                default-> {
                    System.out.println("Erro. Opción inválida");
                    break;  
                }
            }
        }
    }
    
}
