import java.time.LocalDate;

public class Reserva {
    
    //Atributos
    private String nomeTitular;
    private LocalDate dia;
    private int numComensais;
    

    /**
     * Constructor da clase Reserva, onde pasamos como parámetros o nome do reservante, o día e o número de comensais.
     * 
     * @param nomeTitular -> 
     * @param dia -> 
     * @param numComensais -> 
     */
    public Reserva(String nomeTitular, LocalDate dia, int numComensais) {
        this.nomeTitular = nomeTitular;
        this.dia = dia;
        this.numComensais = numComensais;
    }

    //Getters
    public String getNomeTitular() {
        return nomeTitular;
    }
    public LocalDate getDia() {
        return dia;
    }
    public int getNumComensais() {
        return numComensais;
    }
}
