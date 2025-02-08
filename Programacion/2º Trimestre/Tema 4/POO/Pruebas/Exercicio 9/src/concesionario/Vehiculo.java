package concesionario;

import utils.TipoCombustible;

public class Vehiculo {
    
    //Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private TipoCombustible combustible;
    private Double velocidadeActual;

    //Variables independentes
    private Integer numCoches;
    private static Double velocidadeMaxima;

    public static Boolean validarMatricula(String matricula){

        if (matricula.length() != 7) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            char caracter = matricula.charAt(i);
            if(caracter < 0 || caracter > 9){
                return false;
            }

        }

        //DEVOLVER FALSE CUANDO LOS ÚLTIMOS TRES CARACTERES NO SON CONSONANTES
        return true;
    }

    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.combustible = TipoCombustible.GASOLINA;
        this.velocidadeActual = 0.0;
    }

    

}
