import java.util.ArrayList;

public class Pregunta {
    
    //Atributos
    private String enunciado;
    private ArrayList<Resposta> respostas;

    /**
     * Constructor da clase Pregunta que recibe como parámetro o atributo enunciado.
     * Engadimos un ArrayList de respostas para cada pregunta.
     * 
     * @param enunciado -> Enunciado da pregunta
     */
    public Pregunta(String enunciado){
        this.setEnunciado(enunciado);
        this.respostas = new ArrayList<Resposta>();
    }

    //GETTERS
    public String getEnunciado() {
        return enunciado;
    }
    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    //SETTERS
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    
    public void setRespostas(ArrayList<Resposta> respostas){
        this.respostas = respostas;
    }

    public void engadirResposta(Resposta resposta){
        respostas.add(resposta);
    }

    public boolean respostasNecesarias(){
        return respostas.size() < 2;
    }
    
}