public class Resposta {
    
    //Atributos
    private String textoResposta;
    private int contador = 0;
    private Pregunta pregunta;

    /**
     * Constructor da clase Resposta, onde recibe como parámetro o atributo contidoResposta
     * 
     * @param contidoResposta -> Contido da resposta
     */
    public Resposta(String textoResposta, Pregunta pregunta) {
        this.textoResposta = textoResposta;
        this.pregunta = pregunta;
        this.contador = 0;
    }
    


    //GETTERS
    public String getContidoResposta() {
        return textoResposta;
    }
    public int getContador() {
        return contador;
    }


    //SETTERS
    public void setContidoResposta(String textoResposta) {
        this.textoResposta = textoResposta;
    }

    /**
     * Método que incrementa o contador de seleccións da resposta
     */
    public void incrementarSeleccion() {
        this.contador++;
    }


    /**
     * Método que calcula a porcentaxe de seleccións da resposta.
     * @param totalRespostas Número total de veces que a pregunta foi respondida.
     * @return Porcentaxe de seleccións desta resposta sobre o total.
     */
    public double calcularPorcentaxeRespostas() {
        int totalVotos = 0;
        
        // Sumamos tódolos votos das respostas da mesma pregunta
        for (Resposta r : pregunta.getRespostas()) {
            totalVotos += r.getContador();
        }
        
        // Evitamos división por cero
        if (totalVotos == 0) {
            return 0;
        }
        
        return (double) this.contador * 100 / totalVotos;
    }
    
}