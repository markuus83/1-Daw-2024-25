import Enum.Conector;
import java.util.ArrayList;

public abstract class Periferico extends Produto{

    //Atributos
    private ArrayList<Conector> conectores;

    public Periferico(String marca, String modelo, double prezo) {
        super(marca, modelo, prezo);
        this.conectores = new ArrayList<>(); 
    }

    public void addConector(Conector conector){
        this.conectores.add(conector);
    }
    
    protected String getConectoresString(){
        for (Conector conector : conectores) {
            System.out.println(conector.);
        }
    }
}
