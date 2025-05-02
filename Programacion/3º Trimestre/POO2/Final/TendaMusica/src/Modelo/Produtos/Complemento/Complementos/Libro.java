package Modelo.Produtos.Complemento.Complementos;

import Modelo.Excepcions.ISBNIncorrecto;
import Modelo.Excepcions.PrezoNegativo;
import Modelo.Excepcions.StockNegativo;
import Modelo.Produtos.Complemento.Complemento;

public class Libro extends Complemento{
    
    //Atributos
    private String titulo;
    private String autor;
    private String isbnLibro;
    
    /**
     * Constructor propio da clase Libro
     * 
     * @param prezo -> Prezo do Libro
     * @param cantidadeEnStock -> Cantidade no Stock de cada Libro
     * @param descricion -> Descrición do Libro
     * @param titulo -> Titulo do libro
     * @param autor -> Autor do libro
     * @param isbnLibro -> ISBN do libro
     * @throws PrezoNegativo
     * @throws StockNegativo
     * @throws ISBNIncorrecto
     */
    public Libro(double prezo, int cantidadeEnStock, String descricion, String titulo, String autor, String isbnLibro) throws PrezoNegativo, StockNegativo, ISBNIncorrecto {
        super(prezo, cantidadeEnStock, descricion);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setIsbnLibro(isbnLibro);
    }
    //Getters&Setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getIsbnLibro() {
        return isbnLibro;
    }
    
    /**
     * Método encargado de avaliar se o ISBN é correcto ou non
     * 
     * @param isbnLibro -> ISBN a avaliar
     * @throws ISBNIncorrecto -> Posible excepción a capturar
     */
    public void setIsbnLibro(String isbnLibro) throws ISBNIncorrecto {
        if (Utiles.ComprobarISBN10.comprobarISBN10(isbnLibro)) {
            this.isbnLibro = isbnLibro;
        } else{
            throw new ISBNIncorrecto("ISBN incorrecto!");
        }
    }

    @Override
    public String toString(){
        return "Libro "+"("+this.getIdProduto()+")"+": "+this.getTitulo()+", ISBN: "+this.getIsbnLibro()+". "+super.toString();
    }
    
}
