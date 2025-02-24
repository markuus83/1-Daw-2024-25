import java.util.ArrayList;

public class Pregunta {
   
    //Atributos
    private String enunciadoPregunta;
    private ArrayList<Resposta> respostas;
    
    /**
     * Constructor da clase Pregunta, onde recibe como parámetro o atributo enunciadoPregunta
     * 
     * @param enunciadoPregunta -> Enunciado da pregunta
     */
    public Pregunta(String enunciadoPregunta) {
        this.setEnunciadoPregunta(enunciadoPregunta);
        this.respostas = new ArrayList<>();
    }


    /**
     * Método encargado de engadir unha resposta a unha pregunta
     * 
     * @param resposta -> Resposta a engadir
     */
    public void engadirResposta(Resposta resposta){
        respostas.add(resposta);
    }

    //GETTERS
    public String getEnunciadoPregunta() {
        return enunciadoPregunta;
    }
    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    //SETTERS
    public void setEnunciadoPregunta(String enunciadoPregunta) {
        this.enunciadoPregunta = enunciadoPregunta;
    }
    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }

}