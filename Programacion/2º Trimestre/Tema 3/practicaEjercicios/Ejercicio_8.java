/**
 * Pide un número por consola. A continuación calcula o valor da raíz cadrada aproximada por abaixo dese número utilizando bucles. Por exemplo: a raíz cadrada de 33 sería 5, porque 5·5 = 25 e 6·6= 36. Imprime o valor da raíz cadrada por pantalla. Se o valor é menor que 1, escribe <Erro> por pantalla.
 */

import java.util.Scanner;


public class Ejercicio_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número para calcular se é primo ou non: ");
        int numero = scanner.nextInt();

        double raizAproximada = Math.pow(numero,1/2);

        System.out.println(raizAproximada);

        scanner.close();
    }
}
