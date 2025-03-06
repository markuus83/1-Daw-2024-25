import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa {
    
    // Atributos
    private String titulo;
    private String descricion;
    private LocalDateTime dataLimite;
    private LocalDateTime dataInicio;

    // Formato de fecha
    public static final DateTimeFormatter formato_data = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /**
     * Método constructor da clase Tarefa, onde pasamos como parámetros o título, a descrición e a data límite. A data de inicio será a data na que se crea a tarefa.
     * 
     * @param titulo -> String co título da tarefa
     * @param descricion -> String coa descrición da tarefa
     * @param dataLimite -> String coa data límite da tarefa
     */
    public Tarefa(String titulo, String descricion, String dataLimite) {
        this.setTitulo(titulo);
        this.setDescricion(descricion);
        this.dataLimite = converterDataString(dataLimite); 
        this.dataInicio = LocalDateTime.now();
    }

    //Getters&Setters
    public String getTitulo() {
        return titulo;
    }

    public String getDescricion() {
        return descricion;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataLimite() {
        return dataLimite;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    /**
     * Método que devolve a data límite da tarefa en formato de cadea.
     * 
     * @param data -> LocalDateTime coa data límite da tarefa
     * @return -> String coa data límite da tarefa
     */
    private LocalDateTime converterDataString(String data) {
        return LocalDateTime.parse(data, formato_data);
    }
}
