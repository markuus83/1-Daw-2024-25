package Modelo.Produtos;

import Modelo.Excepcions.PrezoNegativo;
import Modelo.Excepcions.StockExcedente;
import Modelo.Excepcions.StockNegativo;

public abstract class Produto {
    
    //Atributos
    private int idProduto;
    private double prezo;
    private int cantidadeEnStock;
    private String descricion;

    //IVE
    private static final double IVE = 0.21;
    private static int contador = 0;

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
    public Produto(double prezo, int cantidadeEnStock, String descricion) throws PrezoNegativo, StockNegativo{
        
        this.setPrezo(prezo);
        this.setCantidadeEnStock(cantidadeEnStock);
        this.setDescricion(descricion);

        //Poñémolo de último para que non existan incompatibilidades de IDs
        this.idProduto = contador++;
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
     * Establecemos o prezo do produto
     * 
     * @param prezo -> Prezo a establecer 
     * @throws Excepcions.PrezoNegativo -> Posible excepción a capturar
     */
    public void setPrezo(double prezo) throws Modelo.Excepcions.PrezoNegativo {
        if (prezo>=0) {
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
    public void setCantidadeEnStock(int cantidadeEnStock) throws Modelo.Excepcions.StockNegativo{
        if (cantidadeEnStock>=0) {
            this.cantidadeEnStock = cantidadeEnStock;
        } else{
            throw new StockNegativo("Stock Negativo!");
        }
    }

    /**
     * Método encargado de aumentar o stock
     * 
     * @param engadirStock
     */
    public void aumentarStock(int engadirStock){
        this.cantidadeEnStock += engadirStock;
    }

    /**
     * Método encargado de diminuir o stock
     * 
     * @param diminuirStock
     * @throws StockNegativo
     */
    public void diminuirStock(int diminuirStock) throws StockExcedente, StockNegativo{

        if (diminuirStock <= 0) {
            throw new StockNegativo("Stock negativo");
        }
        if (this.cantidadeEnStock < diminuirStock) {
            throw new StockExcedente("Eliminaches Stock de mais!");
        }
        this.cantidadeEnStock -= diminuirStock;
    }

    @Override
    public String toString(){
        return "Prezo con IVE "+this.getPrezoConIVE()+" €; Prezo sen IVE: "+this.getPrezoSenIVE()+" €; Stock: "+this.getCantidadeEnStock()+" unidades; Descrición: "+this.getDescricion()+".";
    }
}
