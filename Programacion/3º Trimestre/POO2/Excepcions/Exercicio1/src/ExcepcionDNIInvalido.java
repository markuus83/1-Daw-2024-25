public class ExcepcionDNIInvalido extends Exception{
    
    public ExcepcionDNIInvalido(String mensaxe){
        super(mensaxe);
    }
    
    public static boolean comprobarDNI(String dni) {
        //Inicializamos as variables precisas
        String letrasNecesarias = "TRWAGMYFPDXBNJZSQVHLCKE";
        dni = dni.trim().toUpperCase();
    
        //Se o DNI non ten exactamente 9 caracteres devolvemos falso
        if (dni.length() != 9) {
            return false;
        }
    
        //Obtenemos os 8 primeros caracteres (números)
        String numerosDni = dni.substring(0, 8);
        
        //Comprobamos que os 8 primeros caracteres son números
        for (char c : numerosDni.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
    
        //Extraemos a letra (último carácter)
        char letraDni = dni.charAt(8);
        if (!Character.isLetter(letraDni)) {
            return false;
        }
    
        //Convertimos os números a enteiros
        int numero = Integer.parseInt(numerosDni);
    
        //Calculamos a letra correspondiente
        char letraCalculada = letrasNecesarias.charAt(numero % 23);
    
        //Comparamos la letra dada con la calculada
        return letraDni == letraCalculada;
    }
    
}
