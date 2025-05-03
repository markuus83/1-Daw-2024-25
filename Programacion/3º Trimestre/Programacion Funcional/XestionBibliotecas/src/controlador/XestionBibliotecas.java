package controlador;

public class XestionBibliotecas {

    /**
     * Constructor privado (patrón Singleton)
     */
    private XestionBibliotecas() {
    }

    private static XestionBibliotecas INSTANCE;

    /**
     * Método para obter a instancia Singleton
     */
    public static XestionBibliotecas getInstance(){
        if (XestionBibliotecas.INSTANCE == null) {
            XestionBibliotecas.INSTANCE = new XestionBibliotecas();
            XestionBibliotecas.INSTANCE.engadirDatos();
        }
        return XestionBibliotecas.INSTANCE;
    }

    /**
     * Evita que se poida clonar a instancia Singleton
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void engadirDatos() {
        
        try {

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
        }
        
    }
}