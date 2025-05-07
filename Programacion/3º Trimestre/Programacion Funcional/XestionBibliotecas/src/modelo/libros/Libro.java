package modelo.libros;

import java.util.ArrayList;
import java.util.stream.Collectors;
import utiles.clasesStatic.ComprobarISBN10;
import utiles.enumerandos.TipoLinguaLibros;
import utiles.excepcions.ExemplarInvalido;
import utiles.excepcions.ISBNIncorrecto;

public class Libro {
    
    //Atributos
    private String titulo;
    private ArrayList<String> autores;
    private String editorial;
    private String isbn;
    private TipoLinguaLibros lingua;
    private int exemplares;

    /**
     * Método constructor da clase Libro
     * 
     * @param titulo -> Título do libro
     * @param autores -> Autor/es do libro
     * @param editorial -> Editorial do libro
     * @param isbn -> ISBN do libro
     * @param lingua -> Lingua na que está escrita o libro
     * @throws ISBNIncorrecto -> Posible excepción personalizada a capturar
     * @throws ExemplarInvalido -> Posible excepción personalizada a capturar
     */
    public Libro(String titulo, String editorial, String isbn, TipoLinguaLibros lingua, int exemplares) throws ISBNIncorrecto, ExemplarInvalido {
        this.setTitulo(titulo);
        this.autores = new ArrayList<>();
        this.setEditorial(editorial);
        this.setIsbn(isbn);
        this.setLingua(lingua);
        this.setExemplares(exemplares);
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public String getIsbn() {
        return isbn;
    }
    public TipoLinguaLibros getLingua() {
        return lingua;
    }
    public void setLingua(TipoLinguaLibros lingua) {
        this.lingua = lingua;
    }
    public int getExemplares(){
        return exemplares;
    }
    
    /**
     * Método encargado de avaliar os exemplares dun libro
     */
    public void setExemplares(int exemplares) throws ExemplarInvalido{
        if (exemplares <=0) {
            throw new ExemplarInvalido("Exemplar inválido!");
        } else{
            this.exemplares = exemplares;
        }
    }

    /**
     * Método encargado de devolver nunha cadea de texto todos os autores separados por un ";"
     */
    public String getAutores(){
        return this.autores.stream().collect(Collectors.joining("; ","",""));
    }

    /**
     * Método encargado para engadir autores ao ArrayList
     */
    public void engadirAutores(String a){
        autores.add(a);
    }

    /**
     * Método encargado de avaliar o ISBN dun libro
     */
    public void setIsbn(String isbn) throws ISBNIncorrecto {
        if (ComprobarISBN10.comprobarISBN10(isbn)) {
            this.isbn = isbn;
        } else{
            throw new ISBNIncorrecto("ISBN incorrecto!");
        }
    }
    
    @Override
    public String toString(){
        return this.getIsbn()+", "+this.getTitulo()+" de "+this.getAutores()+" en "+this.getLingua()+" ("+this.getEditorial()+"):";
    }

}
