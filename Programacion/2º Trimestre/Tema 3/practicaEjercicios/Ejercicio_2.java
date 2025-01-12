/**
 * Pide por pantalla a idade dunha persoa e mostra por pantalla o ano que naceu. Considera o ano actual 2025.
 */

import java.util.Scanner;

public class Ejercicio_2 {
    
    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.print("Introduce a túa idade: ");
    	int idade = scanner.nextInt();
    	
    	int anoNacemento = 2025 - idade; 

    	System.out.println("O teu ano de nacemento é: " + anoNacemento);
    	
    	scanner.close();
    }

}
