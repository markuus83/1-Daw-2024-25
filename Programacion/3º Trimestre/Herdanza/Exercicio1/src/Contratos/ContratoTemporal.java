package Contratos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContratoTemporal extends Contrato{
    
    //Atributos
    private int meses;
    private LocalDate dataInicio; 
    
    public static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    //Getters&Setters
    public int getMeses() {
        return meses;
    }
    public void setMeses(int meses) {

        //Non pode haber meses = 0 ou menor
        if (this.meses < 1) {
            this.meses = 1;

        //A cantidade máxima é de 6 meses
        } else if (this.meses > 6) {
            this.meses = 6;

        //Establecer meses
        } else{
            this.meses = meses;
        }
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    

}


//TODO -> Acabar con la transformación de fechas y formato, hacerlo de forma correcta!