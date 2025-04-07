import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception{

        ArrayList<String> emailsNormais = new ArrayList<>();
        ArrayList<String> emailsSanClemente = new ArrayList<>();

        //Inicializamos un ArrayList con String para posteriormente convertilo en obxectos
        emailsNormais.add("maria.gomez@iessanclemente.net");
        emailsNormais.add("juan.perez@gmail.com");
        emailsNormais.add("laura.fernandez@iessanclemente.net");
        emailsNormais.add("laura.fernandeziessanclemente.net");
        emailsNormais.add("carlos.rodriguez@yahoo.com");
        emailsNormais.add("ana.martinez@iessanclemente.net");
        emailsNormais.add("pedro.lopez@hotmail.com");
        emailsNormais.add("sofia.rivas@iessanclemente.net");
        emailsNormais.add("miguel.vazquez@outlook.com");
        emailsNormais.add("paula.castro@iessanclemente.net");
        emailsNormais.add("david.sanchez@protonmail.com");
        emailsNormais.add("david.sanchez@protonmail");
       
        //Inicializamos un ArrayList con String para posteriormente convertilo en obxectos
        emailsSanClemente.add("maria.gomez@iessanclemente.net");
        emailsSanClemente.add("juan.perez@gmail.com");
        emailsSanClemente.add("laura.fernandez@iessanclemente.net");
        emailsSanClemente.add("laura.fernandeziessanclemente.net");
        emailsSanClemente.add("carlos.rodriguez@yahoo.com");
        emailsSanClemente.add("ana.martinez@iessanclemente.net");
        emailsSanClemente.add("pedro.lopez@hotmail.com");
        emailsSanClemente.add("sofia.rivas@iessanclemente.net");
        emailsSanClemente.add("miguel.vazquez@outlook.com");
        emailsSanClemente.add("paula.castro@iessanclemente.net");
        emailsSanClemente.add("david.sanchez@protonmail.com");
        emailsSanClemente.add("david.sanchez@protonmail");
        
        //Capturamos erros
        System.out.println("\nEmails normais: ");
        for (String string : emailsSanClemente) {
            try {
                new Email(string);
            } catch (EmailInvalidoException e) {
                System.out.println("\t"+e.getMessage());
            }
        }

        //Capturamos erros
        System.out.println("\nEmail dominio San Clemente: ");
        for (String string : emailsSanClemente) {
            try {
                new EmailSanClemente(string);
            } catch (EmailInvalidoException e) {
                System.out.println("\t"+e.getMessage());
            }
        }
    }
}