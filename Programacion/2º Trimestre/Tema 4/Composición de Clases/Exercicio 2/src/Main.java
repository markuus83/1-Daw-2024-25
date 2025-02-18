/**
 *  · Crea un círculo con centro no punto (10,25)e cun radio de 5.
 * 
 *  · Imprime por pantalla o perímetro do círculo.
 * 
 *  · Imprime por pantalla a área do círculo.
 * 
 *  · Indica se o punto (12,11) está dentro do círculo.
 * 
 *  · Despraza o centro do círculo 5 unidades no eixo x e -10 no eixe y.
 * 
 *  · Indica se o punto (12,11) está dentro do círculo.
 */

public class Main {
    public static void main(String[] args) throws Exception {

        Circulo c = new Circulo(10, 25, 5);
        System.out.println("Perímetro: " + c.perimetro());
        System.out.println("Área: " + Math.PI * Math.pow(c.getRadio(), 2));
        System.out.println("¿Está dentro? " + c.ePuntoInterior(new Punto(12, 11)));
        c.desplazamiento(5, -10);
        System.out.println("¿Está dentro? " + c.ePuntoInterior(new Punto(12, 11)));

    }
}