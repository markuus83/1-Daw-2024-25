package Modelo.Produtos.Complemento.Complementos;

import Modelo.Excepcions.PrezoNegativo;
import Modelo.Excepcions.StockNegativo;
import Modelo.Produtos.Complemento.Complemento;
import Utiles.Enumerandos.TipoInstrumentoMusical;


public class Estoxo extends Complemento{
    
    private TipoInstrumentoMusical instrumento;
    private String marca;

    /**
     * 
     * @param prezo
     * @param cantidadeEnStock
     * @param descricion
     * @param instrumento
     * @param marca
     * @throws PrezoNegativo
     * @throws StockNegativo
     */
    public Estoxo(double prezo, int cantidadeEnStock, String descricion,TipoInstrumentoMusical instrumento, String marca) throws PrezoNegativo, StockNegativo {
        super(prezo, cantidadeEnStock, descricion);
        this.instrumento = instrumento;
        this.marca = marca;
    }

    public TipoInstrumentoMusical getInstrumento() {
        return instrumento;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString(){
        return "Estoxo "+"("+this.getIdProduto()+")"+": "+this.getMarca()+" para "+this.getInstrumento()+": "+super.toString();
    }
}