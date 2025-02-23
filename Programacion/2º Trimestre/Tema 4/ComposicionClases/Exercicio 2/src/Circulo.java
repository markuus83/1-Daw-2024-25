/**
 * Crea a clase Circulo coas seguintes características.
 * 
 * · Como atributos almacena o seu centro (que é un obxecto da clase Punto e o seu radio).
 * 
 * · Crea getters e setters necesarios
 * 
 * · Crea un constructor para inicializar os atributos nos que se pasan como parámetros as coordenadas x e y do centro, e o seu radio.
 * 
 * · Documenta os constructores.
 * 
 * · Crea un método que calcule o perímetro do círculo.
 * 
 *  · Crea o método void desprazamento(int x, int y) que desprace o centro do círculo
 * 
 *  · Crea o método boolean ePuntoInterior(Punto punto) que indique se o punto que se recibe por parámetro está dentro do círculo.
 * 
 *  · Documenta os métodos.
 */


public class Circulo {

    private Punto centro;
    private double radio;


    public Circulo(double x, double y, double radio) {
        this.centro = new Punto(x, y);
        this.radio = radio;
    }

    
    

}