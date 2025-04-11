package Modelo.Produtos;

import Modelo.Excepcions.PrezoNegativo;
import Modelo.Excepcions.StockNegativo;

public abstract class Instrumentos extends Produto{
    
    //Atributos
    private String marca;
    private String modelo;
    
    /**
     *  Constructor propio da clase Instrumento musical
     * 
     * @param idProduto
     * @param prezo
     * @param cantidadeEnStock
     * @param descricion
     * @param marca
     * @param modelo
     * @throws PrezoNegativo
     * @throws StockNegativo
     */
    public Instrumentos(int idProduto, double prezo, int cantidadeEnStock, String descricion, String marca, String modelo) throws PrezoNegativo, StockNegativo {

        super(idProduto, prezo, cantidadeEnStock, descricion);

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

    @Override
    public String toString(){
        return this.getMarca()+" - "+this.getModelo()+" "+super.toString()+". ";
    }
}
