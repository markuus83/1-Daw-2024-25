package controlador;

import java.util.HashMap;
import modelo.bibliotecas.Biblioteca;
import modelo.usuarios.AdministradorXeral;
import modelo.usuarios.Cliente;
import modelo.usuarios.Usuario;
import utiles.clasesStatic.HashPasword;
import utiles.enumerandos.TipoUsuario;
import utiles.excepcions.CorreoInvalido;
import utiles.excepcions.DNIIncorrecto;
import utiles.excepcions.UsuarioExistente;
import utiles.excepcions.UsuarioNonExiste;

public class XestionBibliotecas {

    private static HashMap<String, Usuario> usuarios;
    private static HashMap<Integer, Biblioteca> bibliotecas;

    /**
     * Constructor privado (patrón Singleton)
     */
    private XestionBibliotecas() {
        usuarios = new HashMap<>();
        bibliotecas = new HashMap<>();
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


    /************* MÉTODOS PARA ENGADIR DATOS Á INSTANCIA ***************/

    public void engadirDatos() {
        
        try {
            AdministradorXeral a = new AdministradorXeral("abc123.", "admin");

            usuarios.put(a.getNomeUsuario(), a);

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
        }
        
    }



    /************* MÉTODOS PARA O MENÚ DE INICIO ***************/

    public boolean nonExisteUsuario(String user) throws UsuarioNonExiste{
        if (!(usuarios.containsKey(user))) {
            throw new UsuarioNonExiste("O usuario non existe!");
        }
        return true;
    }

    public boolean existeUsuario(String user) throws UsuarioExistente{
        if (usuarios.containsKey(user)) {
            throw new UsuarioExistente("O usuario xa existe!");
        }
        return true;
    }

    /**
     * Método encargado de comprobar se os datos son correctos
     */
    public boolean comprobarDatos(String user, String password){
        Usuario u = usuarios.get(user);
        return u.getContrasinal().equals(HashPasword.hashPassword(password));
    }

    /**
     * Método encargado de engadir un Cliente
     */
    public void ingresarCliente(String contrasinal, String nomeUsuario,String nome, String Apelidos, String dni, String correo ) throws DNIIncorrecto, CorreoInvalido{
        Cliente c = new Cliente(contrasinal, nomeUsuario, nome, Apelidos, dni, correo);
        
        usuarios.put(nomeUsuario, c);
    }

    /**
     * método encargado de engadir un Administrador Xeral
     */
    public void ingresarAdministradorXeral(String contrasinal, String nomeUsuario){

        AdministradorXeral a = new AdministradorXeral(contrasinal, nomeUsuario);

        usuarios.put(nomeUsuario, a);
    }

    /**
     * Método encargado de comprobar se un usuario é cliente ou administrador
     */
    public boolean eCliente(String nome){
        Usuario user = usuarios.get(nome);
        return user.getRol().equals(TipoUsuario.CLIENTE);
    }

    /**
     * Método encargado de comprobar se un usuario é cliente ou administrador
     */
    public boolean eAdministradorXeral(String nome){
        Usuario user = usuarios.get(nome);
        return user.getRol().equals(TipoUsuario.ADMINISTRADOR_XERAL);
    }



    
    /************* MÉTODOS PARA O MENÚ DE ADMINISTRADORES XERAIS ***************/
    public void ingresarBiblioteca(String nome, String direccion, String cidade, String provincia){

        Biblioteca b = new Biblioteca(nome, direccion, cidade, provincia);
        bibliotecas.put(b.getIdBiblioteca(), b);
    }

    public boolean existeBiblioteca(int id){
        if (bibliotecas.isEmpty()) {
            return false;
        }
        return bibliotecas.containsKey(id);
    }
}
