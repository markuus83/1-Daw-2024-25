import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Figura> figuras = new ArrayList<>();

        figuras.add(new Rectangulo(5, 6));
        figuras.add(new Circulo(7));

        for (Figura figura : figuras) {
            System.out.println(figura.calcularArea());
        }
    }
}