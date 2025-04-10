package Users;

import Enum.TipoUsuario;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        String contrasinalHash = Usuario.hashPassword(contrasinal);
        if (this.nomeUsuario.equals(username) && contrasinalHash.equals(this.contrasinal)) {
            return true;
        }
        return false;
    }

    /**
     * Método encargado de avaliar o contrasinal dun usuario
     * 
     * @param password -> Constrasinal a avaliar
     * @return -> String co hash do contrasinal
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    
}