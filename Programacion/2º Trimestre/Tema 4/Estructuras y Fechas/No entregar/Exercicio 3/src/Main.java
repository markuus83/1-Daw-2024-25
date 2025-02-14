/**
 * Fai un programa en Java utilizando ArrayList para almacenar nomes de persoas. Fai un menú coas seguintes operacións:
 * 
 *  1. Enfadir nome: egadirase o nome que se introduza por teclado
 *  2. Mostrar nomes: mostrarase unha lista de nomes
 *  3. Eliminar nome: mostrarase un menú con tódolos nomes e seleccionarase o que se desexa eliminar
 * 
 *  4.º Saír do programa: cerrarase o programa
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        ArrayList <String> persoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nIngrese a opción desexada: ");
            System.out.println("\t1. Engadir nome");
            System.out.println("\t2. Mostrar nomes");
            System.out.println("\t3. Eliminar nome");
            System.out.println("\t4. Sair do programa");

            int option = scanner.nextInt();
            scanner.nextLine();

            //Engadir Nome
            if (option == 1) {
                System.out.print("\nIntroduce o nome: ");
                String nome = scanner.nextLine();

                persoas.add(nome);
                

            //Mostrar nomes
            } else if (option == 2) {
                System.out.println();
                if (persoas.size() == 0) {
                    System.out.println("Erro: ArrayList vacío.");
                } else{
                    for (String nome : persoas) {
                        System.out.println(nome);
                    }
                }
                
            
            //Eliminar nome
            } else if (option == 3) {
                System.out.println();
                for (String nome : persoas) {
                    System.out.println(persoas.indexOf(nome)+ " - " + nome);
                }

                System.out.print("Introduce o índice a eliminar: ");
                int indice = scanner.nextInt();

                
                if (indice >= 0 && indice < persoas.size()) {
                    persoas.remove(indice);
                    System.out.println("\nNome eliminado.");
                }
            

            //Sair
            } else if (option == 4) {
                System.out.println("Saindo do programa...");
                break;

            } else {
                System.out.println("Erro. Opción non válida");
            }
        }
        scanner.close();
    }
}
