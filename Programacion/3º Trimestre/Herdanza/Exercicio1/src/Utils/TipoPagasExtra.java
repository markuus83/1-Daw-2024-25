package Utils;

public enum TipoPagasExtra {
    
    normal(14),
    prorrateada(12);

    private final int pagas;

    private TipoPagasExtra(int pagas){
        this.pagas=pagas;
    }

    public int getTipoPagasExtra(){
        return pagas;
    }

    /**
     * Método encargado de asignar un valor numérico a un enumerando-
     * 
     * @param valor -> Valor de enteiro
     * @return -> Tipo de paga 
     */
    public static TipoPagasExtra valor(int valor){

        //Recorremos 
        for (TipoPagasExtra tipo : TipoPagasExtra.values()) {
            if (tipo.getTipoPagasExtra() == valor) {
                return tipo;
            }
        }
        return null;
    }
}


