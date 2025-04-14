package Controlador;

//Estructura de datos
import java.util.HashMap;
import java.util.ArrayList;

//Imports usuarios
import Modelo.Usuarios.Usuario;
import Modelo.Usuarios.Administrador;
import Modelo.Usuarios.Cliente;

//Imports Enumerandos
import Utiles.Enumerandos.TipoUsuario;

//Imports Métodos Static
import Utiles.HashPasword;

//Imports Excepcións
import Modelo.Excepcions.UsuarioExistente;

public class TendaMusica {
    
    private static HashMap <String, Usuario> usuarios;
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Administrador> administradores;

    /**
     * Constructores
     */
    private TendaMusica(){
        usuarios = new HashMap<>();
        clientes = new ArrayList<>();
        administradores = new ArrayList<>();
    }

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

    /************* A PARTIR DE AQUI SON OS MÉTODOS PROPIOS PARA AMOSAR NO MENU ***************/

    /**
     * Método encargado de verificar se xa existe o nome de usuario
     */
    public boolean existeNomeUsuario(String nombreUsuario) throws UsuarioExistente{
      
        for (String nombre : usuarios.keySet()) {
            if (!nombreUsuario.equals(nombre)) {
                throw new UsuarioExistente("Non existe o Usuario");
            }
        }

        return true;
     
    }
    
    /**
     * Método encargado de ingresar un Administrador
     */
    public void ingresarCliente(String nomeUsuario, String contrasinalUsuario){
        usuarios.put(nomeUsuario, new Cliente(HashPasword.hashPassword(contrasinalUsuario), nomeUsuario, TipoUsuario.CLIENTE));

        clientes.add(new Cliente(HashPasword.hashPassword(contrasinalUsuario), nomeUsuario, TipoUsuario.CLIENTE));
    }

    /**
     * Método encargado de ingresar un Administrador
     */
    public void ingresarAdministrador(String nomeUsuario, String contrasinalUsuario){
        usuarios.put(nomeUsuario, new Cliente(HashPasword.hashPassword(contrasinalUsuario), nomeUsuario, TipoUsuario.ADMINISTRADOR));

        administradores.add(new Administrador(HashPasword.hashPassword(contrasinalUsuario), nomeUsuario, TipoUsuario.CLIENTE));
    }

    /**
     * Método encargado de devolver se un usuario é un Cliente ou non
     */
    public boolean comprobacionParaIngresoCliente(String nomeUsuario){

        Usuario user = usuarios.get(nomeUsuario);

        return user.getRol() == (TipoUsuario.CLIENTE);
    }

    /**
     * Método que nos permite comprobar se os datos de inicio son corrector
     */
    public boolean comprobarDatosInicio(String nomeUsuario, String contrasinalUsuario){
        
        Usuario user = usuarios.get(nomeUsuario);

        String hashIntroducido = HashPasword.hashPassword(contrasinalUsuario);

        return user.getContrasinal().equals(hashIntroducido);

    }












    
}
