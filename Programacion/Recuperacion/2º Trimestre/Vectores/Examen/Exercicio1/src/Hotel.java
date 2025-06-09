import java.util.ArrayList;

public class Hotel {
    
    //Atributos
    private String nome;
    private int idHotel=0;
    private ArrayList<Habitacion> habitacions;


    /**
     * Método constructor da clase Hotel
     * 
     * @param nome -> Nome do Hotel
     */
    public Hotel(String nome) {
        this.setNome(nome);
        habitacions = new ArrayList<>();
        idHotel++;
    }

    //Getters&Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdHotel(){
        return idHotel;
    }

    /**
     * Método encargado de engadir unha Habitacion a un Hotel
     */
    public void engadirHabitacion(Habitacion h){
        habitacions.add(h);
    }

    @Override
    public String toString(){
        int id = this.getIdHotel() -1;
        return id+" -> "+this.getNome();
    }
}
