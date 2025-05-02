import java.util.Comparator;

public class CompararTenistaporRanking implements Comparator<Tenista>{

    @Override
    public int compare(Tenista t1, Tenista t2) {

        return t1.getRanking().compareTo(t2.getRanking());

    }
 
}