package Modelo.Produtos;

import Modelo.Excepcions.PrezoNegativo;
import Modelo.Excepcions.StockNegativo;

public abstract class InstrumentoMusical extends Produto{

    /**
     * 
     * @param idProduto -> Id automático de cada produto
     * @param prezo -> Prezo do produto
     * @param cantidadeEnStock -> Cantidade no Stock de cada Produto
     * @param descricion -> Descrición do produto
     * @throws Excepcions.PrezoNegativo -> Posible excepción de prezo negativo
     * @throws Excepcions.StockNegativo -> Posible excepción de stock negativo
     */
    public InstrumentoMusical(int idProduto, double prezo, int cantidadeEnStock, String descricion) throws PrezoNegativo, StockNegativo {
        super(idProduto, prezo, cantidadeEnStock, descricion);
    }
    
}
