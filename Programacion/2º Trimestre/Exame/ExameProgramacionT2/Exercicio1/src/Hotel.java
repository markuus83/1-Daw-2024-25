import java.util.ArrayList;

public class Hotel {
    
    //Atributos
    private String nomeHotel;
    private ArrayList<Habitacion> habitacions;

    
    /**
     * Método Constructor da clase Hotel, onde pasamos como parámetro o nome do Hotel
     * 
     * @param nomeHotel -> Nome do hotel
     */
    public Hotel(String nomeHotel) {
        this.setNomeHotel(nomeHotel);
        this.habitacions = new ArrayList<Habitacion>();
    }

    //Getters&Setters
    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setNomeHotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }

    public ArrayList<Habitacion> getHabitacions() {
        return habitacions;
    }

    /**
     * Método encargado de engadir unha habitación a un hotel
     * 
     * @param habitacion -> Habitación a engadir nun hotel
     */
    public void engadirHabitacion(Habitacion habitacion){
        this.habitacions.add(habitacion);
    }

}
