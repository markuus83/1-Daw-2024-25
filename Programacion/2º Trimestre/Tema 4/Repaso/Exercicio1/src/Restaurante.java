import java.util.ArrayList;


public class Restaurante {

    //Atributos
    private String cidade;
    private String telefono;
    private ArrayList<Reserva> reservas;

    
    public Restaurante(String cidade, String telefono, ArrayList<Reserva> reservas) {
        this.cidade = cidade;
        this.telefono = telefono;
        this.reservas = reservas;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        
        int lonxitude = telefono.length();

        if (lonxitude == 9) {
            for (int i = 0; i <= lonxitude; i++) {
                if (Character.isDigit(telefono.charAt(i))) {
                    this.telefono = telefono;
                } 
            }
        }

        this.telefono = "Inválido";
    }

    

}
