package Modelo.Produtos.Complementos;

import Modelo.Excepcions.PrezoNegativo;
import Modelo.Excepcions.StockNegativo;
import Modelo.Produtos.Produto;

public abstract class Complemento extends Produto {

    /**
     * Constructor propio da clase Complemento
     * 
     * @param prezo -> Prezo do complemento
     * @param cantidadeEnStock -> Cantidade no Stock de cada complemento
     * @param descricion -> Descrición do complemento
     * @throws Excepcions.PrezoNegativo -> Posible excepción de prezo negativo
     * @throws Excepcions.StockNegativo -> Posible excepción de stock negativo
     */
    public Complemento(double prezo, int cantidadeEnStock, String descricion) throws PrezoNegativo, StockNegativo {
        super(prezo, cantidadeEnStock, descricion);
    }
    
}
