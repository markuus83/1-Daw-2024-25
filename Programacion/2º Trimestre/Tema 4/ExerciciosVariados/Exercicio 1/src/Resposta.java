public class Resposta {
    
    //Atributos
    private String textoResposta;


    /**
     * Constructor da clase Resposta, onde recibe como parámetro o atributo contidoResposta
     * 
     * @param contidoResposta -> Contido da resposta
     */
    public Resposta(String textoResposta) {
        this.setContidoResposta(textoResposta);
    }


    //GETTERS
    public String getContidoResposta() {
        return textoResposta;
    }

    //SETTERS
    public void setContidoResposta(String textoResposta) {
        this.textoResposta = textoResposta;
    }

    

}