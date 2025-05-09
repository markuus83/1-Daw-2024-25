package modelo.libros;

import utiles.enumerandos.TipoLinguaLibros;

public class Exemplar {
    
    //Atributos
    private int identificador;
    private Libro libro;

    //atributos static
    private static int contador;



    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }


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
    

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    
}
