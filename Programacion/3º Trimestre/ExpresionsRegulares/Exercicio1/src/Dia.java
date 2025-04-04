import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dia {
    
    //Atributos
    private String dia;

    private static Pattern regex = Pattern.compile("(\\d{1,2})/(\\d{1,2})/(\\d{2,4})");

    
    /**
     * Método encargado de avaliar se un formato de data é correcto ou non
     * 
     * @param dia -> Dia a avaliar
     * @return -> Boolean
     */
    public boolean comprobarFormatoDia(String dia){

        Matcher matcher = Dia.regex.matcher(dia);

        return matcher.matches();
    }

    
    /**
     * Método encargado de cambiar o formato de data
     * 
     * @param dia -> Dia a cambiar
     * @return -> String con formato dd/MM/yyyy
     */
    public String cambiarFormato(String dia) throws ExcepcionDataInvalida{
    
        Matcher matcher = Dia.regex.matcher(dia);

        if (matcher.matches()) {

            String diaCompleto = matcher.group(1);
            String mesCompleto = matcher.group(2);
            String anoCompleto = matcher.group(3);

            if (anoCompleto.length() == 2) {
                anoCompleto = "19" + anoCompleto;
            }

            return String.format("%02d/%02d/%s", Integer.parseInt(diaCompleto), Integer.parseInt(mesCompleto), anoCompleto);
        
        } else{
            throw new ExcepcionDataInvalida("Data inválida!");
        }
    }
}