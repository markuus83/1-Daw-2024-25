package Modelo.Usuarios;

import Utiles.HashPasword;
import Utiles.Enumerandos.TipoUsuario;

public abstract class Usuario {
    
    //Atributos
    private String nomeUsuario;
    private String contrasinal;
    
    /**
     * Constructor propio da clase Usuario, onde pasamos como parámetros todos os atributos da propia clase.
     * 
     * @param contrasinal -> Hash do contrasinal
     * @param nomeUsuario -> Nome do usuario
     * @param rol -> Rol do usuario
     */
    public Usuario(String contrasinal, String nomeUsuario) {
        this.setNomeUsuario(nomeUsuario);
        this.setContrasinal(contrasinal);
    }

    //Getters&Setters
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public String getContrasinal() {
        return contrasinal;
    }
    public void setContrasinal(String contrasinal) {
        this.contrasinal = HashPasword.hashPassword(contrasinal);
    }
    public abstract TipoUsuario getRol();
}
