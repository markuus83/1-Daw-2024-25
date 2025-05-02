package Modelo.Usuarios;

import Utiles.Enumerandos.TipoUsuario;

public class Cliente extends Usuario {
    
    /**
     * Constructor da clase Cliente
     * 
     * @param contrasinal -> Hash do contrasinal
     * @param nomeUsuario -> Nome do usuario
     * @param rol -> Rol do usuario
     */
    public Cliente(String contrasinal, String nomeUsuario) {
        super(contrasinal, nomeUsuario);
    }
   
    public TipoUsuario getRol() {
        return TipoUsuario.CLIENTE;
    }
}
