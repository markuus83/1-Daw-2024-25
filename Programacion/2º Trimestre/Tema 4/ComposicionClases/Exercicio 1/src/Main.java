import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {

        Grupo grupo1 = new Grupo("La raíz", "España", LocalDate.of(2006, 1, 1));

        Disco disco1 = new Disco("Entre poetas y presos", grupo1, LocalDate.of(2016, 1, 1), 15);

        System.out.println("\nO grupo '" + grupo1.getNome() + "' foi fundado fai " + grupo1.getIdade() + " anos.");

        System.out.println("\nEntre a creación do grupo '" + grupo1.getNome() + "' e o lanzamento do seu disco " + disco1.getTitulo() + " pasaron " + disco1.anosExistenza() + " anos");
    }
}