package Controlador;

//Almacenamento de datos
import java.util.ArrayList;
import java.util.HashMap;

//Imports Excepcións
import Modelo.Excepcions.ISBNIncorrecto;
import Modelo.Excepcions.IndiceInvalido;
import Modelo.Excepcions.PrezoNegativo;
import Modelo.Excepcions.StockExcedente;
import Modelo.Excepcions.StockNegativo;
import Modelo.Excepcions.UsuarioExistente;
import Modelo.Excepcions.UsuarioNonExiste;

//Imports do Modelo
import Modelo.Produtos.Produto;
import Modelo.Produtos.Complemento.Complemento;
import Modelo.Produtos.Complemento.Complementos.Estoxo;
import Modelo.Produtos.Complemento.Complementos.Libro;
import Modelo.Produtos.Instrumento.InstrumentoMusical;
import Modelo.Produtos.Instrumento.Instrumentos.Frauta;
import Modelo.Produtos.Instrumento.Instrumentos.Saxofon;
import Modelo.Produtos.Instrumento.Instrumentos.Trombon;
import Modelo.Usuarios.Administrador;
import Modelo.Usuarios.Cliente;
import Modelo.Usuarios.Usuario;

//Imports enumerandos
import Utiles.Enumerandos.TipoInstrumentoMusical;
import Utiles.Enumerandos.TipoSaxofon;
import Utiles.Enumerandos.TipoUsuario;

//Imports Statics
import Utiles.HashPasword;

public class TendaMusica {
    
    private static HashMap<String, Usuario> usuarios;
    private static HashMap <Integer, Produto> produtos;
    private static ArrayList<InstrumentoMusical> instrumentos;
    private static ArrayList<Complemento> complementos;
    private static ArrayList<Frauta> frautas;
    private static ArrayList<Saxofon> saxofons;
    private static ArrayList<Trombon> trombons;
    private static ArrayList<Libro> libros;
    private static ArrayList<Estoxo> estoxos;

    /**
     * Constructor privado (patrón Singleton)
     */
    private TendaMusica(){
        usuarios = new HashMap<>();
        produtos = new HashMap<>();
        instrumentos = new ArrayList<>();
        complementos = new ArrayList<>();
        frautas = new ArrayList<>();
        saxofons = new ArrayList<>();
        trombons = new ArrayList<>();
        libros = new ArrayList<>();
        estoxos = new ArrayList<>();
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
    }

    /**
     * Método encargado de engadir un Administrador
     */
    public void ingresarAdministrador(String nome, String contrasinal){

        Administrador a = new Administrador(contrasinal, nome, TipoUsuario.ADMINISTRADOR);
        usuarios.put(nome, a);
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
        return user.getRol().equals(TipoUsuario.CLIENTE);
    }
    

    /************* MÉTODOS PARA O MENÚ DE ENGADIR PRODUTOS ***************/

    /**
     * Método encargardo de engadir unha nova Frauta
     */
    public void engadirFrauta(String marcaEn, String modeloEn, double prezoEn, int stockEn, String descricionEn, Boolean pdsEn) throws PrezoNegativo, StockNegativo {

        Frauta frauta = new Frauta(marcaEn, modeloEn, prezoEn, stockEn, descricionEn, pdsEn);

        produtos.put(frauta.getIdProduto(), frauta);
        instrumentos.add(frauta);
        frautas.add(frauta);
    }

    /**
     * Método encargardo de engadir un novo Saxofon
     */
    public void engadirSaxofon(String marcaEn, String modeloEn, double prezoEn, int stockEn, String descricionEn, TipoSaxofon tipoSaxofon) throws PrezoNegativo, StockNegativo{

        Saxofon saxofon = new Saxofon(marcaEn, modeloEn, prezoEn, stockEn, descricionEn, tipoSaxofon);

        produtos.put(saxofon.getIdProduto(), saxofon);
        instrumentos.add(saxofon);
        saxofons.add(saxofon);
    }

    /**
     * Método encargardo de engadir un novo Trombon
     */
    public void engadirTrombon(String marcaEn, String modeloEn, double prezoEn, int stockEn, String descricionEn, Boolean transpositorEn) throws PrezoNegativo, StockNegativo {

        Trombon trombon = new Trombon(marcaEn, modeloEn, prezoEn, stockEn, descricionEn, transpositorEn);

        produtos.put(trombon.getIdProduto(), trombon);
        instrumentos.add(trombon);
        trombons.add(trombon);
    }

    /**
     * Método encargardo de engadir un novo Libro
     */
    public void engadirLibro(double prezoEn, int stockEn, String descricionEn, String tituloEn, String autorEn, String isbnEn) throws ISBNIncorrecto, StockNegativo, PrezoNegativo{

        Libro libro = new Libro(prezoEn, stockEn, descricionEn, tituloEn, autorEn, isbnEn);

        produtos.put(libro.getIdProduto(), libro);
        complementos.add(libro);
        libros.add(libro);

    }

    /**
     * Método encargardo de engadir un novo Estoxo
     */
    public void engadirEstoxo(double prezoEn, int stockEn, String descricionEn,String marcaEn, TipoInstrumentoMusical tipoInstrumentoEn) throws StockNegativo, PrezoNegativo{

        Estoxo estoxo = new Estoxo(prezoEn, stockEn, descricionEn, tipoInstrumentoEn, marcaEn);

        produtos.put(estoxo.getIdProduto(), estoxo);
        complementos.add(estoxo);
        estoxos.add(estoxo);

    }


    /************* MÉTODOS PARA O MENÚ DE VER PRODUTOS ***************/
    public String mostrarProdutos(){

        String resultado = "";

        //Se llama automáticamente al toString()
        //Hacemos un salto de línea automático
        for (Produto produto : produtos.values()) {
            resultado += produto + "\n";  
        }
        return resultado;
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
    public void aumentarStock(int id, int stock) throws IndiceInvalido, StockNegativo{

        System.out.println(verInformacionProduto(id));

        //Capturamos as excepcións nos propios métodos da clase Produto
        produtos.get(id).aumentarStock(stock);
    }

    /**
     * Elimina stock dun produto
     */
    public void eliminarStock(int id, int stock) throws StockNegativo, StockExcedente, IndiceInvalido {

        System.out.println(verInformacionProduto(id));

        //Capturamos as excepcións nos propios métodos da clase Produto
        produtos.get(id).diminuirStock(stock);
    }

}