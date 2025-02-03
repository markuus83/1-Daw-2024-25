public class Alumno {
    
    private String nome;
    private String apelido1;
    private String apelido2;
    private byte notatrimestre1;
    private byte notatrimestre2;
    private byte notatrimestre3;
    private int numExpediente;

    //Constructor


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
    public void setNotatrimestre1(byte notatrimestre1) {
        if (notatrimestre1 >= 0 || notatrimestre1 <= 10) {
            this.notatrimestre1 = notatrimestre1;
        }
    }
    public void setNotatrimestre2(byte notatrimestre2) {
        if (notatrimestre2 >= 0 || notatrimestre2 <= 10) {
            this.notatrimestre2 = notatrimestre2;
        }
    }
    public void setNotatrimestre3(byte notatrimestre3) {
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
        return (notatrimestre1 + notatrimestre2 + notatrimestre3)/3;
    }
    public String getAprobado(byte notatrimestre1,byte notatrimestre2, byte notatrimestre3 ){
        if (getNotamedia() >= 5) {
            return "Aprobado";
        } else {
            return "Suspenso";
        }
    }
}
