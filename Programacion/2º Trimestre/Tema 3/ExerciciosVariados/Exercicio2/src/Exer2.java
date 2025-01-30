/**
 * O revisor dunha empresa turística de autobuses de dous pisos: debe revisar tódolos autobuses que salen da parada inicial ai longo do día e comunicar a central cantos turistas hai no piso superior e cantos no inferior.
 * 
 * O revisor, canso destas repetitivas mensaxes pensou nun método máis compacto para describir os turistar que hai en cada piso: en lugar de transmitir cantidades, transmite un número único (denominado rango) que resume perfectamente a ocupación do autobús. Para iso utiliza o seguinte esquema
 * 
 * Pide un programa que calcule dito rango. Primeiro indicarase os turistas do piso superior e a continuación os turistas do piso inferior.
 */

import java.util.Scanner;

public class Exer2 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de turistas en el piso superior: ");
        int turistasSuperior = scanner.nextInt();

        System.out.print("Introduce el número de turistas en el piso inferior: ");
        int turistasInferior = scanner.nextInt();

        //Matriz que almacena los rangos según el esquema de la imagen

        int[][] rangos = {
            {1, 2, 4},   //0 turistas en superior
            {3, 5, 7},   //1 turista en superior
            {6, 8, 9},   //2 turistas en superior
            {10, -1, -1} //Los -1 son valores no válidos
        };

        //Validar entrada dentro del rango permitido
        if (turistasSuperior >= 0 && turistasSuperior <= 3 && turistasInferior >= 0 && turistasInferior <= 2) {

            int rango = rangos[turistasSuperior][turistasInferior];
            System.out.println("El rango del autobús es: " + rango);

        } else {
            System.out.println("Número de turistas no válido.");
        }

        scanner.close();
    }
}
