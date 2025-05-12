package vista;

import modelo.usuarios.Usuario;

public abstract class MenuUsuario extends Menu{
    
    private Usuario usuario;

    public MenuUsuario(Usuario usuario) {
        super();
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
