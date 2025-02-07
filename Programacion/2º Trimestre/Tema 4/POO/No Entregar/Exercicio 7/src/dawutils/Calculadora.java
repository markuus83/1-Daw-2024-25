package dawutils;

public class Calculadora {

    private static double ultimaOperacion;
    
    public static void sumar(double a, double b){
        ultimaOperacion = a + b;
    }

    public static double multiplicar(double a, double b){
        ultimaOperacion = a*b;
        return ultimaOperacion ;
    }

    public static double potencia(int base, int exponente) {

        int resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        
        ultimaOperacion = resultado;
        return resultado;
    }

    public static double obterUltimoResultado() {
        return ultimaOperacion;
    }

}