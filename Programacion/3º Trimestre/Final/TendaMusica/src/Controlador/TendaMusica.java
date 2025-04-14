package Controlador;

//Estructura de datos
import java.util.HashMap;

//Imports usuarios
import Modelo.Usuarios.Usuario;

//Imports Excepcións


public class TendaMusica {
    
    HashMap <String, Usuario> usuarios = new HashMap<>();

    
    
    /**
     * PATRON SINGLETON
     */
    private TendaMusica(){}

    /**
     * Inicializamos o patron Singleton
     */
    private static TendaMusica INSTANCE;

    /**
     *  Método utilizado para podere acceder aos métodos da clase
     * 
     * @return -> Devolve a instancia da clase TendaMusica
     */
    public static TendaMusica getInstance(){
        if (TendaMusica.INSTANCE == null) {
            TendaMusica.INSTANCE = new TendaMusica();
        }
        return TendaMusica.INSTANCE;
    }

    /**
     * Método encargado de que non se clone o obxecto
     */
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
