package modelo.usuarios;

import utiles.enumerandos.TipoUsuario;

public class AdministradorXeral extends Usuario{

    public AdministradorXeral(String contrasinal, String nomeUsuario) {
        super(contrasinal, nomeUsuario);
    }

    @Override
    public TipoUsuario getRol() {
        return TipoUsuario.ADMINISTRADOR_XERAL;
    }
    
}
