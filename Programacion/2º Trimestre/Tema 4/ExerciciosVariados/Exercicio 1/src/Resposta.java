public class Resposta {
    
    //Atributos
    private String contidoResposta;


    /**
     * Constructor da clase Resposta, onde recibe como parámetro o atributo contidoResposta
     * 
     * @param contidoResposta -> Contido da resposta
     */
    public Resposta(String contidoResposta) {
        this.setContidoResposta(contidoResposta);
    }


    //GETTERS
    public String getContidoResposta() {
        return contidoResposta;
    }

    //SETTERS
    public void setContidoResposta(String contidoResposta) {
        this.contidoResposta = contidoResposta;
    }

    

}