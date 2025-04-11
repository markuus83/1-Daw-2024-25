package Modelo.Users;

import Utils.TipoUsuario;

public class Cliente extends Usuario{
    
    /**
     * 
     * @param nomeUsuario
     * @param contrasinal
     * @param user
     */
    public Cliente(String nomeUsuario, String contrasinal, TipoUsuario user) {
        super(nomeUsuario, contrasinal, user);
    }

}
