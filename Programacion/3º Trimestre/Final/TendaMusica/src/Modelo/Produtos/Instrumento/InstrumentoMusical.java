package Modelo.Produtos.Instrumento;

import Modelo.Excepcions.PrezoNegativo;
import Modelo.Excepcions.StockNegativo;
import Modelo.Produtos.Produto;

public abstract class InstrumentoMusical extends Produto{

    //Atributos
    private String marca;
    private String modelo;

    /**
     * Constructor propio da clase abstracta InstrumentoMusical
     * 
     * @param idProduto -> Id automático de cada produto
     * @param prezo -> Prezo do produto
     * @param cantidadeEnStock -> Cantidade no Stock de cada Produto
     * @param descricion -> Descrición do produto
     * @throws Excepcions.PrezoNegativo -> Posible excepción de prezo negativo
     * @throws Excepcions.StockNegativo -> Posible excepción de stock negativo
     */
    public InstrumentoMusical(String marca, String modelo, double prezo, int cantidadeEnStock, String descricion) throws PrezoNegativo, StockNegativo {
        super(prezo, cantidadeEnStock, descricion);
        this.setMarca(marca);
        this.setModelo(modelo);
    }

    //Getters&Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    

}
