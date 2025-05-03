package modelo.usuarios.administradores;

import modelo.usuarios.Usuario;
import utiles.enumerandos.TipoUsuario;

public abstract class Administrador extends Usuario {
    
    
    

    @Override
    public abstract TipoUsuario getRol();
}
