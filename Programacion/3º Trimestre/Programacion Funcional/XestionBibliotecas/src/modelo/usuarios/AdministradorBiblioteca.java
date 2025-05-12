package modelo.usuarios;

import java.util.List;

import modelo.bibliotecas.Biblioteca;
import modelo.libros.Exemplar;
import utiles.enumerandos.TipoUsuario;

public class AdministradorBiblioteca extends Usuario {

    //Atributos
    private Biblioteca biblioteca;

    /**
     * 
     * @param contrasinal
     * @param nomeUsuario
     */
    public AdministradorBiblioteca(String contrasinal, String nomeUsuario, Biblioteca biblioteca) {
        super(contrasinal, nomeUsuario);
        this.setBiblioteca(biblioteca);
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public TipoUsuario getRol() {
        return TipoUsuario.ADMINISTRADOR_BIBLIOTECA;
    }


    public List<Exemplar> getExemplaresLibresBiblioteca(){
        return this.biblioteca.getExemplaresLibres();
    }
}
