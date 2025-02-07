public class Alumno {
    
    private String nome;
    private String apelido1;
    private String apelido2;
    private int notatrimestre1;
    private int notatrimestre2;
    private int notatrimestre3;
    private int numExpediente;

    //atributo para controlar el expediente
    private static int ultimoExpediente = 100;

    //Constructor
    public Alumno(String nome, String apelido1, String apelido2) {
        this.nome = nome;
        this.apelido1 = apelido1;
        this.apelido2 = apelido2;
        this.numExpediente = ++ultimoExpediente;  
    }

    public Alumno(String nome, String apelido1) {
        this.nome = nome;
        this.apelido1 = apelido1;
        this.apelido2 = "";
        this.numExpediente = ++ultimoExpediente;  
    }


    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setApelido1(String apelido1) {
        this.apelido1 = apelido1;
    }
    public void setApelido2(String apelido2) {
        this.apelido2 = apelido2;
    }
    public void setNotatrimestre1(int notatrimestre1) {
        if (notatrimestre1 >= 0 || notatrimestre1 <= 10) {
            this.notatrimestre1 = notatrimestre1;
        }
    }
    public void setNotatrimestre2(int notatrimestre2) {
        if (notatrimestre2 >= 0 || notatrimestre2 <= 10) {
            this.notatrimestre2 = notatrimestre2;
        }
    }
    public void setNotatrimestre3(int notatrimestre3) {
        if (notatrimestre3 >= 0 || notatrimestre3 <= 10) {
            this.notatrimestre3 = notatrimestre3;
        }
    }
    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    //Getters
    public String getNome() {
        return nome;
    }
    public int getNumExpediente() {
        return numExpediente;
    }
    public String getApelidos(){
        return apelido1 + apelido2;
    }
    public double getNotamedia(){
        return (notatrimestre1 + notatrimestre2 + notatrimestre3)/3.0;
    }
    public String getAprobado(){
        if (getNotamedia() >= 5) {
            return "Aprobado";
        } else {
            return "Suspenso";
        }
    }
}
