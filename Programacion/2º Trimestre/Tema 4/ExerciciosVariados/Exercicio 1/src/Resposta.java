public class Resposta {
    
    //Atributos
    private String contidoResposta;
    
    /**
     * Constructor da clase Resposta, onde pasamos como parámetro o atributo contidoResposta
     * 
     * @param contidoResposta -> Contido da resposta
     */
    public Resposta(String contidoResposta) {
        this.setContidoResposta(contidoResposta);
    }

    public String getContidoResposta() {
        return contidoResposta;
    }

    public void setContidoResposta(String contidoResposta) {
        this.contidoResposta = contidoResposta;
    }
}