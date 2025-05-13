package modelo.usuarios;

import java.io.Serializable;

import utiles.clasesStatic.HashPasword;
import utiles.enumerandos.TipoUsuario;
import utiles.excepcions.ContrasinalIncorrecto;

public abstract class Usuario implements Serializable{
    
    //Atributos
    private String nomeUsuario;
    private String contrasinal;

    /**
     * Método Constructor da clase Usuario
     * 
     * @param contrasinal -> Contrasinal 
     * @param nomeUsuario -> Nome de usuario
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

    public boolean comprobarPassword(String password) throws ContrasinalIncorrecto{
        if(this.getContrasinal().equals(HashPasword.hashPassword(password))){
            return true;
        } else{
            throw new ContrasinalIncorrecto("Contrasinal incorrecto!");
        }
        
    }


    public abstract TipoUsuario getRol();
}
