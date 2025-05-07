package controlador;

//Imports estructuras de datos
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

import modelo.bibliotecas.Biblioteca;
import modelo.libros.Libro;
import modelo.usuarios.AdministradorBiblioteca;
import modelo.usuarios.AdministradorXeral;
import modelo.usuarios.Cliente;
import modelo.usuarios.Usuario;
import utiles.clasesStatic.HashPasword;
import utiles.enumerandos.TipoLinguaLibros;
import utiles.enumerandos.TipoUsuario;
import utiles.excepcions.BibliotecaTenAdmin;
import utiles.excepcions.BibliotecasNonExiste;
import utiles.excepcions.CorreoInvalido;
import utiles.excepcions.DNIIncorrecto;
import utiles.excepcions.ExemplarInvalido;
import utiles.excepcions.ISBNIncorrecto;
import utiles.excepcions.IndiceInvalido;
import utiles.excepcions.LibroExistente;
import utiles.excepcions.UsuarioExistente;
import utiles.excepcions.UsuarioNonExiste;

public class XestionBibliotecas {

    //Estructuras de control
    private static HashMap<String, Usuario> usuarios;
    private static HashMap<Integer, Biblioteca> bibliotecas;
    private static HashMap<String, Libro> libros;
    


    /************* MÉTODOS PARA A CREACIÓN DO PATRÓN SINGLETON ***************/

    /**
     * Constructor privado (patrón Singleton)
     */
    private XestionBibliotecas() {
        usuarios = new HashMap<>();
        bibliotecas = new HashMap<>();
        libros = new HashMap<>();
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

    /**
     * Método encargado de engadir un Administrador Xeral cada vez que se cree unha nova Instancia.
     */
    public void engadirDatos() {
        
        try {
            AdministradorXeral a = new AdministradorXeral("abc123.", "admin");

            usuarios.put(a.getNomeUsuario(), a);

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
        }
        
    }



    /************* MÉTODOS PARA O MENÚ DE INICIO ***************/

    /**
     * Método encargado de comprobar se non existen usuarios
     */
    public boolean nonExisteUsuario(String user) throws UsuarioNonExiste{
        if (!(usuarios.containsKey(user))) {
            throw new UsuarioNonExiste("O usuario non existe!");
        }
        return true;
    }

    /**
     * Método encargado de comprobar que existen usuarios
     */
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
     * Método encargado de engadir un Administrador Xeral
     */
    public void ingresarAdministradorXeral(String contrasinal, String nomeUsuario){

        AdministradorXeral a = new AdministradorXeral(contrasinal, nomeUsuario);
        usuarios.put(nomeUsuario, a);
    }

    /**
     * Método encargado de ingresar un administrador de Biblioteca
     */
    public void ingresarAdministradorBiblioteca(String contrasinal, String nomeUsuario, int id) throws IndiceInvalido{

        if (bibliotecas.containsKey(id)) {
            
            AdministradorBiblioteca b = new AdministradorBiblioteca(contrasinal, nomeUsuario, id);

            usuarios.put(nomeUsuario, b);

        } else{
            throw new IndiceInvalido("Indice inválido!");
        }
    }

    /**
     * Método encargado de comprobar se unha biblioteca ten administrador
     */
    public boolean bibliotecaTenAdmin() throws BibliotecaTenAdmin{
        
        for (Biblioteca b : bibliotecas.values()) {
            if (!(b.getAdmin().equals(Optional.empty()))) {
                throw new BibliotecaTenAdmin("A biblioteca xa ten administrador!");
            }
        }
        return false;
    }


    /**
     * Método encargado de amosar todas as Bibliotecas nunha cadea de texto
     */
    public String amosarBibliotecas(){

        return bibliotecas.entrySet()
                      .stream()
                      .map(entry -> entry.getKey() + " - " + entry.getValue())
                      .collect(Collectors.joining("\n"));
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

    /**
     * Método encargado de comprobar se existen bibliotecas
     */
    public boolean existenBibliotecas() throws BibliotecasNonExiste{
        if (bibliotecas.isEmpty()) {
            throw new BibliotecasNonExiste("Non existen Bibliotecas!");
        } else{
            return true;
        }
    }

    
    /************* MÉTODOS PARA O MENÚ DE ADMINISTRADORES XERAIS ***************/

    /**
     * Método encargado de ingresar unha Biblioteca
     */
    public void ingresarBiblioteca(String nome, String direccion, String cidade, String provincia){

        Biblioteca b = new Biblioteca(nome, direccion, cidade, provincia);
        bibliotecas.put(b.getIdBiblioteca(), b);
    }

    /**
     * Método encargado de ingresar un Libro
     */
    public void ingresarLibro(String titulo, String editorial, String isbn, TipoLinguaLibros tipoLingua, int exemplares) throws ISBNIncorrecto, ExemplarInvalido{

        Libro l = new Libro(titulo, editorial, isbn, tipoLingua, exemplares);
        libros.put(isbn, l);
    }

    /**
     * Método encargado de avaliar se existe un libro
     */
    public boolean existeLibro(String isbn) throws LibroExistente{
        if (libros.containsKey(isbn)) {
            throw new LibroExistente("O libro xá existe!");
        } else {
            return true;
        }
    }

    /**
     * Método encargado de ingresar autores a un libro
     */
    public void ingresarAutoresLibro(String isbn,String autor){
        Libro l = libros.get(isbn);

        l.engadirAutores(autor);
    }
}



    /************* MÉTODOS PARA O MENÚ DE ADMINISTRADORES de BIBLIOTECA ***************/



//EXEMPLO ISBN: 0901690546