import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Deportista> deportistas = new ArrayList<Deportista>();
        ArrayList<Tenista> tenistas = new ArrayList<>();

        ArrayList<Piloto> pilotos = new ArrayList<Piloto>();
        ArrayList<PilotoF1> pilotosF1 = new ArrayList<PilotoF1>();
        ArrayList<PilotoMotoGP> pilotosMotoGP = new ArrayList<PilotoMotoGP>();


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

        pilotos.add(alonso);
        pilotos.add(max);
        pilotos.add(marquez);
        pilotos.add(bagnaia);

        pilotosF1.add(alonso);
        pilotosF1.add(max);

        pilotosMotoGP.add(marquez);
        pilotosMotoGP.add(bagnaia);

        System.out.println();

        for(Deportista elemento: deportistas ){
            System.out.println(elemento);
        }

        System.out.println("-----------");

        for(Piloto elemento: pilotos ){
            System.out.println(elemento);
        }

        System.out.println("-----------");

        for(Tenista elemento: tenistas ){
            System.out.println(elemento);
        }

        System.out.println("-----------");

        for(PilotoF1 elemento: pilotosF1 ){
            System.out.println(elemento);
        }

        System.out.println("-----------");

        for(PilotoMotoGP elemento: pilotosMotoGP ){
            System.out.println(elemento);
        }

    }
}