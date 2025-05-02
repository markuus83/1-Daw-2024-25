package Contratos;

public abstract class Contrato {
    
    //Atributos
    private int numContrato;
    private String nome;
    private String ape1;
    private String ape2;
    private double salarioBrutoAnual;
    private double irpf;

    private static int contador = 0;

    /**
     * 
     * Constructor da clase contrato, onde recibimos por parámetros todos os atributos agás o numContrato.
     * O número de contrato asígnase automaticamente de xeito secuencial.
     * 
     * @param nome -> Nome do contratado
     * @param ape1 -> Primeiro apelido do contratado
     * @param ape2 -> Segundo apelido do contratado
     * @param salarioBrutoAnual -> Salario bruto anual do contratado
     * @param irpf -> Irpf
     */
    public Contrato(String nome, String ape1, String ape2, double salarioBrutoAnual, double irpf) {
        this.numContrato = ++contador; 
        this.setNome(nome);
        this.setApe1(ape1);
        this.setApe2(ape2);
        this.setSalarioBrutoAnual(salarioBrutoAnual);
        this.setIrpf(irpf);
    }

    //Getters&Setters
    public int getNumContrato() {
        return numContrato;
    }
    public String getNome() {
        return nome;
    }
    public String getApe1() {
        return ape1;
    }
    public String getApe2() {
        return ape2;
    }
    public String getApelidos(){
        //Añadimos un .trim() para eliminar posibles valores en blanco del segundo apellido.
        return (ape1 + " " + ape2).trim();
    }
    public double getSalarioBrutoAnual() {
        return salarioBrutoAnual;
    }
    public double getIrpf() {
        return irpf;
    }
    
    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }
    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }
    public void setSalarioBrutoAnual(double salarioBrutoAnual) {
        this.salarioBrutoAnual = salarioBrutoAnual;
    }
    public void setIrpf(double irpf) {
        this.irpf = irpf;
    }


    /**
     * Método encargado de calcular o salario neto anual do contratado
     * 
     * @return -> salario neto anual
     */
    public double getSalarioNetoAnual(){
        return (double) salarioBrutoAnual* (1-irpf);
    }

    /**
     * Método encargado de calcular o salario neto mensual
     * 
     * @return -> salario neto mensual
     */
    public double getSalarioMensualNeto(){
        return (double) getSalarioBrutoAnual()/12;
    }

    @Override
    public String toString() {
        return "<" + getNumContrato() + ">: <" + getApelidos() + 
        ">, <" + getNome() + ">. Salario mensual: <" + getSalarioMensualNeto() + ">";
    }
}