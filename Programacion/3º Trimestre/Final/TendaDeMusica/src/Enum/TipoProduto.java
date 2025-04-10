package Enum;

public enum TipoProduto {
    FRAUTA(1),
    SAXOFON(2),
    TROMBON(3),
    LIBRO(4),
    ESTOXO(5);

    private final int produto;

    private TipoProduto(int produto){
        this.produto = produto;
    }

    public int getTipoUsuario(){
        return produto;
    }
}
