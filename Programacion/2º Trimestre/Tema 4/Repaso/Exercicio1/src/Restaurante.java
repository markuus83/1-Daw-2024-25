public class Restaurante {
    
    //Atributos
    private String cidade;
    private String numTelefono;
    private Reserva reservaRestaurante;

    //Constructor
    public Restaurante(String cidade, String numTelefono) {
        this.setCidade(cidade);
        this.setNumTelefono(numTelefono);
    }

    //Getters&Setters
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getNumTelefono() {
        return numTelefono;
    }
    /**
     * 
     * @param numTelefono
     */
    public void setNumTelefono(String numTelefono) {
        int lonxitude = numTelefono.length();
        //Comprobamos que a lonxitude do numero do teléfono sexa de 9 caracteres
        if (lonxitude != 9) {
            //Recorremos caracter por caracter
            for (int i = 0; i < lonxitude; i++) {
                //Comprobamos que cada caracter sexa numérico
                if (Character.isDigit(numTelefono.charAt(i))) {
                    this.numTelefono= numTelefono;
                }
            }
        } else{
            this.numTelefono = "Sen número de telefono";
        }
    }   

    
}
