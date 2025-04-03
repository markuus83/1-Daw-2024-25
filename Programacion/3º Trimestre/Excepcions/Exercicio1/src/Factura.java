class Factura {

    //Atributos
    private static int contador = 0;
    private int numeroFactura;
    private String dni;
    private double cantidade;

    /**
     * Método constructor da clase factura
     * 
     * @param dni -> DNI do cliente
     * @param cantidade ->  Cantidade da factura
     * @throws ExcepcionNumeroNegativo -> Se a cantidade é negativa
     * @throws ExcepcionDNIInvalido -> Se o DNI non é válido
     */
    public Factura(String dni, double cantidade) throws ExcepcionNumeroNegativo, ExcepcionDNIInvalido {

        setDni(dni);
        setCantidade(cantidade);

        //Incrementamos o contador únicamente se non hai excepcións
        this.numeroFactura = ++contador;
    }
    
    public int getNumeroFactura() {
        return numeroFactura;
    }

    public String getDni() {
        return dni;
    }

    /**
     * Método para comprobar se o DNI é válido
     * 
     * @param dni -> DNI a comprobar
     * @return true se o DNI é válido, false se non
     */
    public void setDni(String dni) throws ExcepcionDNIInvalido {
        if (!ExcepcionDNIInvalido.comprobarDNI(dni)) {
            throw new ExcepcionDNIInvalido("Inválido DNI");
        } else{
            this.dni = dni;
        }
    }

    public double getCantidade() {
        return cantidade;
}

    /**
     * Método para establecer a cantidade da factura
     * 
     * @param cantidade -> Cantidade da factura
     * @throws ExcepcionNumeroNegativo -> Se a cantidade é negativa
     */
    public void setCantidade(double cantidade) throws ExcepcionNumeroNegativo {
        if (cantidade < 0) {
            throw new ExcepcionNumeroNegativo("Inválido Prezo");
        }
        this.cantidade = cantidade;
    }
    
    @Override
    public String toString(){
        return this.getNumeroFactura()+": "+this.getDni()+" -> "+this.getCantidade()+" €";
    }
}