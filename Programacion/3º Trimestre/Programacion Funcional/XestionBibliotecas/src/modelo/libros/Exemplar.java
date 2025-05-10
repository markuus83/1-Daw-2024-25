package modelo.libros;

import java.io.Serializable;

import modelo.bibliotecas.Biblioteca;
import utiles.enumerandos.TipoLinguaLibros;

public class Exemplar implements Serializable{
    
    //Atributos
    private int identificador;
    private Libro libro;
    private Biblioteca biblioteca;


    //atributos static
    private static int contador;

    
    /**
     * Método constructor da clase Exemplar
     * 
     * @param identificador -> Identificador do exemplar
     * @param libro -> Libro ao cal pertence o exemplar
     * @param biblioteca -> Biblioteca á cal pertence o exemplar
     */
    public Exemplar() {
        this.identificador = contador++;
        this.setLibro(libro);
        this.setBiblioteca(biblioteca);
    }

    //Getters&Setters
    public int getIdentificador() {
        return identificador;
    }

    /**
     * MÉTODOS PARA OBTER OS DATOS DO LIBRO
     */
    public String getTituloLibro() {
        return libro.getTitulo();
    }
    public String getIsbnLibro(){
        return libro.getIsbn();
    }
    public String getAutoresLibro(){
        return libro.getAutores();
    }
    public TipoLinguaLibros getLinguaLibro(){
        return libro.getLingua();
    }
    public String getEditorialLibro(){
        return libro.getEditorial();
    }
    
    /**
     * Método encargado de asignar un Libro
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * Método encargado de asignar unha Biblioteca
     */
    public void setBiblioteca(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString(){
        return this.getIsbnLibro()+", "+this.getTituloLibro()+" de "+this.getAutoresLibro()+" en "+this.getLinguaLibro()+" ("+this.getEditorialLibro()+"). ID Exemplar: "+this.getIdentificador();
    }
    
}
