package Menus;

import java.util.Scanner;

import Excepcions.UsuarioExistente;

public abstract class Menu {
    
    private final Scanner scanner;

    public Menu(){
        scanner = new Scanner(System.in);
    }

    protected abstract void mostrar() throws IllegalAccessException, UsuarioExistente;

    /**
     * Pide por teclado unha cadea de texto
     * @param frase que se mostra ao usuario
     * @return
     */
    protected String getString(String frase) {
        System.out.print(frase);
        String mensaxe = this.scanner.nextLine();
        return mensaxe;
    }

    /**
     * Pide por teclado un double
     * @param frase que se mostra ao usuario
     * @return
     */
    protected double getDouble(String frase) {
        System.out.print(frase);
        double mensaxe = this.scanner.nextDouble();
        return mensaxe;
    }

    /**
     * Pie por teclado unha frase
     * @param frase que se mostra ao usuario
     * @return
     */
    protected int getInt(String frase) {
        System.out.print(frase);
        int mensaxe = this.scanner.nextInt();
        this.scanner.nextLine(); // Limpiar buffer
        return mensaxe;
    }

    /**
     * Imprime unha frase por pantalla engadindo unha nova liña
     * @param frase
     */
    protected void printMessage(String frase) {
        System.out.println(frase);
    }
}