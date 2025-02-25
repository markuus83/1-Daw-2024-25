public class Resposta {
    
    //Atributos
    private String textoResposta;
    private int contador = 0;

    /**
     * Constructor da clase Resposta, onde recibe como parámetro o atributo contidoResposta
     * 
     * @param contidoResposta -> Contido da resposta
     */
    public Resposta(String textoResposta) {
        this.setContidoResposta(textoResposta);
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
    
}