package modelo.usuarios;

import utiles.enumerandos.TipoUsuario;

public class AdministradorBiblioteca extends Usuario {

    public AdministradorBiblioteca(String contrasinal, String nomeUsuario) {
        super(contrasinal, nomeUsuario);
    }

    @Override
    public TipoUsuario getRol() {
        return TipoUsuario.ADMINISTRADOR_BIBLIOTECA;
    }
    
}
