import java.util.Comparator;

public class CompararPilotosPorPuntos implements Comparator<Piloto> {
    
    @Override
    public int compare(Piloto p1, Piloto p2) {
        return Double.compare(p1.getPuntos(), p2.getPuntos());
    }

}