
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {

    public static void main(String[] args) throws Exception {

        ArrayList<Deportista> deportistas = new ArrayList<>();
        ArrayList<Tenista> tenistas = new ArrayList<>();

        ArrayList<Piloto> pilotos = new ArrayList<>();
        ArrayList<PilotoF1> pilotosF1 = new ArrayList<>();
        ArrayList<PilotoMotoGP> pilotosMotoGP = new ArrayList<>();

        Tenista alcaraz = new Tenista("Carlos Jonás Alcaraz", "Carlos Alcaraz", "23/05/2003", 3);
        Tenista djokovic = new Tenista("Novak Djokovic", "Djokovic", "29/07/1987", 2);

        PilotoF1 alonso = new PilotoF1("Fernando Alonso Díaz", "Fernando Alonso", "29/07/1981", "Aston Martin", 33, 26, 22);
        PilotoF1 max = new PilotoF1("Max Emilian Verstappen", "Verstappen", "30/09/1997", "Red Bull Racing", 62, 33, 40);

        PilotoMotoGP marquez = new PilotoMotoGP("Marc Márquez Alentà", "Marc Márquez", "17/02/1993", "Grenesi Racing", 102.0);
        PilotoMotoGP bagnaia = new PilotoMotoGP("Francesco Bagnaia", "Bagnaia", "14/01/1997", "Ducati Lenovo Team", 461.0);

        deportistas.add(alcaraz);
        deportistas.add(djokovic);
        deportistas.add(alonso);
        deportistas.add(max);
        deportistas.add(marquez);
        deportistas.add(bagnaia);

        tenistas.add(alcaraz);
        tenistas.add(djokovic);

        pilotos.add(alonso);
        pilotos.add(max);
        pilotos.add(marquez);
        pilotos.add(bagnaia);

        pilotosF1.add(alonso);
        pilotosF1.add(max);

        pilotosMotoGP.add(marquez);
        pilotosMotoGP.add(bagnaia);

        /**
         * Establecemos o criterio de ordenación dos deportistas
         */
        Collections.sort(deportistas);
        System.out.println("\nDeportistas: ");
        for (Deportista d : deportistas) {
            System.out.println("\t" + d);
        }

        /**
         * Establecemos o criterio de ordenación dos tenistas
         */
        Collections.sort(tenistas, new Comparator<Tenista>() {
            @Override
            public int compare(Tenista t1, Tenista t2) {
                return t1.getRanking().compareTo(t2.getRanking());
            }
        });

        System.out.println("\nTenistas: ");
        for (Tenista t : tenistas) {
            System.out.println("\t" + t);
        }

        /**
         * Establecemos o criterio de ordenación dos pilotos
         */
        Collections.sort(pilotos, new CompararPilotosPorPuntos());

        System.out.println("\nPilotos: ");
        for (Piloto p : pilotos) {
            System.out.println("\t" + p);
        }

        /**
         * Establecemos o criterio de ordenación dos pilotos de Formula 1
         */
        Collections.sort(pilotosF1, new CompararPilotosPorPuntos());
        System.out.println("\nPilotos de Formula 1");
        for (PilotoF1 pF1 : pilotosF1) {
            System.out.println("\t" + pF1);
        }

        /**
         * Establecemos o criterio de ordenación dos pilotos de MotoGP
         */
        Collections.sort(pilotosMotoGP, new CompararPilotosPorPuntos());
        Collections.reverse(pilotosMotoGP);
        System.out.println("\nPilotos de MotoGP");
        for (PilotoMotoGP pMGP : pilotosMotoGP) {
            System.out.println("\t" + pMGP);
        }

    }
}