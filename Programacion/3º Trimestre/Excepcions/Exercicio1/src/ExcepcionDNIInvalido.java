public class ExcepcionDNIInvalido extends Exception{
    
    /**
     * Método constructor da clase ExcepcionDNIInvalido
     * 
     * @param mensaxe -> Mensaxe de erro
     */
    public ExcepcionDNIInvalido(String mensaxe){
        super(mensaxe);
    }

    /**
     * Método para comprobar se o DNI é válido
     * 
     * @param dni -> DNI a comprobar
     * @return true se o DNI é válido, false se non
     */
    public static boolean comprobarDNI(String dni) {

        //Conjunto de letras utilizadas en la validación del DNI
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        
        //Eliminamos espacios en blanco y convertimos a mayúsculas
        dni = dni.trim().toUpperCase();
        
        //Verificamos que la longitud sea exactamente de 9 caracteres
        if (dni.length() != 9) {
            return false;
        }
        
        //Extraemos los primeros 8 caracteres (números) y la última letra
        String numeroStr = dni.substring(0, 8);
        char letra = dni.charAt(8);
        
        //Verificamos que los primeros 8 caracteres sean dígitos sin usar matches
        for (char c : numeroStr.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        
        //Verificamos que el último carácter sea una letra
        if (!Character.isLetter(letra)) {
            return false;
        }
        
        //Convertimos el número a entero y calculamos la letra correspondiente
        int numero = Integer.parseInt(numeroStr);
        char letraCalculada = letras.charAt(numero % 23);
        
        //Comparamos la letra calculada con la proporcionada en el DNI
        return letra == letraCalculada;
    }
}