package modelo.usuarios.administradores;


import utiles.enumerandos.TipoUsuario;

public class AdministradorBiblioteca extends Administrador {

    

    @Override
    public TipoUsuario getRol() {
        return TipoUsuario.ADMINISTRADOR_BIBLIOTECA;
    }
    
}
