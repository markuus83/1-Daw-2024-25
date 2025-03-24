public class Habitacion {
    
    private String tipoHabitacion;
    private int idHabitacion;
    private double prezo;


    /**
     * Método constructor da clase Habitacion, onde pasamos como parámetros todos os atributos de dita clase
     * 
     * @param tipoHabitacion -> Tipo de habitación
     * @param idHabitacion -> Id da habitación
     * @param prezo -> Prezo da habitación
     */
    public Habitacion(String tipoHabitacion, int idHabitacion, double prezo) {
        this.setTipoHabitacion(tipoHabitacion);
        this.setIdHabitacion(idHabitacion);
        this.setPrezo(prezo);
    }


    //Getters&Setters
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public int getIdHabitacion() {
        return idHabitacion;
    }
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    public double getPrezo() {
        return prezo;
    }

    /**
     * Método encargado de validar o prezo dunha habitación
     * 
     * @param prezo -> Prezo dunha habitación
     */
    public void setPrezo(double prezo) {
        if (prezo < 0) {
            this.prezo = 1;
        } else{
            this.prezo = prezo;
        }
    }
}