package Modelo.Users;

import Utils.TipoUsuario;

public class Administrador extends Usuario{
    
    /**
     * 
     * @param nomeUsuario
     * @param contrasinal
     * @param user
     */
    public Administrador(String nomeUsuario, String contrasinal, TipoUsuario user) {
        super(nomeUsuario, contrasinal, user);
    }
}
