package Controlador;

import Modelo.Excepcions.IndiceInvalido;
import Modelo.Excepcions.UsuarioExistente;
import Modelo.Produtos.Produto;
import Modelo.Usuarios.Administrador;
import Modelo.Usuarios.Cliente;
import Modelo.Usuarios.Usuario;
import Utiles.Enumerandos.TipoUsuario;
import Utiles.HashPasword;
import java.util.ArrayList;
import java.util.HashMap;

public class TendaMusica {
    
    private static HashMap <String, Usuario> usuarios;
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Administrador> administradores;
    private static ArrayList<Produto> produtos;

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
    public boolean usuarioECliente(String nomeUsuario){

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

    /**
     * Método encargado de devolver a información dun produto
     */
    public String verInformacionProduto(int id) throws IndiceInvalido {
        if (id >= 0 && id<produtos.size()) {
            Produto p = produtos.get(id);
            return p.toString();
        } else{
            throw new IndiceInvalido("Índice inválido!");
        }
    }
    
}
