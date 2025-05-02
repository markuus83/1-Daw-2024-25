public class Factura {
    
    //Atributos
    private int numeroFactura;
    private String dni;
    private double cantidade;

    //Contador para aumentar o numero de factura
    private static int contador = 0;

    /**
     * Constructor da clase Factura
     * 
     * @param dni -> DNI do cliente
     * @param cantidade -> Cantidade a pagar
     * @throws ExcepcionNumeroNegativo -> Posible excepción personalizada
     * @throws ExcepcionDNIInvalido -> Posible excepción personalizada
     */
    public Factura(String dni, double cantidade) throws ExcepcionNumeroNegativo, ExcepcionDNIInvalido{

        setDni(dni);
        setCantidade(cantidade);

        //Únicamente aumentamos o contador cando non se capture ninguna das excepcións
        this.numeroFactura = ++contador;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public String getDni() {
        return dni;
    }
    public double getCantidade() {
        return cantidade;
    }

    @Override
    public String toString(){
        return this.getNumeroFactura()+": "+this.getDni()+" -> "+this.getCantidade()+"€";
    }

    /**
     * Método encargado de avaliar se un dni é válido ou non.
     * De non selo, lanza unha excepción personalizada
     * 
     * @param dni -> Dni a avaliar
     * @throws ExcepcionDNIInvalido -> Posible excepción personalizada
     */
    public void setDni(String dni) throws ExcepcionDNIInvalido {
        if (!ExcepcionDNIInvalido.comprobarDNI(dni)) {
            throw new ExcepcionDNIInvalido("Inválido DNI!");
        } else{
            this.dni = dni;
        }
    }

    /**
     * Método encargado de avaliar se unha cantidade é válida ou non
     * 
     * @param cantidade -> Cantidade a avaliar
     * @throws ExcepcionNumeroNegativo -> Posible excepción personalizada
     */
    public void setCantidade(double cantidade) throws ExcepcionNumeroNegativo {
        if (cantidade<0) {
            throw new ExcepcionNumeroNegativo("Inválido Negativo!");
        }
        this.cantidade = cantidade;
    }
}
