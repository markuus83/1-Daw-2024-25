public class Main {
    public static void main(String[] args) {

        Alumno alumno1 = new Alumno("Manuel", "Varela");
        Alumno alumno2 = new Alumno("John", "Doe");

        alumno1.setNotatrimestre1(7);
        alumno1.setNotatrimestre2(7);
        alumno1.setNotatrimestre3(4);

        System.out.println("\n" + alumno1.getApelidos() + ", " + alumno1.getNome() + " con expe. " + alumno1.getNumExpediente() + " con nota " + alumno1.getNotamedia());

        System.out.println("\nO alumno " + alumno1.getNome() + " está: " + alumno1.getAprobado());

        alumno1.setNotatrimestre3(9);

        System.out.println("\nO alumno " + alumno1.getNome() + " está: " + alumno1.getAprobado());

        System.out.println("\n" + alumno2.getApelidos() + ", " + alumno2.getNome() + " con expe. " + alumno2.getNumExpediente() + " con nota " + alumno2.getNotamedia());
    }
}
