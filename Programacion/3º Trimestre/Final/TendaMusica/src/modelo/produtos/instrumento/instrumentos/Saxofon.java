package modelo.produtos.instrumento.instrumentos;

import modelo.excepcions.PrezoNegativo;
import modelo.excepcions.StockNegativo;
import modelo.produtos.instrumento.InstrumentoMusical;
import utiles.enumerandos.TipoSaxofon;

public class Saxofon extends InstrumentoMusical{
    
    //Atributos
    private TipoSaxofon tipoSaxofon;

    /**
     * Constructor propio da clase Saxofon
     * 
     * @param idProduto -> Id automático de cada produto
     * @param prezo -> Prezo do produto
     * @param cantidadeEnStock -> Cantidade no Stock de cada Produto
     * @param descricion -> Descrición do produto
     * @param tipoSaxofon -> Tipo de saxofon
     * @throws Excepcions.PrezoNegativo -> Posible excepción de prezo negativo
     * @throws Excepcions.StockNegativo -> Posible excepción de stock negativo
     */
    public Saxofon(String marca, String modelo, double prezo, int cantidadeEnStock, String descricion, TipoSaxofon tipoSaxofon) throws PrezoNegativo, StockNegativo {
        super(marca, modelo, prezo, cantidadeEnStock, descricion);
        this.tipoSaxofon = tipoSaxofon;
    }

    //Getters
    public TipoSaxofon getTipoSaxofon() {
        return tipoSaxofon;
    }

    @Override
    public String toString() {
        return "Saxofon: "+this.getTipoSaxofon()+" "+super.toString();
    }

}
