package modelo.libros;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import modelo.bibliotecas.Biblioteca;
import utiles.enumerandos.TipoLinguaLibros;

public class Exemplar implements Serializable{
    
    //Atributos
    private int identificador;
    private Libro libro;
    private Biblioteca biblioteca;
    private boolean tenPrestamo;


    //atributos static
    private static int contador=0;

    
    /**
     * Método constructor da clase Exemplar
     * 
     * @param identificador -> Identificador do exemplar
     * @param libro -> Libro ao cal pertence o exemplar
     * @param biblioteca -> Biblioteca á cal pertence o exemplar
     */
    public Exemplar() {
        this.setLibro(libro);
        this.setBiblioteca(biblioteca);
        this.tenPrestamo = false;
        this.identificador = contador++;
    }

    //Getters&Setters
    public int getIdentificador() {
        return identificador;
    }

    public boolean getPrestamo(){
        return tenPrestamo;
    }

    public void engadirPrestamo(){
        this.tenPrestamo = true;
    }

    public void eliminarPrestamo(){
        this.tenPrestamo = true;
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
        return libro.getAutoresTexto();
    }

     /**
     * Método encargado de devolver nunha lista cos autores ordenados por nome
     */
    public List<String> getAutoresOrdenados(){

        List<String> autoresOrdenados = 
        libro   .getAutores()
                .stream()
                .sorted((c1,c2) -> c1.compareTo(c2))
                .collect(Collectors.toList());

        return autoresOrdenados;
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
