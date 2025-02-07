public class Coche {

    private String marca;
    private String modelo;
    private String cor;
    private int numPasaixeiro;

    /**
     * Constructor que recibe todos os parámetros da clase
     * 
     * @param marca
     * @param modelo
     * @param cor
     * @param numPasaixeiro
     */
    public Coche(String marca, String modelo, String cor, int numPasaixeiro) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.numPasaixeiro = numPasaixeiro;
    }

    /**
    * Constructor que recibe todos os parámetros agás os numero de pasaxeiros, que o asigna por defecto
    * @param marca
    * @param modelo
    * @param cor
    */

    public Coche(String marca, String modelo, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        numPasaixeiro = 5; 
    }


    public String getMarca() {
        return marca;
    }

   
    public void setMarca(String marca) {
        
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {

        this.modelo = modelo;
    }


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {

        this.cor = cor;
    }

    /**
     * Non poden existir pasaxeiros negativos ou 0
     * 
     * @return
     */
    public int getNumPasaixeiro() {

        if (numPasaixeiro > 0) {
            return numPasaixeiro;
        } else {
            return 0;
        }

    }

    public void setNumPasaixeiro(int numPasaixeiro) {
        this.numPasaixeiro = numPasaixeiro;
    }
}