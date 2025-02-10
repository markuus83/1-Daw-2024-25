package concesionario;

import utils.TipoCombustible;

public class Vehiculo {

    // Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private TipoCombustible combustible;
    private int velocidadeInicial;

    // Variables independientes
    private static int numeroTotalVehiculos = 0;
    private static int velocidadeMaxima = 120;

    /**
     * Método privado encargado de validar la matrícula. Sigue el siguiente formato:
     * - 7 caracteres
     * - Los 4 primeros caracteres deben ser números
     * - Los últimos 3 caracteres deben ser consonantes en mayúsculas
     *
     * @param matricula Matrícula del coche
     * @return Devuelve true o false dependiendo de si la matrícula es válida o no.
     */
    public static boolean validarMatricula(String matricula) {
        //Comprobamos la longitud de la matricula
        if (matricula.length() != 7) {
            return false;
        }

        //Comprobamos que los 4 primeros dígitos siempre sean numéricos
        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(matricula.charAt(i))) {
                return false;
            }
        }

        //Comprobamos que los últimos 3 caracteres sean consonantes en mayúsculas
        String consonantes = "BCDFGHJKLMNPQRSTVWXYZ";
        for (int i = 4; i < 7; i++) {
            if (consonantes.indexOf(matricula.charAt(i)) == -1) {
                return false;
            }
        }

        return true;
    }

    /**
     * Constructor que recibe como parámetros a Matricula, Marca e Modelo co coche. 
     * 
     * O tipo de combustible será sempre Gasolina (usamos o enumerando para establecelo)
     * 
     * A velocidade inicial sempre será 0
     * 
     * Aumentamos o número de coches creados.
     * 
     * @param matricula Establecemos a matrícula, cando non é correcta, devolvemos '0000XXX'
     * @param marca Establecemos a marca do coche
     * @param modelo Establecemos o modelo do coche
     */
    public Vehiculo(String matricula, String marca, String modelo) {
        this.setMatricula(matricula); 
        this.marca = marca;
        this.modelo = modelo;
        this.combustible = TipoCombustible.GASOLINA;
        this.velocidadeInicial = 0;
        numeroTotalVehiculos++;
    }

    /**
     * Constructor que recibe como parámetros a Matricula, Marca, Modelo e Combustible do coche.
     * 
     * A velocidade Inicial sempre será 0.
     * 
     * Aumentamos o número de coches creados.
     * 
     * @param matricula Establecemos a matrícula, cando non é correcta, devolvemos '0000XXX'
     * @param marca Establecemos a marca do coche
     * @param modelo Establecemos o modelo do coche
     * @param combustible Establecemos o combustible do coche
     */
    public Vehiculo(String matricula, String marca, String modelo, TipoCombustible combustible) {
        setMatricula(matricula); 
        this.marca = marca;
        this.modelo = modelo;
        this.combustible = combustible;
        this.velocidadeInicial = 0;
        numeroTotalVehiculos++;
    }

    /**
     * Método privado que recibe unha velocidade como parámetro, e aumenta ou diminúe a velocidade
     * 
     * @param velocidade Velocidade a modificar
     */
    private void modificarVelocidade(int velocidade) {
        int nuevaVelocidad = this.velocidadeInicial + velocidade;

        if (nuevaVelocidad < 0) {
            this.velocidadeInicial = 0;
        } else if (nuevaVelocidad > velocidadeMaxima) {
            this.velocidadeInicial = velocidadeMaxima;
        } else {
            this.velocidadeInicial = nuevaVelocidad;
        }
    }

    /**
     * Método encargado de aumentar a velocidade do coche en 10km/h, para eso, utiliza o método privado establecido anteriormente
     */
    public void acelerar() {
        modificarVelocidade(10);
    }

    /**
     * Método encargado de aumentar a velocidade do coche en función do parámetro, para eso, utiliza o método privado establecido anteriormente
     * 
     * @param velocidade Velocidade a modificar
     */
    public void acelerar(int velocidade) {
        modificarVelocidade(velocidade);
    }

    /**
     * Método encargado de diminuir a velocidade do coche en 10km/h, para eso, utiliza o método privado establecido anteriormente
     */
    public void decelerar() {
        modificarVelocidade(-10);
    }

    /**
     * Método encargado de diminuír a velocidade do coche en función do parámetro, para eso, utiliza o método privado establecido anteriormente
     * 
     * @param velocidade Velocidade a modificar
     */
    public void decelerar(int velocidade) {
        modificarVelocidade(-velocidade);
    }

    // Getters y setters
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establecemos a validación correcta da matrícula
     * 
     * @param matricula matricula do coche
     */
    public void setMatricula(String matricula) {
        if (validarMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            this.matricula = "0000XXX";
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoCombustible getTipoCombustible() {
        return combustible;
    }

    public void setCombustible(TipoCombustible combustible) {
        this.combustible = combustible;
    }

    public static int getNumeroTotalVehiculos() {
        return numeroTotalVehiculos;
    }

    public int getVelocidade() {
        return velocidadeInicial;
    }

    public void setVelocidade(int velocidadeInicial) {
        this.velocidadeInicial = velocidadeInicial;
    }

    public static int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public static void setVelocidadeMaxima(int velocidadeMaxima) {
        Vehiculo.velocidadeMaxima = velocidadeMaxima;
    }
}


