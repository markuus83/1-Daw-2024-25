package Utiles;

public class ComprobarISBN10 {
    
    public static boolean comprobarISBN10(String isbn) {
        
        if (isbn == null || isbn.length() != 10) {
            return false;
        }

        int suma = 0;

        for (int i = 0; i < 10; i++) {
            char c = isbn.charAt(i);
            int valor;

            // El último carácter puede ser 'X' (representando el número 10)
            if (i == 9 && (c == 'X' || c == 'x')) {
                valor = 10;
            } else if (Character.isDigit(c)) {
                valor = Character.getNumericValue(c);
            } else {
                return false; // carácter inválido
            }

            suma += valor * (10 - i);
        }

        return suma % 11 == 0;
    }

}
