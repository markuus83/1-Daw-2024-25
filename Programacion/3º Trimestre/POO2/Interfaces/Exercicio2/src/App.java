import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("12345678A", "Ana", 25, 1500.50));
        clientes.add(new Cliente("87654321B", "Xoán", 30, 1800.75));
        clientes.add(new Cliente("11223344C", "Marta", 28, 2000.00));
        clientes.add(new Cliente("44332211D", "Pedro", 35, 2500.25));
        clientes.add(new Cliente("99887766E", "Laura", 22, 1600.60));
        clientes.add(new Cliente("55667788F", "Carlos", 40, 2200.10));
        clientes.add(new Cliente("66778899G", "Sabela", 27, 1700.80));

        Collections.sort(clientes);
        for(Cliente c: clientes){
            System.out.println(c);
        }

        System.out.println("--------------");

        Collections.sort(clientes, new CompararPorNome());
        for(Cliente c: clientes){
            System.out.println(c);
        }

    }

    
    /**
     *  - Tengo que inicializar un objeto comparador llamando a la clase la cual quiero comparar.
     * 
     *  - Para Ordenarlo necesito importar "Collections" y después ordenarlo siguiendo la clase previamente creada
     * 
     *  - Mostrar por pantalla
     */
}
