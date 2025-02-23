public class Main {


    /**
     * Verifica se un número de tarxeta de 16 díxitos é válido segundo o Algoritmo de Luhn.
     * 
     * @param numero O número da tarxeta como cadea de caracteres (pode conter espazos).
     * @return true se o número é válido, false en caso contrario.
     */
    public static boolean comprobarNumero(String numero) {
        if (numero == null) {
            return false;
        }

        // Eliminar espazos en branco
        numero = numero.replace(" ", "");

        // Verificar que ten exactamente 16 díxitos
        if (numero.length() != 16) {
            return false;
        }

        int suma = 0;
        boolean alternar = false;
        
        for (int i = numero.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(numero.charAt(i));
            
            if (alternar) {
                digito *= 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }
            
            suma += digito;
            alternar = !alternar;
        }
        
        return (suma % 10 == 0);
    }
            

    public static void main(String[] args) {
        // Tarxetas para probar
        String[] tarxetas = {
            "4539 1488 0343 6467", // ✅ Válida
            "5256 7231 0295 6690", // ✅ Válida
            "4539 1488 0343 6468", // ❌ Inválida
            "1234 5678 9012 3456"  // ❌ Inválida
        };

        for (String tarxeta : tarxetas) {
            System.out.println("Tarxeta " + tarxeta + " → " + 
                (comprobarNumero(tarxeta) ? "VÁLIDA ✅" : "INVÁLIDA ❌"));
        }
    }

   
}