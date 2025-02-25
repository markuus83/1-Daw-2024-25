import java.util.ArrayList;

public class Pregunta {
    private String enunciado;
    private ArrayList<Resposta> respostas;

    public Pregunta(String enunciado) {
        this.setEnunciadoPregunta(enunciado);;
        this.respostas = new ArrayList<>();
    }

    public void engadirResposta(Resposta resposta) {
        this.respostas.add(resposta);
    }

    //GETTERS
    public String getEnunciadoPregunta() {
        return enunciado;
    }
    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    //SETTERS
    public void setEnunciadoPregunta(String enunciado) {
        this.enunciado = enunciado;
    }
    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }

    public boolean precisoMaisRespostas(){
        return this.respostas.size() < 2;
    }

}
