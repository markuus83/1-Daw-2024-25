public class MemoriaRam extends Componhente {
    private long memoriaBytes;
    private long velocidadeMemoriaHz;

    public MemoriaRam(String marca, String modelo, double prezo, double velocidadeMemoriaGz, double memoriaGB){
        super(marca, modelo, prezo);
        this.memoriaBytes = Componhente.gigaBytesToBytes(memoriaGB);
        this.velocidadeMemoriaHz = Componhente.gigaHzToHz(velocidadeMemoriaGz);
    }

    public double getMemoriaGB(){
        return Componhente.bytesToGigaBytes(memoriaBytes);
    }

    public double getMemoriaMHz(){
        return Componhente.hzToMhz(velocidadeMemoriaHz);
    }

    @Override
    public String toString() {
        return "Memoria RAM " + super.toString() + " con " + this.getMemoriaGB() + " GB e velocidade " + this.getMemoriaMHz()+" MHz";
    }

}

