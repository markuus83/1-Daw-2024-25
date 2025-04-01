import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Deportista implements Comparable<Deportista>{

    //Atributos
    private String nomeCompleto;
    private String nomeDeportivo;
    private LocalDate dataNacemento;

    /**
     * Constructor de deportista
     * 
     * @param nomeCompleto do deportista
     * @param nomeDeportivo do deportista
     * @param dataNacemento no formato dd/MM/yyyy
     */
    public Deportista(String nomeCompleto, String nomeDeportivo, String dataNacemento) {
        this.setNomeCompleto(nomeCompleto);
        this.setNomeDeportivo(nomeDeportivo);
        this.setDataNacemento(dataNacemento);
    }

    //Getters&Setters
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeDeportivo() {
        return nomeDeportivo;
    }

    public void setNomeDeportivo(String nomeDeportivo) {
        this.nomeDeportivo = nomeDeportivo;
    }

    public LocalDate getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(String dataNacemento) {
        DateTimeFormatter formatoPersonalizado = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataNacemento = LocalDate.parse(dataNacemento, formatoPersonalizado);
    }

    /**
     * Devolve a idade do deportista
     * @return a idade do deportista
     */
    public int getIdade(){
        Period intervalo = Period.between(this.dataNacemento, LocalDate.now());
        return intervalo.getYears();
    }

    @Override
    public int compareTo(Deportista d){
        return this.getDataNacemento().compareTo(d.getDataNacemento());
    }

    @Override
    public String toString(){
        return this.nomeDeportivo + " : " + this.getIdade() + " anos.";
    }

}