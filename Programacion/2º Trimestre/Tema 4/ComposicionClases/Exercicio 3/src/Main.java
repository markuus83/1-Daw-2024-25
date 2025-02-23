public class Main {
    public static void main(String[] args) {

        // Novo xogador
        Xogador castolo = new Xogador("Castolo", 10);

        for (int i = 0; i < 5; i++) {
            castolo.marcarGol();
        }

        // Novo xogador
        Xogador ximelez = new Xogador("Ximelez", 11);

        for (int i = 0; i < 3; i++) {
            ximelez.marcarGol();
        }

        // Novo xogador
        Xogador minanda = new Xogador("Minanda", 7);

        for (int i = 0; i < 4; i++) {
            minanda.marcarGol();
        }

        // Novo xogador
        Xogador messi = new Xogador("Messi", 10);

        for (int i = 0; i < 6; i++) {
            messi.marcarGol();
        }

        // Novo xogador
        Equipo programacion = new Equipo("Programacion");
        programacion.engadirXogador(castolo);
        programacion.engadirXogador(ximelez);
        programacion.engadirXogador(minanda);
        programacion.engadirXogador(messi);


        System.out.println("O nome do máximo goleador é: " + programacion.getMaximoGoleador().getNome());

        minanda.marcarGol();

        System.out.println("O nome do máximo goleador é: " + programacion.getMaximoGoleador().getNome());
    }
}