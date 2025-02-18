/**
 * Crea a clase Punto coas seguintes características.
 * 
 *  · Debes almacenar as coordenadas x e y.
 * 
 *  · Crea os getters. Non imos crear setters.
 * 
 *  · Crea unha construtor para inicializar tódolos atributos que se pasan por parámetros.
 * 
 *  · Crea o método void desprazamentoHorizontal(double desprazamento) que modifica a coordenada x.
 * 
 *  · Crea o método void desprazamentoVertical(double desprazamento) que modifica a coordenada y.
 * 
 * · Crea o método double distancia(Punto p) que calcule a distancia ao punto que se pasa por parámetro.
 * 
 *  · Crea o método String getPosición() que devolve a posición no seguinte formato (x,y).
 * 
 *  · Documenta os métodos.
 * 
 */
public class Punto {

    private double x;
    private double y;

    /**
     * Constructor de la clase Punto
     * 
     * @param x coordenada x
     * @param y coordenada y
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Método que devuelve la coordenada x
     * 
     * @return coordenada x
     */
    public double getX() {
        return x;
    }

    /**
     * Método que devuelve la coordenada y
     * 
     * @return coordenada y
     */
    public double getY() {
        return y;
    }

    /**
     * Método que modifica la coordenada x
     * 
     * @param desplazamiento cantidad a desplazar
     */
    public void desplazamientoHorizontal(double desplazamiento) {
        this.x += desplazamiento;
    }

    /**
     * Método que modifica la coordenada y
     * 
     * @param desplazamiento cantidad a desplazar
     */
    public void desplazamientoVertical(double desplazamiento) {
        this.y += desplazamiento;
    }

    /**
     * Método que calcula la distancia entre dos puntos
     * 
     * @param p punto al que calcular la dista ncia
     * @return distancia entre los dos puntos
     */
    public double distancia(Punto p) {

        double distanciaVertical = this.y - p.getY();
        double distanciaHorizontal = this.x - p.getX();

        double aux = Math.pow(distanciaVertical, 2) + Math.pow(distanciaHorizontal, 2);

        return Math.sqrt(aux); 

    }

    /**
     * Método que devuelve la posición del punto
     * 
     * @return posición del punto
     */
    public String getPosicion() {
        return "(" + x + "," + y + ")";
    }
}