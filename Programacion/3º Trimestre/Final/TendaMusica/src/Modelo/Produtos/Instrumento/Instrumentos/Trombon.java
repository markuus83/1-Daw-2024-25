package Modelo.Produtos.Instrumento.Instrumentos;

import Modelo.Excepcions.PrezoNegativo;
import Modelo.Excepcions.StockNegativo;
import Modelo.Produtos.Instrumento.InstrumentoMusical;

public class Trombon extends InstrumentoMusical{
    
    //Atributos
    private boolean transpositor;

    /**
     * Constructor propio da clase Frauta
     * 
     * @param idProduto -> Id automático de cada produto
     * @param prezo -> Prezo do produto
     * @param cantidadeEnStock -> Cantidade no Stock de cada Produto
     * @param descricion -> Descrición do produto
     * @param transpositor -> Ten transpositor 
     * @throws Excepcions.PrezoNegativo -> Posible excepción de prezo negativo
     * @throws Excepcions.StockNegativo -> Posible excepción de stock negativo
     */
    public Trombon(String marca, String modelo, double prezo, int cantidadeEnStock, String descricion, boolean transpositor) throws PrezoNegativo, StockNegativo {
        super(marca, modelo, prezo, cantidadeEnStock, descricion);
        this.transpositor = transpositor;
    }

    //Getters&Setters
    public boolean getTranspositor(){
        return transpositor;
    }

    //Metodos
    @Override
    public String toString(){
        return "Trombon: "+super.toString();
    }
}
