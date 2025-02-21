import java.util.ArrayList;

public class Equipo {
    
    //Atributos
    private String nomeEquipo;
    private ArrayList<Xogador> plantilla;


    /**
     * Constructor da clase Equipo que recibe como parámetros o atributo nomeEquipo
     * Inicializamos un ArrayList<Xogadores> onde se almacenarán os  datos dos xogadores de dito equipo
     * 
     * @param nomeEquipo -> Nome do equipo
     */
    public Equipo(String nomeEquipo){

        this.setNomeEquipo(nomeEquipo);
        this.plantilla = new ArrayList<Xogador>();

    }


    /**
     * Método encargado de engadir un xogador. Non se engadirá cando existan máis de 10 xogadores nun equipo ou cando exista un xogador que teña o mesmo dorsal.
     * 
     * 
     * @param xogador -> Xogador a engadir
     */
    void engadirXogador(Xogador xogador){

        //Comprobación da lonxitude da plantilla
        if (this.plantilla.size()<10) {

            //Inicializamos variable booleana que cambiará de valor cando exista unha dorsal repetida
            boolean existeDorsal = false;

            //Recorremos o ArrayList para comparar dorsales dos xogadores existentes
            for (Xogador xogadorEngadir: this.plantilla) {
                
                //Se xa existe o dorsal, rematamos o bucle
                if (xogadorEngadir.getDorsal() == xogadorEngadir.getDorsal()) {
                    existeDorsal = true;
                    break;
                }

            }
            if (!existeDorsal) {
                this.plantilla.add(xogador);
                xogador.setEquipo(this);
            }
        }
    }


    /**
     * Método encargado de devolver o xogador dun equipo con maior número de goles. Se existen dous xogadres co mesmos goles, devolve o que ten o número de dorsal máis pequeno.
     * 
     * @return -> devolve un obxecto da clase Xogador
     */
    Xogador getMaximoGoleador(){
        
        Xogador maximo = null;
        boolean maximoAsignado = false;
        
        
        for (Xogador xogadorMaximoGoleador : this.plantilla) {
            if(!maximoAsignado){
                maximo = xogadorMaximoGoleador;
                maximoAsignado = true;
            } else if (maximo.getNumGolesMarcados() < xogadorMaximoGoleador.getNumGolesMarcados()) {
                maximo = xogadorMaximoGoleador;
            } else if (maximo.getNumGolesMarcados() == xogadorMaximoGoleador.getNumGolesMarcados() && maximo.getDorsal() > xogadorMaximoGoleador.getDorsal()) {
                maximo = xogadorMaximoGoleador;
            }
        }
        return maximo;
    }


    //Getter & Setter NomeEquipo
    public String getNomeEquipo() {
        return nomeEquipo;
    }
    public void setNomeEquipo(String nomeEquipo) {
        this.nomeEquipo = nomeEquipo;
    }
}