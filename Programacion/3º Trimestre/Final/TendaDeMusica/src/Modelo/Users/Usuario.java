package Modelo.Users;

import Utils.HashPasword;
import Utils.TipoUsuario;

public class Usuario {
    
    //Atributos
    private String nomeUsuario;
    private String contrasinal;
    private TipoUsuario tipoUsuario;
    
    /**
     * Método Constructor da clase Usuario, onde recibe como parámetros todos os atributos da súa propia clase.
     * 
     * @param nomeUsuario -> Nome do usuario
     * @param contrasinal -> Contrasinal do usuario
     * @param user -> Tipo de usuario (Cliente ou Administrador)
    */
    public Usuario(String nomeUsuario, String contrasinal, TipoUsuario user) {
        this.setNomeUsuario(nomeUsuario);
        this.setContrasinal(contrasinal);
        this.setTipoUsuario(tipoUsuario);
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
        this.contrasinal = contrasinal;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Método que nos indica se as credenciais dun usuario son válidas
     * @param username -> nome de usuario
     * @param contrasinal -> contrainsal do usuario sen hahs
     * @return -> verdadeiro se as credenciais coinciden co usuario, falso en caso contrario
     */
    public boolean login(String username, String contrasinal) {
        String contrasinalHash = HashPasword.hashPassword(contrasinal);
        if (this.nomeUsuario.equals(username) && contrasinalHash.equals(this.contrasinal)) {
            return true;
        }
        return false;
    }
}
