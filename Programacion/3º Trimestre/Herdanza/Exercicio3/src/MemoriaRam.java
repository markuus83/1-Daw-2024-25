public class MemoriaRam extends Componhente{
    
    //Atributos
    private long memoriaBytes;
    private long velocidadeMemoriaHz;

    /**
     * 
     * @param memoriaBytes
     * @param velocidadeMemoriaHz
     * @param marca
     * @param modelo
     * @param prezo
     */
    public MemoriaRam(String marca, String modelo, double prezo, long memoriaBytes, long velocidadeMemoriaHz) {
        super(marca, modelo, prezo);

        this.memoriaBytes = memoriaBytes;
        this.velocidadeMemoriaHz = velocidadeMemoriaHz;
    }

    //Getters&Setters
    public long getMemoriaBytes() {
        return memoriaBytes;
    }
    public void setMemoriaBytes(long memoriaBytes) {
        this.memoriaBytes = memoriaBytes;
    }
    public long getVelocidadeMemoriaHz() {
        return velocidadeMemoriaHz;
    }
    public void setVelocidadeMemoriaHz(long velocidadeMemoriaHz) {
        this.velocidadeMemoriaHz = velocidadeMemoriaHz;
    }

    @Override
    public String toString() {
        return "Memoria Ram "+this.getMarca()+" "+this.getModelo()+": "+this.getPrezo()+"€ con ";
    }

    
}