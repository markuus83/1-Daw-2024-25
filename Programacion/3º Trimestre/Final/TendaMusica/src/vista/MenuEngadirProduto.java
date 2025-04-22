package vista;

public class MenuEngadirProduto extends Menu{
    
    @Override
    protected void mostrar() {

        boolean menuActivo = true;
        while (menuActivo) { 
            System.out.println("Escolla a opción desexada: ");
            System.out.println("1. Frauta: ");
            System.out.println("2. Saxofón:");
            System.out.println("3. Trombón:");
            System.out.println("4. Libro:");
            System.out.println("5. Estoxo:");
        }
    }
}
