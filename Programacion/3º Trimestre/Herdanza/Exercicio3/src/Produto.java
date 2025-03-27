

public abstract class Produto {
    
    private String marca;
    private String modelo;
    private double prezo;

    /**
     * Constructor propio da clase Produto, onde recibe como parámetros todos os atributos da clase
     * 
     * @param marca -> Marca do produto
     * @param modelo -> Modelo do produto
     * @param prezo -> Prezo do produto
     */
    public Produto(String marca, String modelo, double prezo) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPrezo(prezo);
    }

    //Getters&Setters
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
    public double getPrezo() {
        return prezo;
    }
    public void setPrezo(double prezo) {
        if (prezo <=0) {
            this.prezo = 1;
        } else{
            this.prezo = prezo;
        }
    }

    /**
     * Método encargado de evaluar si dos objetos son iguales
     */
    public boolean equals(Object obj){

        Produto produto = (Produto) obj;

        if (this.marca.equals(produto.getMarca()) && this.modelo.equals(produto.getModelo())) {
            return true;
        } else{
            return false;
        }

    }


    @Override
    public String toString() {
        return "Produto [marca=" + marca + ", modelo=" + modelo + ", prezo=" + prezo + "]";
    }

   
    
    
}