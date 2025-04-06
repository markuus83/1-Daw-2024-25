import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    
    //Atributos
    private String email;

    private final Pattern regex = Pattern.compile("([^@]+)@([^@]+\\.[a-zA-Z]{2,})");
    

    /**
     * Método constructor da clase Email, onde recibe como parámetros todos os seus atributos
     * 
     * @param email -> Email 
     * @throws EmailInvalidoException -> Posible excepción a capturar
     */
    public Email(String email) throws EmailInvalidoException {
        this.setEmail(email);
    }

    //Setter
    public void setEmail(String email) throws EmailInvalidoException {
        if (this.comprobarEmail(email)) {
            this.email = email;
        } else {
            throw new EmailInvalidoException(this.getMessageError(email));
        }
    }

    /**
     * Método encargado de comprobar se o formato dun email é correcto
     * 
     * @param email -> Email a comprobar
     * @return -> Boolean
     */
    public boolean comprobarEmail(String email) {
        Matcher matcher = regex.matcher(email); 
        return matcher.matches();
    }


    /**
     * Método encargado de devolver nunha cadea de texto o Dominio do email
     * 
     * @return -> String co dominio do email
     */
    public String getDominio(){
        Matcher matcher = regex.matcher(email); 

        //Obrigatorio de poñer para poder realizar matcher.group()
        matcher.matches();
        return matcher.group(2);
    }

    /**
     * Método encarfado de devolver nunha cadea de texto a Conta do email
     * 
     * @return -> String ca conta do email
     */
    public String getConta(){
        Matcher matcher = regex.matcher(email); 

        //Obrigatorio de poñer para poder realizar matcher.group()
        matcher.matches();
        return matcher.group(1);
    }

    /**
     * Método encargado de xerar unha mensaxe de erro indicando nunha cadea que un correo non é válido
     *
     * @param email -> Cadea a devolver
     * @return -> String
     */
    public String getMessageError(String email) {
        return "Esta cadea non é un correo: " + email;
    }
}