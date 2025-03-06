import java.util.ArrayList;

public class Pregunta {

    //Atributos
    private String enunciado;
    private ArrayList<Resposta> respostas;

    /**
     * Constructor da clase Pregunta que recibe como parámetros todos os atributos da clase.
     * Ademais, sempre inicializamos un ArrayList para almacenar os obxectos Resposta de dita pregunta
     * 
     * @param enunciado -> Enunciado do obxecto Pregunta
     */
    public Pregunta(String enunciado) {
        this.setEnunciadoPregunta(enunciado);;
        this.setRespostas(new ArrayList<Resposta>());
    }

    /**
     * Método encargado de engadir unha resposta ao ArrayList de respostas
     * 
     * @param resposta -> Obxecto Resposta a engadir
     */
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

    /**
     * Método encargado de especificar se un obxecto Pregunta precisa que devolvamos máis Respostas, posto que o mínimo sempre vai ser 2
     * 
     * @return -> Devolve unha variable booleana dependendo do número de respostas
     */
    public boolean precisoMaisRespostas(){
        return this.respostas.size() < 2;
    }

    /**
     * Método que devolve o número de respostas que ten unha pregunta
     * 
     * @return -> Número de respostas
     */
    public int numeroRespostas(){
        return this.respostas.size();
    }

    /**
     * Método que devolve o número total de respostas que ten unha pregunta
     * 
     * @return -> Número total de respostas
     */
    public int getNumeroRespostas(){
        int totalVotos = 0;
        
        // Sumamos tódolos votos das respostas da mesma pregunta
        for (Resposta r : this.getRespostas()) {
            totalVotos += r.getContador();
        }

        return totalVotos;
    }
}