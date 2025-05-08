package modelo.libros;

import java.util.ArrayList;
import java.util.stream.Collectors;
import utiles.clasesStatic.ComprobarISBN10;
import utiles.enumerandos.TipoLinguaLibros;
import utiles.excepcions.ISBNIncorrecto;

public class Libro {
    
    //atributos
    private String isbn;
    private String titulo;
    private ArrayList<String> autor;
    private TipoLinguaLibros lingua;
    private String editorial;

    
    /**
     * Método constructor da clase Libro
     * 
     * @param isbn -> ISBN do libro
     * @param titulo -> Titulo do libro
     * @param autor -> Autor/es do libro
     * @param tipo -> Lingua na que está escrita o libro
     * @param editorial -> Editorial do libro
     * @throws ISBNIncorrecto -> Posible excepción personalizada do libro
     */
    public Libro(String isbn, String titulo, TipoLinguaLibros tipo, String editorial) throws ISBNIncorrecto {
        this.setIsbn(isbn);
        this.setTipo(tipo);
        this.autor = new ArrayList<>();
        this.setTipo(tipo);
        this.setEditorial(editorial);
    }
    public String getIsbn() {
        return isbn;
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

    @Override
    public String toString(){
        return this.getIsbn()+", "+this.getTitulo()+" de "+this.getAutores()+" en "+this.getLingua()+" ("+this.getEditorial()+")";
    }
}
