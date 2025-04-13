package Modelo.Excepcions;

public class ProdutoSenStock extends Exception {
    
    public ProdutoSenStock(String descricionProduto) {
        super("Non hai stock dispoñible para o produto: " + descricionProduto);
    }
}