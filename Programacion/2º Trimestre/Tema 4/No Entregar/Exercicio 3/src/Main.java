public class Main {
    public static void main(String[] args) throws Exception {

        Rectangulo rectangulo1 = new Rectangulo(3.0, 7.5);
        Rectangulo rectangulo2 = new Rectangulo(5.0, 10.0);

        System.out.println();

        System.out.println("O perímetro do primeiro rectángulo é: " + rectangulo1.perimetro() + "cm");
        System.out.println("O perímetro do segundo rectángulo é: " + rectangulo2.perimetro() + "cm");

        System.out.println();

        System.out.println("O área do primeiro rectángulo é: " + rectangulo1.area() + "cm cadrados");
        System.out.println("O área do segundo rectángulo é: " + rectangulo2.area() + "cm cadrados");
    }
}
