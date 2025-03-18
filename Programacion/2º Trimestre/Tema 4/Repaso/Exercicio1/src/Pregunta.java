import java.util.ArrayList;

public class Pregunta {
    
    //Atributos
    private String enunciado;
    private ArrayList<Resposta> respostas;

    
    /**
     * Constructor ca clase Pregunta
     * 
     * @param enunciado -> Enunciado da pregunta
     * @param respostas -> ArrayList cas respostas de cada pregunta
     */
    public Pregunta(String enunciado ) {
        this.setEnunciado(enunciado);
        this.setRespostas(new ArrayList<Resposta>());
    }

    //Getters&Setters
    public String getEnunciado() {
        return enunciado;
    }
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }
    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }

    /**
     * Método encargado de engadir respostas a unha pregunta
     * 
     * @param resposta -> Resposta a engadir
     */
    public void engadirResposta(Resposta resposta){
        this.respostas.add(resposta);
    }

    /**
     * Método encargado de devolver true or false en función de se unha pregunta precisa máis respostas ou non
     * 
     * @param pregunta -> Pregunta da cal queremos saber se necesitamos máis respostas ou non.
     * @return -> True or false dependendo de se ten máis de duas respostas ou non
     */
    public boolean precisoMaisRespostas(){

        return this.getRespostas().size() < 2;
      
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
