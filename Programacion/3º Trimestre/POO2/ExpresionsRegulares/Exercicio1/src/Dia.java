import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dia {
    
    //Atributos
    private String dia;

    private static final Pattern regex = Pattern.compile("(\\d{1,2})/(\\d{1,2})/(\\d{2,4})");

    
    /**
     * Método constructor da clase Dia
     * 
     * Avaliamos o formato do día e, de non coincidir, capturamos unha excepción no propio constructor
     * 
     * @param dia -> Dia a utilizar
     * @throws ExcepcionDataInvalida -> Posible excepción a capturar
     */    
    public Dia(String dia) throws ExcepcionDataInvalida {
        if (!comprobarFormatoDia(dia)) {
            throw new ExcepcionDataInvalida("Data inválida!");
        } else{
            this.dia = cambiarFormato(dia);
        }        
    }

    /**
     * Método encargado de comprobar se o formato do día coincide co esperado
     * 
     * @param dia -> Dia a avaliar
     * @return -> Boolean dependendo de se é correcto ou non
     */
    public boolean comprobarFormatoDia(String dia){
        Matcher matcher = Dia.regex.matcher(dia);
        return matcher.matches();
    }

    /**
     * Método encargado de devolver a fecha no formato desexado
     * 
     * @param dia -> Dia a modificar
     * @return -> String co no novo formato
     */
    public String cambiarFormato(String dia){
        
        Matcher matcher = Dia.regex.matcher(dia);

        /**
         * Axudado por IA -> Preguntar a Manuel na clase
         * 
         * Para poder utilizar matcher.group(), preciso de utilizar primeiramente matcher.matches()
         * 
         * De non ser así, java lanzaría unha excepción
         */
        matcher.matches();

        String diaCompleto = matcher.group(1);
        String mesCompleto = matcher.group(2);
        String anoCompleto = matcher.group(3);

        if (diaCompleto.length() == 1) {
            diaCompleto = "0" + diaCompleto;
        }

        if (mesCompleto.length() == 1) {
            mesCompleto = "0" + mesCompleto;
        }

        if (anoCompleto.length() == 2) {
            anoCompleto = "19" + anoCompleto;
        }

        return diaCompleto+"/"+mesCompleto+"/"+anoCompleto;
    }

    @Override
    public String toString(){
        return this.cambiarFormato(dia);
    }
}
