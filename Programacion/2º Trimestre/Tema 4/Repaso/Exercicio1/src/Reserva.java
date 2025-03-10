import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reserva {

    //Atributos
    private LocalDateTime fechaReserva;
    private String cidade;
    private int numComensais;

    //Formato fecha
    static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    
}