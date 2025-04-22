package modelo.usuarios;

import utiles.enumerandos.TipoUsuario;

public class Cliente extends Usuario {
    
    /**
     * Constructor da clase Cliente
     * 
     * @param contrasinal -> Hash do contrasinal
     * @param nomeUsuario -> Nome do usuario
     * @param rol -> Rol do usuario
     */
    public Cliente(String contrasinal, String nomeUsuario, TipoUsuario rol) {
        super(contrasinal, nomeUsuario, rol);
    }
   
}
