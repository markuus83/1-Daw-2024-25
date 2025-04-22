package controlador;

import utiles.HashPasword;
import utiles.enumerandos.TipoUsuario;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.excepcions.IndiceInvalido;
import modelo.excepcions.StockNegativo;
import modelo.excepcions.UsuarioExistente;
import modelo.excepcions.UsuarioNonExiste;
import modelo.produtos.Produto;
import modelo.usuarios.Administrador;
import modelo.usuarios.Cliente;
import modelo.usuarios.Usuario;

public class TendaMusica {
    
    private static HashMap<String, Usuario> usuarios;
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Administrador> administradores;
    private static ArrayList<Produto> produtos;

    /**
     * Constructor privado (patrón Singleton)
     */
    private TendaMusica(){
        usuarios = new HashMap<>();
        clientes = new ArrayList<>();
        administradores = new ArrayList<>();
        produtos = new ArrayList<>();
    }

    private static TendaMusica INSTANCE;

    /**
     * Método para obter a instancia Singleton
     */
    public static TendaMusica getInstance(){
        if (TendaMusica.INSTANCE == null) {
            TendaMusica.INSTANCE = new TendaMusica();
        }
        return TendaMusica.INSTANCE;
    }

    /**
     * Evita que se poida clonar a instancia Singleton
     */
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /************* MÉTODOS PARA O MENÚ DE INICIO ***************/

    /**
     * Método encargado de devolver se existe un usuario ou non
     */
    public boolean existeUsuario(String user) throws UsuarioExistente{
        if (usuarios.containsKey(user)) {
            throw new UsuarioExistente("O usuario xa existe!");
        }
        return true;
    }

    /**
     * Método encargado de engadir un Cliente
     */
    public void ingresarCliente(String nome, String contrasinal){

        Cliente c = new Cliente(contrasinal, nome, TipoUsuario.CLIENTE);

        usuarios.put(nome, c);
        clientes.add(c);
    }

    /**
     * Método encargado de engadir un Administrador
     */
    public void ingresarAdministrador(String nome, String contrasinal){

        Administrador a = new Administrador(contrasinal, nome, TipoUsuario.ADMINISTRADOR);

        usuarios.put(nome, a);
        administradores.add(a);
    }
   
    public boolean nonExisteUsuario(String user) throws UsuarioNonExiste{
        if (!(usuarios.containsKey(user))) {
            throw new UsuarioNonExiste("O usuario non existe!");
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
     * Método encargado de comprobar se un usuario é cliente ou administrador
     */
    public boolean eCliente(String nome){

        Usuario user = usuarios.get(nome);

        if (user.getRol().equals(TipoUsuario.CLIENTE)) {
            return true;
        } else{
            return false;
        }
    }
    
    /************* MÉTODOS PARA O MENÚ DE ADMINISTRADORES ***************/

    /**
     * Obtén a información dun produto polo seu ID
     */
    public String verInformacionProduto(int id) throws IndiceInvalido {

        if (id >= 0 && id < produtos.size()) {
            Produto p = produtos.get(id);
            return p.toString();

        } else {
            throw new IndiceInvalido("Índice inválido!");
        }
    }


    //TODO: Rehacer los métodos aumentarStock y eliminarStock para añadirles la excepción de IndiceInválido

    /**
     * Aumenta o stock dun produto
     */
    public void aumentarStock(int id, int stock) throws StockNegativo {
        
        if (stock > 0) {
            produtos.get(id).aumentarStock(stock);

        } else{
            throw new StockNegativo("Stock negativo!");
        }
        
    }

    /**
     * Elimina stock dun produto
     */
    public void eliminarStock(int id, int stock) throws StockNegativo {

        //TODO: Tengo que comprobar que el stock a eliminar no sea negativo y que, además, no sobrepase el stock del producto a eliminar.
        
        produtos.get(id).diminuirStock(stock);
    }

}
