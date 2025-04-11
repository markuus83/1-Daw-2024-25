package Modelo.Excepcions;

public class StockNegativo extends Exception{
    
    public StockNegativo(String mensaxe){
        super(mensaxe);
    }
}
