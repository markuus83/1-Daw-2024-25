package concesionario;

import utils.TipoCombustible;

public class Vehiculo {
    
    private String matricula;
    private String marca;
    private String modelo;
    private TipoCombustible tipoCombustible;
    private int velocidadeActual;
    private static int numeroVehiculos = 0;
    private static int velocidadeMaxima = 120;


    /**
     * Constructor que inicializa un vehículo con matrícula, marca e modelo.
     * O tipo de combustible por defecto é gasolina e a velocidade inicial é 0 km/h.
     * @param matricula Matrícula do vehículo.
     * @param marca Marca do vehículo.
     * @param modelo Modelo do vehículo.
     */

    public Vehiculo(String matricula, String marca, String modelo) {
        this(matricula, marca, modelo, TipoCombustible.GASOLINA);
    }


    /**
     * Constructor que inicializa un vehículo con matrícula, marca, modelo e tipo de combustible.
     * A velocidade inicial é 0 km/h.
     * @param matricula Matrícula do vehículo.
     * @param marca Marca do vehículo.
     * @param modelo Modelo do vehículo.
     * @param tipoCombustible Tipo de combustible do vehículo.
     */
    public Vehiculo(String matricula, String marca, String modelo, TipoCombustible tipoCombustible) {
        if (validarMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            this.matricula = "0000XXX";
        }
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.velocidadeActual = 0;
        numeroVehiculos++;
    }


    /**
     * Método estático que valida unha matrícula.
     * A matrícula debe ter 7 caracteres, os 4 primeiros números e os 3 últimos letras maiúsculas.
     * @param matricula Matrícula a validar.
     * @return True se a matrícula é válida, false en caso contrario.
     */
    public static boolean validarMatricula(String matricula) {
        if (matricula == null || matricula.length() != 7) {
            return false;
        }
        
        for (int i = 0; i < 4; i++) {
            char c = matricula.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        
        for (int i = 4; i < 7; i++) {
            char c = matricula.charAt(i);
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        
        return true;
    }


    /**
     * Método privado que modifica a velocidade do vehículo.
     * A velocidade non pode ser menor que 0 nin maior que a velocidade máxima establecida.
     * @param cambio Velocidade a aumentar ou diminuír.
     */
    private void modificarVelocidade(int cambio) {

        int novaVelocidade = this.velocidadeActual + cambio;
        
        if (novaVelocidade < 0) {
            this.velocidadeActual = 0;
        } else if (novaVelocidade > velocidadeMaxima) {
            this.velocidadeActual = velocidadeMaxima;
        } else {
            this.velocidadeActual = novaVelocidade;
        }
    }


    /**
     * Método público para acelerar o vehículo en 10 km/h.
     */
    public void acelerar() {
        modificarVelocidade(10);
    }

    /**
     * Método público para acelerar o vehículo en función do parámetro indicado.
     * @param velocidade Cantidade de km/h a aumentar.
     */
    public void acelerar(int velocidade) {
        modificarVelocidade(velocidade);
    }


    /**
     * Método público para decelerar o vehículo en 10 km/h.
     */
    public void decelerar() {
        modificarVelocidade(-10);
    }


    /**
     * Método público para decelerar o vehículo en función do parámetro indicado.
     * @param velocidade Cantidade de km/h a reducir.
     */
    public void decelerar(int velocidade) {
        modificarVelocidade(-velocidade);
    }


    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public int getVelocidade() {
        return velocidadeActual;
    }

    public static int getNumeroTotalVehiculos() {
        return numeroVehiculos;
    }

    public static int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public static void setVelocidadeMaxima(int velocidadeMaxima) {
        Vehiculo.velocidadeMaxima = velocidadeMaxima;
    }
}