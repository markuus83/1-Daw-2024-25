public enum MedidaDistancia {
    cm(1),
    dm(2),
    m(3),
    km(4);

    private final int medidas;

    private MedidaDistancia(int medidas){
        this.medidas = medidas;
    }

    public int getTipoMetida(){
        return medidas;
    }
}