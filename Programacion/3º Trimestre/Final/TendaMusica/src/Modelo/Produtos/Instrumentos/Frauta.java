package Modelo.Produtos.Instrumentos;

import Modelo.Excepcions.PrezoNegativo;
import Modelo.Excepcions.StockNegativo;

public class Frauta extends InstrumentoMusical{

    //Atributos
    private boolean pe;

    /**
     * Constructor propio da clase Frauta
     * 
     * @param idProduto -> Id automático de cada produto
     * @param prezo -> Prezo do produto
     * @param cantidadeEnStock -> Cantidade no Stock de cada Produto
     * @param descricion -> Descrición do produto
     * @param pe -> Ten pe 
     * @throws Excepcions.PrezoNegativo -> Posible excepción de prezo negativo
     * @throws Excepcions.StockNegativo -> Posible excepción de stock negativo
     */
    public Frauta(String marca, String modelo, double prezo, int cantidadeEnStock, String descricion, boolean pe) throws PrezoNegativo, StockNegativo {
        super(marca, modelo, prezo, cantidadeEnStock, descricion);
        this.pe = pe;
    }

    //Getters&Setters
    public boolean getPe(){
        return pe;
    }

    //Metodos
    @Override
    public String toString(){
        return "Frauta: "+super.toString();
    }

}
