package Controlador;

import Modelo.Excepcions.IndiceInvalido;
import Modelo.Excepcions.StockNegativo;
import Modelo.Excepcions.UsuarioExistente;
import Modelo.Excepcions.UsuarioNonExiste;
import Modelo.Produtos.Produto;
import Modelo.Usuarios.Administrador;
import Modelo.Usuarios.Cliente;
import Modelo.Usuarios.Usuario;
import Utiles.Enumerandos.TipoUsuario;
import Utiles.HashPasword;
import java.util.ArrayList;
import java.util.HashMap;

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

        Cliente c = new Cliente(HashPasword.hashPassword(contrasinal), nome, TipoUsuario.CLIENTE);

        usuarios.put(nome, c);
        clientes.add(c);
    }

    /**
     * Método encargado de engadir un Administrador
     */
    public void ingresarAdministrador(String nome, String contrasinal){

        Administrador a = new Administrador(HashPasword.hashPassword(contrasinal), nome, TipoUsuario.ADMINISTRADOR);

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

    /**
     * Aumenta o stock dun produto
     */
    public void aumentarStock(int id, int stock) throws IndiceInvalido {
        verInformacionProduto(id);
        produtos.get(id).aumentarStock(stock);
    }

    /**
     * Elimina stock dun produto
     */
    public void eliminarStock(int id, int stock) throws IndiceInvalido, StockNegativo {
        verInformacionProduto(id);
        produtos.get(id).diminuirStock(stock);
    }

}
