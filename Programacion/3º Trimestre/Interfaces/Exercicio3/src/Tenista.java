public class Tenista extends Deportista{
    private Integer ranking;

    /**
     * Construtor de tenista
     * @param nomeCompleto do tenista
     * @param nomeDeportivo do tenista
     * @param dataNacemento do tenista no formato dd/MM/yyyy
     * @param ranking mundial do tenista
     */
    public Tenista(String nomeCompleto, String nomeDeportivo, String dataNacemento, Integer ranking) {
        super(nomeCompleto, nomeDeportivo, dataNacemento);
        this.setRanking(ranking);
    }

    @Override
    public String toString(){
        return super.toString() + " Nº " + this.ranking + " do mundo.";
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
 
}