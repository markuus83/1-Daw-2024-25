public class Main {
    public static void main(String[] args) {

        Reloxo reloxo1 = new Reloxo("Casio", "C-300", 100.0, "digital");
        Reloxo reloxo2 = new Reloxo("Rolex", "R-503", 500.0, "analogico");

        System.out.println("\nReloxo 1:");
        System.out.println(reloxo1.getMarca() + " " + reloxo1.getModelo() + " " + reloxo1.getPrezo() + " " + reloxo1.getTipoReloxo());

        System.out.println("\nReloxo 2:");
        System.out.println(reloxo2.getMarca() + " " + reloxo2.getModelo() + " " + reloxo2.getPrezo() + " " + reloxo2.getTipoReloxo());
    }
}