package modelo.excepcions;

public class UsuarioExistente extends Exception{
    
    public UsuarioExistente(String mensaxe){
        super(mensaxe);
    }
}
