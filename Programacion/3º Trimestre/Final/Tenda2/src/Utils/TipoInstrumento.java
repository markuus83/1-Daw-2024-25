package Utils;

public enum TipoInstrumento {

    FRAUTA(1),
    SAXOFON(2),
    TROMBON(3);
    private final int intrumento;

    private TipoInstrumento(int intrumento){
        this.intrumento = intrumento;
    }

    public int getTipoUsuario(){
        return intrumento;
    }
}
