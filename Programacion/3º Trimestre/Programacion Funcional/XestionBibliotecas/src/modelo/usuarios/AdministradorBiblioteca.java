package modelo.usuarios;

import utiles.enumerandos.TipoUsuario;

public class AdministradorBiblioteca extends Usuario {

    //Atributos
    private int idBiblioteca;

    /**
     * 
     * @param contrasinal
     * @param nomeUsuario
     */
    public AdministradorBiblioteca(String contrasinal, String nomeUsuario, int idBiblioteca) {
        super(contrasinal, nomeUsuario);
        this.setIdBiblioteca(idBiblioteca);
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }
    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    @Override
    public TipoUsuario getRol() {
        return TipoUsuario.ADMINISTRADOR_BIBLIOTECA;
    }

}
