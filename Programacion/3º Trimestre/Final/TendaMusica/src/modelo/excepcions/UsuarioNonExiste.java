package modelo.excepcions;

public class UsuarioNonExiste extends Exception {
    public UsuarioNonExiste(String message) {
        super(message);
    }
}