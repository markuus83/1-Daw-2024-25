public class Tablero {
    private int[][] tablero;
    
    public Tablero() {
        tablero = new int[3][3];
    }
    
    public void mostrarTablero() {
        System.out.println("\nC1\tC2\tC3");
        for (int fila = 0; fila < 3; fila++) {
            System.out.print("F" + fila + "\t");
            for (int columna = 0; columna < 3; columna++) {
                if (tablero[fila][columna] == 0) {
                    System.out.print("-\t");
                } else if (tablero[fila][columna] == 1) {
                    System.out.print("X\t");
                } else {
                    System.out.print("O\t");
                }
            }
            System.out.println();
        }
    }
    
    public boolean realizarMovimiento(int fila, int columna, int jugador) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3 || tablero[fila][columna] != 0) {
            return false;
        }
        tablero[fila][columna] = jugador;
        return true;
    }
    
    public boolean hayGanador(int jugador) {
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) ||
                (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)) {
                return true;
            }
        }
        if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) ||
            (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)) {
            return true;
        }
        return false;
    }
    
    public boolean estaCompleto() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
