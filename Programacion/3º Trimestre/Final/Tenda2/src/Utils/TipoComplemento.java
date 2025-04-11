package Utils;

public enum TipoComplemento {

    LIBRO(1),
    ESTOXO(2);

    private final int complemento;

    private TipoComplemento(int complemento){
        this.complemento = complemento;
    }

    public int getTipoUsuario(){
        return complemento;
    }
}
