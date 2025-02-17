import java.time.LocalDate;

public class Disco{
    
    //ATRIBUTOS
    private String titulo;
    private LocalDate anoLanzamento;
    private Integer numCancions;
    private Grupo grupo;

    
    /**
     * Constructor da clase Disco, onde pasamos todos os atributos como parámetros
     * 
     * @param titulo -> Titulo do Discio
     * @param grupo -> Nome do grupo
     * @param anoLanzamento -> Ano de lanzamento
     * @param numCancions -> Numero de cancións
     */
    public Disco(String titulo, Grupo grupo, LocalDate anoLanzamento, Integer numCancions) {
        this.titulo = titulo;
        this.grupo = grupo;
        this.anoLanzamento = anoLanzamento;
        this.numCancions = numCancions;
    }

    //GETTERS & SETTERS
    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public Grupo getGrupo() {
        return grupo;
    }


    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }


    public LocalDate getAnoLanzamento() {
        return anoLanzamento;
    }


    public void setAnoLanzamento(LocalDate anoLanzamento) {
        this.anoLanzamento = anoLanzamento;
    }


    public Integer getNumCancions() {
        return numCancions;
    }


    public void setNumCancions(Integer numCancions) {
        this.numCancions = numCancions;
    }

    //Crea un método que indique cantos anos de existenza tiña o grupo cando se lanzou o disco
    public Integer anosExistenza(){
        return this.anoLanzamento.getYear() - this.grupo.getAnoCreacion().getYear();
    }

}