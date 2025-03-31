public class Circulo implements Figura {
    
    //Atributos
    private double radio;

    /**
     * Método constructor da clase Circulo
     * 
     * @param radio -> Radio do circulo
     */
    public Circulo(double radio) {
        this.setRadio(radio);
    }

    //Getters&Setters
    public double getRadio() {
        return radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
    
}