package controlador;

import java.util.HashMap;

import modelo.usuarios.Usuario;
import modelo.usuarios.cliente.Cliente;
import utiles.excepcions.CorreoInvalido;
import utiles.excepcions.DNIIncorrecto;
import utiles.excepcions.UsuarioExistente;
import utiles.excepcions.UsuarioNonExiste;

public class XestionBibliotecas {

    private static HashMap<String, Usuario> usuarios;

    /**
     * Constructor privado (patrón Singleton)
     */
    private XestionBibliotecas() {
        usuarios = new HashMap<>();
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
        
        //TODO -> Meter datos de Administrador xeral
        try {

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
     * Método encargado de engadir un Cliente
     */
    public void ingresarCliente(String contrasinal, String nomeUsuario,String nome, String Apelidos, String dni, String correo ) throws DNIIncorrecto, CorreoInvalido{
        Cliente c = new Cliente(contrasinal, nomeUsuario, nome, Apelidos, dni, correo);
        
        usuarios.put(nomeUsuario, c);
    }

    
}

