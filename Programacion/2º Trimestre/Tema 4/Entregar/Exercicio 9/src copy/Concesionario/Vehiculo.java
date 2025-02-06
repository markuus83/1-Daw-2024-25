package Concesionario;

import utils.TipoCombustible;

public class Vehiculo {
    private static int numeroTotalVehiculos = 0;
    private static int velocidadeMaxima = 120;

    private String matricula;
    private String marca;
    private String modelo;
    private TipoCombustible tipoCombustible;
    private double velocidade;

    public Vehiculo(String matricula, String marca, String modelo) {
        this(matricula, marca, modelo, TipoCombustible.GASOLINA);
    }

    public Vehiculo(String matricula, String marca, String modelo, TipoCombustible tipoCombustible) {

        if (comprobarMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            this.matricula = "0000XXX";
        }

        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.velocidade = 0;
        numeroTotalVehiculos++;
    }

    public static boolean comprobarMatricula(String matricula) {
        return matricula.matches("\\d{4}[BCDFGHJKLMNPRSTVWXYZ]{3}");
    }

    public static int getNumeroTotalVehiculos() {
        return numeroTotalVehiculos;
    }

    public static void setVelocidadeMaxima(int velocidadeMaxima) {
        Vehiculo.velocidadeMaxima = velocidadeMaxima;
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

    public double getVelocidade() {
        return velocidade;
    }

    //de aki hasta abajo modificar en casa
    private void modificarVelocidade(double velocidade) {
        this.velocidade = Math.max(0, Math.min(velocidadeMaxima, this.velocidade + velocidade));
    }

    public void acelerar() {
        modificarVelocidade(10);
    }

    public void acelerar(int velocidade) {
        modificarVelocidade(velocidade);
    }

    public void decelerar() {
        modificarVelocidade(-10);
    }

    public void decelerar(int velocidade) {
        modificarVelocidade(-velocidade);
    }
}
