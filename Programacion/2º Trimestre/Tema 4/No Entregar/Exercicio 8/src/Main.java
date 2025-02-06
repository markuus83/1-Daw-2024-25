public class Main {
    public static void main(String[] args) throws Exception {

        Cadrado cadrado1 = new Cadrado(9.3, MedidaDistancia.km);
        Cadrado cadrado2 = new Cadrado(1.5, MedidaDistancia.m);

        System.out.println();

        System.out.println(cadrado1.perimetroCadrado(MedidaDistancia.dm) + " decímetros.");
        System.out.println(cadrado2.perimetroCadrado(MedidaDistancia.dm) + " decímetros.");

        System.out.println();

        System.out.println(cadrado1.areaCadrado(MedidaDistancia.cm) + " cm cadrados.");
        System.out.println(cadrado2.areaCadrado(MedidaDistancia.cm) + " cm cadrados.");
    }
}