package modelo.usuarios;

import java.io.Serializable;

import utiles.enumerandos.TipoUsuario;

public class AdministradorXeral extends Usuario implements Serializable{

    public AdministradorXeral(String contrasinal, String nomeUsuario) {
        super(contrasinal, nomeUsuario);
    }

    @Override
    public TipoUsuario getRol() {
        return TipoUsuario.ADMINISTRADOR_XERAL;
    }
    
}
