package utiles.clasesStatic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComprobarCorreo {
    
    private static final Pattern regex = Pattern.compile("([^@]+)@([^@]+\\.[a-zA-Z]{2,})");

    public static boolean comprobarCorreo(String email){
        Matcher matcher = regex.matcher(email); 
        return matcher.matches();
    }

}
