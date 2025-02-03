public class Portatil {
    
    private String modelo;
    private String numSerie;
    private Cor corPortatil;

    public Portatil(String modelo, String numSerie, Cor corPortatil) {
        this.modelo = modelo;
        this.numSerie = numSerie;
        this.corPortatil = corPortatil;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public Cor getCorPortatil() {
        return corPortatil;
    }

    public void setCorPortatil(Cor corPortatil) {
        this.corPortatil = corPortatil;
    }    

}
