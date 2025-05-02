import Enum.Zocalo;

public class PlacaBase extends Componhente {
    
    //Atributos
    private Zocalo zocalo;

  
    /**
     * 
     * @param marca
     * @param modelo
     * @param prezo
     * @param zocalo
     */
    public PlacaBase(String marca, String modelo, double prezo, Zocalo zocalo){

        super(marca, modelo, prezo);

        this.setZocalo(zocalo);
    }

    public Zocalo getZocalo() {
        return zocalo;
    }
    public void setZocalo(Zocalo zocalo) {
        this.zocalo = zocalo;
    }
    
    @Override
    public String toString(){
        return "Placa Base "+super.toString()+" con socket "+this.getZocalo();
    }
}
