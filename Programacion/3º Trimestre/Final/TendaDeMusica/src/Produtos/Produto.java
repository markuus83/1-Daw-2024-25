package Produtos;

import Excepcions.PrezoNegativo;
import Excepcions.StockNegativo;

public abstract class Produto {
    
    //Atributos
    private int idProduto;
    private double prezo;
    private int cantidadeEnStock;
    private String descricion;

    //IVE
    private static final double IVE = 0.21;

    
    /**
     * Constructor propio da clase abstracta Produto
     * 
     * @param idProduto -> Id automático de cada produto
     * @param prezo -> Prezo do produto
     * @param cantidadeEnStock -> Cantidade no Stock de cada Produto
     * @param descricion -> Descrición do produto
     * @throws Excepcions.PrezoNegativo -> Posible excepción de prezo negativo
     * @throws Excepcions.StockNegativo -> Posible excepción de stock negativo
     */
    public Produto(int idProduto, double prezo, int cantidadeEnStock, String descricion) throws Excepcions.PrezoNegativo, Excepcions.StockNegativo{
        
        this.setPrezo(prezo);
        this.setCantidadeEnStock(cantidadeEnStock);
        this.setDescricion(descricion);

        //Poñémolo de último para que non existan incompatibilidades de IDs
        this.setIdProduto(idProduto);
    }
    public int getIdProduto() {
        return idProduto;
    }
    public double getPrezoSenIVE() {
        return prezo;
    }
    public double getPrezoConIVE(){
        return prezo * (1-IVE);
    }
    public int getCantidadeEnStock() {
        return cantidadeEnStock;
    }
    public String getDescricion() {
        return descricion;
    }
    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    /**
     * Establecemos o id de forma automática
     * 
     * @param idProduto -> Id do produto
     */
    public void setIdProduto(int idProduto) {
        this.idProduto++;
    }

    /**
     * Establecemos o prezo do produto
     * 
     * @param prezo -> Prezo a establecer 
     * @throws Excepcions.PrezoNegativo -> Posible excepción a capturar
     */
    public void setPrezo(double prezo) throws Excepcions.PrezoNegativo {
        if (prezo<=0) {
            this.prezo = prezo;   
        } else{
            throw new PrezoNegativo("Produto Negativo!");
        }
    }

    /**
     * Establecemos o Stock do produto
     * 
     * @param cantidadeEnStock -> Cantidade en stock
     * @throws Excepcions.StockNegativo -> Posible excpeción a capturar
     */
    public void setCantidadeEnStock(int cantidadeEnStock) throws Excepcions.StockNegativo{
        if (prezo<=0) {
            this.cantidadeEnStock = cantidadeEnStock;
        } else{
            throw new StockNegativo("Stock Negativo!");
        }
    }

    @Override
    public String toString(){
        return "Prezo con IVE "+this.getPrezoConIVE()+" €; Prezo sen IVE: "+this.getPrezoSenIVE()+" €; Stock: "+this.getCantidadeEnStock()+" unidades; Descrición: "+this.getDescricion()+".";
    }
    
}
