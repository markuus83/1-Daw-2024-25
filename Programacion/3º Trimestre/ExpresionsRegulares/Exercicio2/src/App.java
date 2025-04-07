import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception{

        ArrayList<Email> emailsNormais = new ArrayList<>();
        ArrayList<EmailSanClemente> emailsSanClemente = new ArrayList<>();

        try {
            emailsNormais.add(new Email("maria.gomez@iessanclemente.net"));
            emailsNormais.add(new Email("juan.perez@gmail.com"));
            emailsNormais.add(new Email("laura.fernandez@iessanclemente.net"));
            emailsNormais.add(new Email("laura.fernandeziessanclemente.net"));
            emailsNormais.add(new Email("carlos.rodriguez@yahoo.com"));
            emailsNormais.add(new Email("ana.martinez@iessanclemente.net"));
            emailsNormais.add(new Email("pedro.lopez@hotmail.com"));
            emailsNormais.add(new Email("sofia.rivas@iessanclemente.net"));
            emailsNormais.add(new Email("miguel.vazquez@outlook.com"));
            emailsNormais.add(new Email("paula.castro@iessanclemente.net"));
            emailsNormais.add(new Email("david.sanchez@protonmail.com"));
            emailsNormais.add(new Email("david.sanchez@protonmail"));
        } catch (EmailInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            emailsSanClemente.add(new EmailSanClemente("maria.gomez@iessanclemente.net"));
            emailsSanClemente.add(new EmailSanClemente("juan.perez@gmail.com"));
            emailsSanClemente.add(new EmailSanClemente("laura.fernandez@iessanclemente.net"));
            emailsSanClemente.add(new EmailSanClemente("laura.fernandeziessanclemente.net"));
            emailsSanClemente.add(new EmailSanClemente("carlos.rodriguez@yahoo.com"));
            emailsSanClemente.add(new EmailSanClemente("ana.martinez@iessanclemente.net"));
            emailsSanClemente.add(new EmailSanClemente("pedro.lopez@hotmail.com"));
            emailsSanClemente.add(new EmailSanClemente("sofia.rivas@iessanclemente.net"));
            emailsSanClemente.add(new EmailSanClemente("miguel.vazquez@outlook.com"));
            emailsSanClemente.add(new EmailSanClemente("paula.castro@iessanclemente.net"));
            emailsSanClemente.add(new EmailSanClemente("david.sanchez@protonmail.com"));
            emailsSanClemente.add(new EmailSanClemente("david.sanchez@protonmail"));
        } catch (EmailInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
    }
}