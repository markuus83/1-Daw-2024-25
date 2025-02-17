public class Punto {

    //ATRIBUTOS
    private double x;
    private double y;

    /**
     * 
     * @param x
     * @param y
     */
    public Punto(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    
    void desprazamentoHorizontal(double desprazamento){
        this.x += desprazamento;
    }

    void desprazamentoVertical(double desprazamento){
        this.y += desprazamento;
    }

    /**
     * Calculamos a distancia entre as distintas cordenadas
     * 
     * @param p
     * @return
     */
    double distancia (Punto punto){
        return this.x - this.y;
    }

    String getPosicion(){
        return "(" + this.x + "," + this.y + ")";
    }
}
