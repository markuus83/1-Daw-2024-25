public class Cadrado {
    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado, MedidaDistancia unidade) {
        if (unidade == MedidaDistancia.dm) {
            this.lado = lado/10;

        } else if (unidade == MedidaDistancia.cm) {
            this.lado = lado/100;

        } else if (unidade == MedidaDistancia.dm) {
            this.lado= lado/1000;
            
        } else {
            this.lado = lado;
        }
    }

    

}