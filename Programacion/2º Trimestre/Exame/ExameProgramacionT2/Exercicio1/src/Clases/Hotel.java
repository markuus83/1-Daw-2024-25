package Clases;
import java.util.ArrayList;

public class Hotel {
    
    //Atributos
    private String nomeHotel;
    private ArrayList<Habitacion> habitacions;
    
    //Constructor
    public Hotel(String nomeHotel) {
        this.setNomeHotel(nomeHotel);
        this.setHabitacions(new ArrayList<Habitacion>());
        
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
    public void setHabitacions(ArrayList<Habitacion> habitacions) {
        this.habitacions = habitacions;
    }


    
}
