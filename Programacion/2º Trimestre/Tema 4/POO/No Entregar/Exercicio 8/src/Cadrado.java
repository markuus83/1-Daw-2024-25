public class Cadrado {

    private double lado;


    public Cadrado(double lado){
        this.setLado(lado, MedidaDistancia.m);
    }

    public Cadrado(double lado, MedidaDistancia medida){
        this.setLado(lado, medida);
    }


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

    public double perimetroCadrado(MedidaDistancia medida){

        if(medida == MedidaDistancia.dm) {
            return (this.lado * 10) * 4;
        }
        else if (medida == MedidaDistancia.cm) {
            return (this.lado * 100) * 4;
        }
        else if (medida == MedidaDistancia.km) {
            return (this.lado / 1000) * 4;
        }
        else {
            return this.lado * 4;
        }

    }

    public double areaCadrado(MedidaDistancia medida){

        if(medida == MedidaDistancia.dm) {
            return (this.lado * 10) * (this.lado * 10);
        }
        else if (medida == MedidaDistancia.cm) {
            return (this.lado * 100) * (this.lado * 100);
        }
        else if (medida == MedidaDistancia.km) {
            return (this.lado / 1000) * (this.lado / 1000);
        }
        else {
            return this.lado * this.lado;
        }

    }
}