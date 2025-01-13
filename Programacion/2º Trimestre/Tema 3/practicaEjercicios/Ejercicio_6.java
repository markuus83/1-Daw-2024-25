/**
 * Pide un número por teclado entre 1 e 7. Indica o día da semana correspondente nesta orde: <luns>, <martes>, <mércores>, <xoves>, <venres>, <sábado> e <domingo>. Se o número introducido non está no rango, imprime: <Fora de rango>
 */

import java.util.Scanner;

public class Ejercicio_6 {
            
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entre 1 e 7: ");
        int numero = scanner.nextInt();

        switch (numero) {

            case 1:
                System.out.println("Luns");
                break;

            case 2:
                System.out.println("Martes");
                break;

            case 3:
                System.out.println("Miércoles");
                break;

            case 4:
                System.out.println("Jueves");
                break;

            case 5:
                System.out.println("Viernes");
                break;

            case 6:
                System.out.println("Sábado");
                break;

            case 7:
                System.out.println("Domingo");
                break;

            default:
                System.out.println("Fora de rango");
                break;
        
        }
        scanner.close();
    }
}
