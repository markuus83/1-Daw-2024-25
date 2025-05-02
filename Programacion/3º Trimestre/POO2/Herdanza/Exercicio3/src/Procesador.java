import Enum.Zocalo;

public class Procesador extends Componhente{

    //Atributos
    private Zocalo zocalo;
    private int numeroColores;

    /**
     * 
     * @param marca
     * @param modelo
     * @param prezo
     * @param zocalo
     * @param numeroColores
     */
    public Procesador(String marca, String modelo, double prezo, Zocalo zocalo, int numeroColores){

        super(marca, modelo, prezo);
        this.setZocalo(zocalo);
        this.setNumeroColores(numeroColores);

    }

    //Getters&Setters
    public Zocalo getZocalo() {
        return zocalo;
    }

    public void setZocalo(Zocalo zocalo) {
        this.zocalo = zocalo;
    }

    public int getNumeroColores() {
        return numeroColores;
    }

    public void setNumeroColores(int numeroColores) {
        this.numeroColores = numeroColores;
    }

    @Override
    public String toString(){
        return "Procesador "+super.toString()+" con "+this.getNumeroColores()+" e socket "+this.getZocalo();
    }
}