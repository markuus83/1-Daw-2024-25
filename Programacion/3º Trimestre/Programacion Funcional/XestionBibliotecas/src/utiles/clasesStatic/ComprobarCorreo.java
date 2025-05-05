package utiles.clasesStatic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComprobarCorreo {
    
    private static final Pattern regex = Pattern.compile("([^@]+)@([^@]+\\.[a-zA-Z]{2,})");

    /**
     * Método encargado de comprobar se un correo é correcto ou non
     */
    public static boolean comprobarCorreo(String email){
        Matcher matcher = regex.matcher(email); 
        return matcher.matches();
    }

}
