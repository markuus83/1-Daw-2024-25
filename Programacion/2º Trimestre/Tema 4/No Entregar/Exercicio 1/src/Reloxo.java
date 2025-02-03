public class Reloxo {

    private String marca;
    private String modelo;
    private Double prezo;
    private String tipoReloxo;


    public Reloxo(){

    }

    public Reloxo(String marca, String modelo, Double prezo, String tipoReloxo) {
        this.marca = marca;
        this.modelo = modelo;
        this.prezo = prezo;
        this.tipoReloxo = tipoReloxo;
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

    public Double getPrezo() {
        return prezo;
    }

    public void setPrezo(Double prezo) {

        if (prezo > 0) {
            this.prezo = prezo;
        }
    }

    public String getTipoReloxo() {
        return tipoReloxo;
    }

    public void setTipoReloxo(String tipoReloxo) {

        if (tipoReloxo.equals("analogico") || tipoReloxo.equals("digital")) {
            this.tipoReloxo = tipoReloxo;
        }
    }
}