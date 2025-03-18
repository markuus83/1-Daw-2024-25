public class Resposta {

    //Atributos
    private String contido;
    private Pregunta pregunta;
    private int contador = 0;

    
    /**
     * Constructor da clase Resposta
     * 
     * @param contido -> Contido da resposta
     * @param pregunta -> Pregunta á que pertence
     */
    public Resposta(String contido, Pregunta pregunta) {
        this.setContido(contido);
        this.pregunta = pregunta;
        this.contador = 0;
    }
    
    //Getters&Setters
    public String getContido() {
        return contido;
    }
    public void setContido(String contido) {
        this.contido = contido;
    }
    public Pregunta getPregunta() {
        return pregunta;
    }
    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public void incrementarSeleccion(){
        this.contador++;
    }
    
    public int getContador() {
        return contador;
    }
    
    public double calcularPorcentaxeRespostas() {
        int numRespostas = this.pregunta.getNumeroRespostas();
    
        // Evitamos división por cero
        if (numRespostas == 0) {
            return 0;
        }
    
        return (double) this.contador * 100 / numRespostas;
    }

    
}
