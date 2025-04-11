package Modelo.Usuarios;

import Utiles.Enumerandos.TipoUsuario;
import Utiles.HashPasword;

public abstract class Usuario {
    
    //Atributos
    private String nomeUsuario;
    private String contrasinal;
    private TipoUsuario rol;

    /**
     * Constructor propio da clase Usuario, onde pasamos como parámetros todos os atributos da propia clase.
     * 
     * @param contrasinal -> Hash do contrasinal
     * @param nomeUsuario -> Nome do usuario
     * @param rol -> Rol do usuario
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Usuario(String contrasinal, String nomeUsuario, TipoUsuario rol) {
        this.setNomeUsuario(nomeUsuario);
        this.setContrasinal(contrasinal);
        this.rol = rol;
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
    public TipoUsuario getRol() {
        return rol;
    }
    public void setRol(TipoUsuario rol) {
        this.rol = rol;
    }
}
