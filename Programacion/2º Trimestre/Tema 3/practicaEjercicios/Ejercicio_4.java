/**
 * Pide por pantalla unha cantidade de tempo en segundo. Imprime por pantalla as súas correspondentes horas, minutos e segundos do valor introducido nesta orde e cada un nunha liña.
 * 
 * ||NOTA: Utiliza println para imprimir os resultados||
 */

import java.util.Scanner;

public class Ejercicio_4 {
            
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese a cantidade de tempo en segundos: ");
        long tempoTotal = scanner.nextLong(); 

        long horas = tempoTotal / 3600; 
        long minutos = (tempoTotal % 3600) / 60;
        long segundos = tempoTotal % 60; 

        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);

        scanner.close();
    }
}
 