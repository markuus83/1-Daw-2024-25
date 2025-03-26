package Contratos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContratoTemporal extends Contrato {

    // Atributos
    private int meses;
    private LocalDate dataInicio;

    public static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructor de ContratoTemporal.
     * Recibe la fecha como String en formato "dd/MM/yyyy" y la convierte a LocalDate.
     * 
     * @param nome -> Nombre del contratado
     * @param ape1 -> Primer apellido del contratado
     * @param ape2 -> Segundo apellido del contratado
     * @param salarioBrutoAnual -> Salario bruto anual
     * @param irpf -> Porcentaje de IRPF
     * @param dataInicio -> Fecha de inicio en formato "dd/MM/yyyy"
     * @param meses -> Duración del contrato en meses (máx. 6)
     */
    public ContratoTemporal(String nome, String ape1, String ape2, double salarioBrutoAnual, double irpf, String dataInicio, int meses) {

        super(nome, ape1, ape2, salarioBrutoAnual, irpf);

        this.dataInicio = LocalDate.parse(dataInicio, FORMATO);
        this.setMeses(meses);
    }

    // Getters y Setters
    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        if (meses < 1) {
            this.meses = 1;
        } else if (meses > 6) {
            this.meses = 6;
        } else {
            this.meses = meses;
        }
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = LocalDate.parse(dataInicio, FORMATO);
    }

    /**
     * Devuelve la fecha de inicio formateada como "dd/MM/yyyy".
     * 
     * @return Fecha de inicio en formato String.
     */
    public String getDataInicioFormato() {
        return dataInicio.format(FORMATO);
    }

    /**
     * Método encargado de devolver o fin do contrato
     * 
     * @return -> String ca fecha de fin de formato
     */
    public String getFinContrato(){
        return "O contrato rematará en " + dataInicio.plusMonths(getMeses()).format(FORMATO);
    }

    @Override
    public double getSalarioMensualNeto(){
        return (double) (getSalarioNetoAnual()/12)*getMeses();
    }

    @Override
    public String toString(){
        return "Contrato Temporal <" + this.getNumContrato() + 
        ">: <" + this.getApelidos() + ">, <" + this.getNome() + 
        ">. Salario mensual: <" + this.getSalarioMensualNeto() + 
        ">. Contratado dende " + this.getDataInicioFormato() + 
        " ata " + this.getFinContrato() + ">";
    }
}