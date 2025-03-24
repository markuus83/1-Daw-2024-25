package Utils;
public enum TipoHabitacion {
    
    Simple(1),
    Doble(2),
    Triple(3);

    private final int tipo;
    
    private TipoHabitacion(int tipo){
        this.tipo=tipo;
    }

    public int getTipoHabitacion(){
        return tipo;
    }

    /**
     * Método encargado de asignar un valor numñerico a un enumerando.
     * 
     * @param valor -> Valor de enteiro
     * @return -> Tipo de habitación do enumerando
     */
    public static TipoHabitacion valor(int valor){

        //Recorremos 
        for (TipoHabitacion tipo : TipoHabitacion.values()) {
            if (tipo.getTipoHabitacion() == valor) {
                return tipo;
            }
        }
        return null;
    }
}
