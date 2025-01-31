public class Rectangulo {
    
    private double base;
    private double altura;

    /**
     * Constructor que recibe todos como parámetros todos os atributos da clase
     * 
     * @param base
     * @param altura
     */
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    /**
     * Non pode haber unha base negativa
     * 
     * @return
     */
    public double getBase() {

        if (base > 0) {
            return base;
        } else{
            return 0;
        }
    }


    public void setBase(double base) {
        this.base = base;
    }

    
    /**
     * Non pode haber unha altura negativa
     * 
     * @return
     */
    public double getAltura() {

        if (altura > 0) {
            return altura;
        } else{
            return 0;
        }
    }


    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Devolve o perimetro do rectangulo
     * 
     * @return
     */
    public double perimetro(){
        double base2 = this.base + this.base;
        double altura2 = this.altura + this.altura;

        return base2 + altura2;
    } 

    /**
     * Devolve o área do rectángulo
     * 
     * @return
     */
    public double area(){
        return base * altura;
    }
    
}
