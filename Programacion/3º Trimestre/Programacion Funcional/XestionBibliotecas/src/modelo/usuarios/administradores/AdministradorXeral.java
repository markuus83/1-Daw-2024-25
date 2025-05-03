package modelo.usuarios.administradores;

import modelo.usuarios.Usuario;
import utiles.enumerandos.TipoUsuario;

public class AdministradorXeral extends Usuario {

    public AdministradorXeral(String contrasinal, String nomeUsuario) {
        super(contrasinal, nomeUsuario);
    }

    @Override
    public TipoUsuario getRol() {
        return TipoUsuario.ADMINISTRADOR_XERAL;
    }
    
}
