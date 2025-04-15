package Modelo.Excepcions;

public class UsuarioNonExiste extends Exception {
    public UsuarioNonExiste(String message) {
        super(message);
    }
}