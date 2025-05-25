package modelo.usuarios;

import utils.clasesEstaticas.HashPasword;

public abstract class Usuario {
    
    //Atributos
    private String nomeU;
    private String contrasinalU;



    public String getNomeU() {
        return nomeU;
    }
    public void setNomeU(String nomeU) {
        this.nomeU = nomeU;
    }
    public String getContrasinalU() {
        return contrasinalU;
    }
    public void setContrasinalU(String contrasinalU) {
        this.contrasinalU = HashPasword.hashPassword(contrasinalU);
    }

    public abstract TipoUsuario getRol();
    
}
