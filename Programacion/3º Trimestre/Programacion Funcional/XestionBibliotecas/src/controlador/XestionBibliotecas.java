package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

//Imports estructuras de datos
import java.util.HashMap;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import io.XestionBibliotecasIO;
import modelo.bibliotecas.Biblioteca;
import modelo.libros.Exemplar;
import modelo.libros.Libro;
import modelo.libros.Prestamo;
import modelo.usuarios.AdministradorBiblioteca;
import modelo.usuarios.AdministradorXeral;
import modelo.usuarios.Cliente;
import modelo.usuarios.Usuario;
import utiles.enumerandos.TipoLinguaLibros;
import utiles.enumerandos.TipoUsuario;
import utiles.excepcions.BibliotecaTenAdmin;
import utiles.excepcions.BibliotecasNonExiste;
import utiles.excepcions.ClienteSancionado;
import utiles.excepcions.ContrasinalIncorrecto;
import utiles.excepcions.CorreoInvalido;
import utiles.excepcions.DNIIncorrecto;
import utiles.excepcions.DNIRepetido;
import utiles.excepcions.ExemplarExistente;
import utiles.excepcions.ExemplarInvalido;
import utiles.excepcions.ExemplarNonExiste;
import utiles.excepcions.ExemplarXaAsignado;
import utiles.excepcions.ISBNIncorrecto;
import utiles.excepcions.IndiceInvalido;
import utiles.excepcions.LibroExistente;
import utiles.excepcions.PrestamoActivo;
import utiles.excepcions.UsuarioExistente;
import utiles.excepcions.UsuarioNonExiste;



public class XestionBibliotecas implements Serializable{

    //Estructuras de control
    private HashMap<String, Usuario> usuarios;
    private HashMap<String, AdministradorBiblioteca> administradoresBiblioteca;
    private HashMap<Integer, Biblioteca> bibliotecas;
    private HashMap<String, Libro> libros;
    private HashMap<Integer, Exemplar> exemplares;
    private HashMap<String, Cliente> clientes;
    private ArrayList<Prestamo> prestamos;

    /************* MÉTODOS PARA A CREACIÓN DO PATRÓN SINGLETON ***************/
    
    private static XestionBibliotecas INSTANCE;


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
    
    /**
     * Constructor privado (patrón Singleton)
     */
    private XestionBibliotecas() {
        usuarios = new HashMap<>();
        bibliotecas = new HashMap<>();
        libros = new HashMap<>();
        exemplares = new HashMap<>();
        clientes = new HashMap<>();
        administradoresBiblioteca = new HashMap<>();
        prestamos = new ArrayList<>();
    }

    /**
     * Método para obter a instancia Singleton
     */
    public static XestionBibliotecas getInstance(){

        if (INSTANCE == null) {
            Optional<XestionBibliotecas> lectura = XestionBibliotecasIO.cargar();
            if (lectura.isEmpty()) {
                INSTANCE = new XestionBibliotecas();
                INSTANCE.engadirDatos();
                INSTANCE.gardar();
            } else{
                INSTANCE = lectura.get();
            }
        }
        return INSTANCE;
    }

    
    /**
     * Método encargado de gardar os datos no arquivo correspondente
     */
    private void gardar() {
        XestionBibliotecasIO.gardar(INSTANCE);
    }


    /**
     * Evita que se poida clonar a instancia Singleton
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }



    /************* MÉTODOS PARA O MENÚ DE INICIO ***************/

    private Optional<Usuario> getUsuario(String username) {
        if (this.usuarios.containsKey(username)) {
            return Optional.of(this.usuarios.get(username));
        }
        return Optional.empty();
    }

    public Optional<Usuario> login(String username, String password) throws ContrasinalIncorrecto {
        Optional<Usuario> user = this.getUsuario(username);
        if(user.isPresent()) {
            if(user.get().comprobarPassword(password)) return user;
            return Optional.empty();
        }
        return Optional.empty();
        

    }

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
     * Método encargado de engadir un Cliente
     */
    public void ingresarCliente(String contrasinal, String nomeUsuario,String nome, String Apelidos, String dni, String correo ) throws DNIIncorrecto, CorreoInvalido{
        
        Cliente c = new Cliente(contrasinal, nomeUsuario, nome, Apelidos, dni, correo);
        
        usuarios.put(nomeUsuario, c);
        clientes.put(dni, c);
        
        this.gardar();
    }

    /**
     * Método encargado de engadir un Administrador Xeral
     */
    public void ingresarAdministradorXeral(String contrasinal, String nomeUsuario){

        AdministradorXeral a = new AdministradorXeral(contrasinal, nomeUsuario);
        usuarios.put(nomeUsuario, a);

        this.gardar();
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

    /**
     * Método encargado de comprobar que non se repite un dni
     */
    public boolean dniUnico(String dni) throws DNIRepetido{
        if (clientes.containsKey(dni)) {
            throw new DNIRepetido("DNI xa rexistrado!");
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

        this.gardar();
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
     * Método encargado de ingresar un Libro
     */
    public void ingresarLibro(String titulo, String editorial, String isbn, TipoLinguaLibros tipo, int exemplares) throws ISBNIncorrecto, ExemplarInvalido{

        Libro l = new Libro(isbn, titulo, tipo, editorial, exemplares);

        libros.put(isbn, l);
        this.gardar();

    }

    /**
     * Método encargado de ingresar autores a un libro
     */
    public void ingresarAutoresLibro(String isbn, String autor){
        Libro l = libros.get(isbn);

        l.engadirAutores(autor);
        this.gardar();
    }

    /**
     * Método encargado de ingresar exemplares
     * 
     */
    public void ingresarExemplares(int cantidade, String isbnLibro) {
        Libro l = libros.get(isbnLibro);

        for (int i = 0; i < cantidade; i++) {
            Exemplar e = new Exemplar(l);
            
            exemplares.put(e.getIdentificador(), e);

            l.engadirExemplar(e.getIdentificador(), e);
            
            this.gardar();
        }   
    }


    /**
     * Método encargado de devolver nunha cadea de texto todos os nomes de usuarios existentes no programa
     */
    public String imprimirNomesUsuarios(){
        String resposta;

        resposta = usuarios .values()
                            .stream()
                            .map(c-> c.getNomeUsuario())
                            .collect(Collectors.joining("\n","Usuarios existentes:\n",""));

        return resposta;
    }

    /**
     * Método encargado de amosar todas as Bibliotecas nunha cadea de texto
     */
    public String amosarBibliotecas(){
        if (bibliotecas.isEmpty()) {
            return "Non existen bibliotecas! ";
        }
        String resposta = bibliotecas   .values()
                                        .stream()
                                        .map(c -> c.toString())
                                        .collect(Collectors.joining("\n"));
        return resposta;
    }
    
    /**
     * Método encargado de amosar os Libros existentes
     */
    public String amosarLibos(){
        if (libros.isEmpty()) {
            return "Non existen Libros! ";
        }
        String resposta = libros    .values()
                                    .stream()
                                    .map(c -> c.toString())
                                    .collect(Collectors.joining("\n"));
        return  resposta;
           
    }


    /**
     * Método encargado de engadir un Exemplar a unha Biblioteca
     */
    public void engadirExemplarABiblioteca(int idB, int idE) throws ExemplarExistente, IndiceInvalido {

        if (bibliotecas.containsKey(idB) || exemplares.containsKey(idE)) {
            Biblioteca b = bibliotecas.get(idB);
            Exemplar e = exemplares.get(idE);

            if (b.comprobarIdExistente(idE)) {
                b.engadirExemplares(e);
                this.gardar();
            } else{
                this.gardar();
                throw new ExemplarExistente("Exemplar xa existente!");
            }

        } else{
            this.gardar();
            throw new IndiceInvalido("Indice inválido!");
        }
    }

    /**
     * Método encargado de comprobar se unha biblioteca ten admin ou non
     */
    public boolean bibliotecaNonTenAdmin(int idB) throws BibliotecaTenAdmin, IndiceInvalido{

        if (!(bibliotecas.containsKey(idB))) {
            this.gardar();
            throw new IndiceInvalido("Índice inválido!");
        }
        
        Biblioteca b = bibliotecas.get(idB);

        if (b.isTenAdmin()) {
            this.gardar();
            throw new BibliotecaTenAdmin("A biblioteca seleccionada xa ten un Administrador!");
        }
        return true;
    }
    
    /**
     * Método encargado de ingresar un Administrador a unha biblioteca
     */
    public void ingresarAdministradorBiblioteca(String nomeUser, String contrasinal, int id) throws IndiceInvalido{

        if (bibliotecas.containsKey(id)) {

            Biblioteca b = bibliotecas.get(id);
            AdministradorBiblioteca ab = new AdministradorBiblioteca(contrasinal, nomeUser, b);

            usuarios.put(nomeUser, ab);
            administradoresBiblioteca.put(ab.getNomeUsuario(), ab);
            this.gardar();

        } else{
            this.gardar();
            throw new IndiceInvalido("Índice inválido");
        }

    }

    /**
     * Método encargado de comprobar que o exemplar existe
     */
    public boolean existeExemplar(int idE) throws ExemplarNonExiste{
        if (exemplares.containsKey(idE)) {
            return true;
        } else{
            this.gardar();
            throw new ExemplarNonExiste("O exemplar non existe!");
        }
    }


    /**
     * Método encargado de comprobar se o exemplar xa está asignado a outra biblioteca
     */
    public boolean exemplarXaAsignado(int idE) throws ExemplarXaAsignado{

        Exemplar e = exemplares.get(idE);

        if (e.getBiblioteca().isPresent()) {
            this.gardar();
            throw new ExemplarXaAsignado("O exemplar xa está asignado noutra biblioteca!");
        } else{
            return true;
        }

    }


    
    /************* MÉTODOS PARA O MENÚ DE ADMINISTRADORES de BIBLIOTECA ***************/
    
    public String amosarExemplaresLibresDunhaBiblioteca(String nomeAdmin) {
    AdministradorBiblioteca a = administradoresBiblioteca.get(nomeAdmin);

    if (a == null) {
        return "Erro: O administrador non existe ou non está rexistrado.";
    }

    Biblioteca b = a.getBiblioteca();
    if (b == null) {
        return "Erro: O administrador non ten unha biblioteca asignada.";
    }

    return b.getExemplaresLibres()
            .stream()
            .map(c -> c.toString())
            .collect(Collectors.joining("\n"));
}

    /**
     * Método encargado de comprobar se un cliente ten un préstamo activo
     */
    public boolean tenPrestamoActivo(String dni) throws PrestamoActivo{
        Cliente c = clientes.get(dni);

        if (c.tenPrestamoActivo()) {
            this.gardar();
            throw new PrestamoActivo("Xa ten un préstamo activo");
        } else{
            return true;
        }

    }

    /**
     * Método encargado de ingresar un préstamo
     */
    public void ingresarPrestamo(int idE, String dniC) throws IndiceInvalido, PrestamoActivo, ClienteSancionado{

        if (exemplares.containsKey(idE) && clientes.containsKey(dniC)) {
            Exemplar e = exemplares.get(idE);
            Cliente c = clientes.get(dniC);
            
            Prestamo p = new Prestamo(e, c);

            prestamos.add(p);
            this.gardar();
            
        } else{
            this.gardar();
            throw new IndiceInvalido("Índice inválido!");
        }
        
    }

    /**
     * Método encargado de amosar os exemplares libres dunha biblioteca ordenados por titulo
     */
    public String amosarExemplaresLibresOrdenadosTitulo(String titulo){

        Pattern patron = Pattern.compile(".*"+titulo+".*");

        return exemplares   .values()
                            .stream()
                            .filter(exemplares -> patron.matcher(exemplares.getTituloLibro()).matches())
                            .filter(exemplares -> !exemplares.getPrestamo())
                            .filter(exemplares -> exemplares.getBiblioteca().isPresent())
                            .sorted(Comparator.comparing(exemplar -> exemplar.getTituloLibro()))
                            .map(exemplares -> exemplares.toString())
                            .collect(Collectors.joining("\n"));
    }


    /**
     * Método encargado de ordenaro os exemplares libres dunha biblioteca por Autor
     */
    public String amosarExemplaresLibresOrdenadosAutor(String autor){
        
        Pattern patron = Pattern.compile(".*"+autor+".*");

        return exemplares   .values()
                            .stream()
                            .filter(exemplares -> patron.matcher(exemplares.getAutoresLibro()).matches())
                            .filter(exemplares -> !exemplares.getPrestamo())
                            .filter(exemplares -> exemplares.getBiblioteca().isPresent())
                            .sorted(Comparator.comparing(exemplar -> exemplar.getAutoresLibro()))
                            .map(exemplares -> exemplares.toString())
                            .collect(Collectors.joining("\n"));
    }


    /**
     * Método encargado de ingresar un libro mediante el .CSV
     */
    public void ingresarLibroConCSV(String titulo, String editorial, String isbn, TipoLinguaLibros lingua, int numExemplares, String[] autores) throws ISBNIncorrecto, ExemplarInvalido{

        Libro libro = new Libro(isbn, titulo, lingua, editorial, numExemplares);

        for (String autor : autores) {
            libro.engadirAutores(autor.trim());
        }

        libros.put(isbn, libro);
        this.gardar();
    }
}







//EXEMPLO ISBN: 0901690546