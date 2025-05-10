package modelo.libros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import utiles.clasesStatic.ComprobarISBN10;
import utiles.enumerandos.TipoLinguaLibros;
import utiles.excepcions.ExemplarInvalido;
import utiles.excepcions.ISBNIncorrecto;

public class Libro implements Serializable{
    
    //Atributos
    private String isbn;
    private String titulo;
    private ArrayList<String> autor;
    private TipoLinguaLibros lingua;
    private int numExemplares;
    private String editorial;
    private HashMap<Integer,Exemplar> exemplares;
    
    /**
     * Método constructor da clase Libro
     * 
     * @param isbn -> ISBN do libro
     * @param titulo -> Titulo do libro
     * @param autor -> Autor/es do libro
     * @param tipo -> Lingua na que está escrita o libro
     * @param editorial -> Editorial do libro
     * @throws ISBNIncorrecto -> Posible excepción personalizada do libro
     * @throws ExemplarInvalido -> Posible excepción personalizada do libro
     */
    public Libro(String isbn, String titulo, TipoLinguaLibros tipo, String editorial, int numExemplares) throws ISBNIncorrecto, ExemplarInvalido {
        this.setIsbn(isbn);
        this.setTitulo(titulo);
        this.autor = new ArrayList<>();
        this.setTipo(tipo);
        this.setEditorial(editorial);
        this.setNumExemplares(numExemplares);
        this.exemplares = new HashMap<>();
    }

    //Getters&Setters
    public String getIsbn() {
        return isbn;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setLingua(String titulo) {
        this.titulo = titulo;
    }
    public TipoLinguaLibros getLingua() {
        return lingua;
    }
    public void setTipo(TipoLinguaLibros lingua) {
        this.lingua = lingua;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public int getnumExemplares(){
        return numExemplares;
    }

    /**
     * Método encargado de avaliar a cantidade de exemplares
     */
    public void setNumExemplares(int numExemplares) throws ExemplarInvalido{
        if (numExemplares <= 0) {
            throw new ExemplarInvalido("Cantidade inválida!");
        }
        else{
            this.numExemplares = numExemplares;
        }
    }

    /**
     * Método encargado de avaliar se un ISBN é correcto
     */
    public void setIsbn(String isbn) throws ISBNIncorrecto {
        if (ComprobarISBN10.comprobarISBN10(isbn)) {
            this.isbn = isbn;
        } else{
            throw new ISBNIncorrecto("ISBN incorrecto!");
        }
    }

    /**
     * Método encargado de engadir autor/es a un libro
     */
    public void engadirAutores(String a){
        autor.add(a);
    }
    
    /**
     * Método encargado de devolver nunha cadea de texto todos os autores separados por un ";"
     */
    public String getAutores(){
        return this.autor   .stream()
                            .collect(Collectors.joining("; ","",""));
    }

    
    /**
     * Método encargado de eliminar un exemplar
     */
    public void eliminarExemplar(int id){
        exemplares.remove(id);
    }

    /**
     * Método encargado de engadir un exemplar a un Libro
     */
    public void engadirExemplar(int idExemplar, Exemplar e) {

        exemplares.put(idExemplar, e);
    }

    @Override
    public String toString(){
        return this.getIsbn()+", "+this.getTitulo()+" de "+this.getAutores()+" en "+this.getLingua()+" ("+this.getEditorial()+")";
    }
}
