package Utils;

public enum TipoUsuario {

    CLIENTE(1),
    ADMINISTRADOR(2);

    private final int usuario;

    private TipoUsuario(int usuario){
        this.usuario = usuario;
    }

    public int getTipoUsuario(){
        return usuario;
    }
}