import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reserva {

    //Atributos
    private LocalDateTime fechaReserva;
    private String cidade;
    private int numComensais;
    

    //Formato fecha
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    //Getters&Setters
    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }
    public boolean setFechaReserva(LocalDateTime fechaReserva) {

        LocalDateTime horaActual = LocalDateTime.now();

        if (!fechaReserva.isBefore(horaActual)) {
            this.fechaReserva = fechaReserva;
        }

        this.fechaReserva = horaActual.set
        
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public int getNumComensais() {
        return numComensais;
    }

    /**
     * 
     * @param numComensais
     */
    public void setNumComensais(int numComensais) {

        if (numComensais >= 1) {
            this.numComensais=numComensais;
        } 
        //Unha reserva poderá ter como mínimo un comensal
        this.numComensais = 1;
    }


    
}