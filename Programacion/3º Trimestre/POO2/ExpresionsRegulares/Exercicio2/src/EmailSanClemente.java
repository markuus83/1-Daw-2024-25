import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSanClemente extends Email{
    
    /**
     * Método constructor da clase EmailSanClemente
     * 
     * @param email -> Email 
     * @throws EmailInvalidoException -> Posible excepción a capturar
     */
    public EmailSanClemente(String email) throws EmailInvalidoException {
        super(email);
    }
    
    @Override
    public boolean comprobarEmail(String email) {
        
        Pattern regexSanClemente = Pattern.compile("([^@]+)@(iessanclemente\\.net)");
        Matcher matcher = regexSanClemente.matcher(email);
        return matcher.matches();
    }

    @Override
    public String getMessageError(String email){
        return "Esta cadea non é un correo San Clemente: "+ email;
    }
}
