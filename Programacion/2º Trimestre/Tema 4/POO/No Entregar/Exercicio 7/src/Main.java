import dawutils.Calculadora;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Calculadora.sumar(6.0,7);
        System.out.println("El resultado de la suma es: " + Calculadora.obterUltimoResultado());
        
        Calculadora.multiplicar(3.7, 7.4);
        System.out.println("El resultado de la multiplicación es: " + Calculadora.obterUltimoResultado());

        System.out.println("El resultado de la potencia de 5⁶ es: " + Calculadora.potencia(5, 6));
    }
}