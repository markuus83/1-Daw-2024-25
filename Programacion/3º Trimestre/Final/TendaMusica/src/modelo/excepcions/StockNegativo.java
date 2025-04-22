package modelo.excepcions;

public class StockNegativo extends Exception{
    
    public StockNegativo(String mensaxe){
        super(mensaxe);
    }
}
