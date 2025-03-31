public class Rectangulo implements Figura {

    //Atributos
    private double largo;
    private double alto;


    /**
     * Método constructor da clase Rectangulo
     Largo do rectángulo
     * @param largo -> Largo do rectángulo
     * @param alto -> Alto do rectángulo
     */
    public Rectangulo(double largo, double alto) {
        this.setLargo(largo);
        this.setAlto(alto);
    }


    //Getters&Setters    
    public double getLargo() {
        return largo;
    }
    public void setLargo(double largo) {
        this.largo = largo;
    }
    public double getAlto() {
        return alto;
    }
    public void setAlto(double alto) {
        this.alto = alto;
    }



    @Override
    public double calcularArea() {
        return this.alto * this.largo;
    }
    
}