package utiles.excepcions;

public class UsuarioNonExiste extends Exception {
    
    public UsuarioNonExiste(String mensaxe){
        super(mensaxe);
    }
}
