public class Monitor extends Periferico{
    
    //Atributos
    private double pulgadas;

    public Monitor(String marca, String modelo, double prezo, double pulgadas) {
        super(marca, modelo, prezo);
        
        this.setPulgadas(pulgadas);
    }

    //Getters&Setters
    public double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString(){
        return "Monitor "+ super.toString()+" con "+this.getPulgadas() + " e conectores: "+ this.getConectoresString();
    }

}