package modelo.usuarios;

import utiles.clasesStatic.HashPasword;
import utiles.enumerandos.TipoUsuario;

public abstract class Usuario {
    
    //Atributos
    private String nomeUsuario;
    private String contrasinal;
    
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
