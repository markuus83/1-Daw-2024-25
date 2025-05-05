public class ComprobarISBN13 {

    public static boolean comprobarISBN13(String isbn) {

        if (isbn == null || isbn.length() != 13) {
            return false;
        }

        int suma = 0;

        for (int i = 0; i < 13; i++) {
            char c = isbn.charAt(i);

            if (!Character.isDigit(c)) {
                return false; // carácter inválido
            }

            int valor = Character.getNumericValue(c);

            // Alterna multiplicadores 1 y 3
            if (i % 2 == 0) {
                suma += valor;
            } else {
                suma += valor * 3;
            }
        }

        return suma % 10 == 0;
    }

}
