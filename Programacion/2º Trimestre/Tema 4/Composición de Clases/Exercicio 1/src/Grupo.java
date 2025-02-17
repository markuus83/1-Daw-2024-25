import java.time.LocalDate;
import java.time.Period;

public class Grupo {

    //ATRIBUTOS
    private String nome;
    private String pais;
    private LocalDate anoCreacion;


    /**
     * Constructor da clase Grupo, onde pasamos todos os atributos como parámetros
     * 
     * @param nome -> Nome do grupo
     * @param pais -> País do grupo
     * @param anoCreacion -> Ano de creación do grupo
     */
    public Grupo(String nome, String pais, LocalDate anoCreacion) {
        this.nome = nome;
        this.pais = pais;
        this.anoCreacion = anoCreacion;
    }

    //GETTERS & SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getAnoCreacion() {
        return anoCreacion;
    }

    public void setAnoCreacion(LocalDate anoCreacion) {
        this.anoCreacion = anoCreacion;
    }

    public Integer getIdade(){

        LocalDate ahora = LocalDate.now();
        Period diferenza = Period.between(anoCreacion, ahora);

        return diferenza.getYears();
    }

}