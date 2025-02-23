
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Tarxeta {
    
    //Atributos
    private String numero;
    private LocalDate dataCaducidade;
    private String banco;
    private String descripcion;
    private static final DateTimeFormatter formatoDataCaducidade = DateTimeFormatter.ofPattern("MM/yyyy");






    /**
     * Verifica se un número de tarxeta de 16 díxitos é válido segundo o Algoritmo de Luhn.
     * 
     * @param numero -> O número da tarxeta como cadea de caracteres (pode conter espazos).
     * @return -> true se o número é válido, false en caso contrario.
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
        
        // Recorremos a cadea de números de dereita a esquerda 
        for (int i = numero.length() - 1; i >= 0; i--) {

            // Obtemos o díxito actual convertendo o carácter a número.
            int digito = Character.getNumericValue(numero.charAt(i));
            
            // Se o díxito é par, multiplicámolo por 2
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

}
