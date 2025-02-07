public enum Cor {

    Negro(1),
    Branco(2),
    Azul(3),
    Vermello(4),
    Verde(5);

    private final int cores;

    private Cor(int cores){
        this.cores=cores;
    }

    public int getNomeCor() {
        return cores;
    }

}