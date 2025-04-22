package Modelo.Excepcions;

public class ProdutoNonExiste extends Exception {
    
    public ProdutoNonExiste(int id) {
        super("Non existe ningún produto co identificador: " + id);
    }
}
