public class Habitacion {
    
    //Atributos
    private TipoHabitacion tipoHabitacion;
    private Hotel hotelPertence;
    private int idHabitacion=0;
    private double prezoNoite;
    
    /**
     * Método constructor da clase Habitacion
     * 
     * @param tipoHabitacion -> Tipo de habitación (Enum)
     * @param hotelPertence -> Hotel ao cal pertence a Habitacion
     * @param idHabitacion -> Id da Habitacion
     * @param prezoNoite -> Prezo por noite
     */
    public Habitacion(TipoHabitacion tipoHabitacion, Hotel hotelPertence, double prezoNoite) {
        this.setTipoHabitacion(tipoHabitacion);
        this.setHotelPertence(hotelPertence);
        this.setPrezoNoite(prezoNoite);
        this.idHabitacion++;
    }

    //Getters&Setters
    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public Hotel getHotelPertence() {
        return hotelPertence;
    }
    public void setHotelPertence(Hotel hotelPertence) {
        this.hotelPertence = hotelPertence;
    }
    public double getPrezoNoite() {
        return prezoNoite;
    }
    public void setPrezoNoite(double prezoNoite) {
        this.prezoNoite = prezoNoite;
    }
    public int getIdHabitacion(){
        return idHabitacion;
    }
}
