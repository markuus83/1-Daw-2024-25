/**
 * O matemático indio Ramchandra kaprekar descubriu en 1949 unha curiosa característica do número 6174. Este número coñécese como constante de Kaprekar na súa honra.
 * 
 * Este número tena a seguinte propiedade:
 * 
 * 1. Elixe un número de catro díxitos que teña polo menos dous duferentes (é válido colocar o díxito 0 ao principio, polo que o número 00009 é válido).
 * 
 * 2. Coloca os seus díxitos en orde ascendente e en orde descendente para formar dous novos números. Podes engadir os díxitos 0 que necesites ao principio.
 * 
 * 3. Resta o menor ao maior
 * 
 * 4. Volve ao paso 2
 * 
 * Este proceso coñécese como a rutina Kaprekar, e sempre chegará ao número 6174 en coma moito 7 iteracións. Unha vez que o resultado da operación do paso 3 de ese número, o proceso parará.
 * 
 * Os únicos díxitos de catro cifras para os que a rutina non alcanza este número son os REPDIGITS, é dicir, aqueles nas que as súas catro cifras son iguais (como o 1111), pois na primera iteración o valor é 0 e xa non se pode saír del. Por iso, se pide no paso 1 explícitamente que o número inicial tivera polo menos dous díxitos diferentes.
 * 
 * Pídese un programa que reciba un número e indique o número de iteracións necesarias para calcular a constante de Kaprekar. Para os números REPDIGITS deberase indicar -1, e se se introducide a constante de Kaprekar deberase indicar o número 0.
 */

import java.util.Scanner;

/**
 * NO CAPTURAMOS ERROR CUANDO SE INTRODUCE UN NÚMERO DE MÁS DE 4 DÍGITOS 
 * 
 * ############# MODIFICAR CÓDIGO
 */


public class Exer1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Pedimos el número a iterar
        System.out.print("Introduce un número de 4 dígitos: ");
        int numero = scanner.nextInt();
        
        //Si ya es el número Kaprekar acabar el programa
        if (numero == 6174) {
            System.out.println("El número ya es la constante de Kaprekar. Iteraciones: 0");
            
        }

        //Almacenamos cada cifra en una variable
        int cifra1 = numero / 1000;
        int cifra2 = (numero / 100) % 10;
        int cifra3 = (numero / 10) % 10;
        int cifra4 = numero % 10;
        
        //Comprobamos si el número es un repdigit
        if (cifra1 == cifra2 && cifra2 == cifra3 && cifra3 == cifra4) {
            System.out.println("Repdigit. Iteraciones: -1");
        }

        int contador = 0;

        while (numero != 6174) {

            // Ordenar dígitos de forma ascendente y descendente
            int[] array = {cifra1, cifra2, cifra3, cifra4};

            
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length; j++) {

                    if (array[i] > array[j]) {

                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
            

            int arriba = array[0] * 1000 + array[1] * 100 + array[2] * 10 + array[3];
            int abajo = array[3] * 1000 + array[2] * 100 + array[1] * 10 + array[0];

            // Calcular la nueva resta
            numero = abajo - arriba;

            // Actualizar los dígitos
            cifra1 = numero / 1000;
            cifra2 = (numero / 100) % 10;
            cifra3 = (numero / 10) % 10;
            cifra4 = numero % 10;

            contador++;
        }

        System.out.println("Número de iteraciones necesarias: " + contador);
        
        scanner.close();
    }
}