package Modelo.Usuarios;

import Utiles.Enumerandos.TipoUsuario;

public class Administrador extends Usuario {
    
    /**
     * Constructor da clase Administrador
     * 
     * @param contrasinal -> Hash do contrasinal
     * @param nomeUsuario -> Nome do usuario
     * @param rol -> Rol do usuario
     */
    public Administrador(String contrasinal, String nomeUsuario) {
        super(contrasinal, nomeUsuario);
    }
   
    public TipoUsuario getRol() {
        return TipoUsuario.ADMINISTRADOR;
    }
}
