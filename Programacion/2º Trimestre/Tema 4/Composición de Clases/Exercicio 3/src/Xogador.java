import java.util.Optional;

public class Xogador {
    
    //Atributos
    private String nomeXogador;
    private int dorsal;
    private int numGolesMarcados;
    private Equipo equipo;


    /**
     * Constructor da clase Xogador que recib como parámetros os atributos nome e dorsal.
     * Validamos o dorsal adoptando os valores por defecto e inicializamos o número de goles sempre a 0
     * 
     * @param nome -> Nome do xogador
     * @param dorsal -> Dorsal do xogador (validado)
     */
    public void Xogador(String nomeXogador, int dorsal){
        this.setNome(nomeXogador);
        this.setDorsal(dorsal);
        this.numGolesMarcados = 0;
    }

    //Getters
    public String getNome() {
        return nomeXogador;
    }
    public int getDorsal() {
        return dorsal;
    }
    public int getNumGolesMarcados() {
        return numGolesMarcados;
    }


    /**
     * Cando o xogador non pertence a ningún equipo devolvemos unha clase Optional baleira
     * 
     * @return -> clase Optional
     */
    public Optional<Equipo> getEquipo() {
        if (isLibre()) {
            return Optional.empty();
        } else{
            return Optional.of(this.equipo);
        }
    }




    //Setters
    public void setNome(String nomeXogador) {
        this.nomeXogador = nomeXogador;
    }
    public void setDorsal(int dorsal) {
        if (dorsal <= 1 || dorsal >= 99) {
            this.dorsal = 99;
        } else{
            this.dorsal = dorsal;
        }
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Método que valida se un xogador pertece a un equipo ou non
     * 
     * @return true or false dependendo de si o xogador está asociado a un equipo ou non
     */
    public boolean isLibre(){
        if (equipo != null) {

            //Se non é null non está libre
            return false;
        } else{

            //Se é null está asociado a un equipo
            return true;
        }
    }
 
    /**
     * Aumentamos nunha unidade os goles marcados
     */
    public void marcarGol(){
        this.numGolesMarcados++;
    }
}

