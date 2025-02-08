import java.util.Scanner;

public class Juego {
    
    private Tablero tablero;
    private int jugadorActual;
    private Scanner scanner;
    
    public Juego() {
        tablero = new Tablero();
        jugadorActual = 1;
        scanner = new Scanner(System.in);
    }
    
    public void jugar() {
        boolean ganador = false;
        boolean empate = false;
        
        while (!ganador && !empate) {
            tablero.mostrarTablero();
            System.out.print("\nTurno del jugador " + jugadorActual + ". Ingrese fila y columna: ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();
            
            if (!tablero.realizarMovimiento(fila, columna, jugadorActual)) {
                System.out.println("Movimiento inválido. Inténtelo de nuevo.");
                continue;
            }
            
            ganador = tablero.hayGanador(jugadorActual);
            empate = tablero.estaCompleto() && !ganador;
            
            if (!ganador && !empate) {
                jugadorActual = (jugadorActual == 1) ? 2 : 1;
            }
        }
        
        tablero.mostrarTablero();
        if (ganador) {
            System.out.println("\n¡El jugador " + jugadorActual + " ha ganado!");
        } else {
            System.out.println("\n¡Empate!");
        }
        scanner.close();
    }
}
