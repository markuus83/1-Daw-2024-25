package Contratos;

import Utils.TipoPagasExtra;

public class ContratoIndefinido extends Contrato {
    
    //Atributos
    private TipoPagasExtra tipoPagaExtra;

    /**
     * Constructor propio da clase Contrato indefinido, onde recibe como parámetros todos os atributos da clase pai, mais o seu inherente
     * 
     * @param nome -> Nome do contratado
     * @param ape1 -> Primeiro apelido do contratado
     * @param ape2 -> Segundo apelido do contratado
     * @param salarioBrutoAnual -> Salario bruto anual do contratado
     * @param irpf -> Irpf
     * @param tipopagaExtra -> Tipo de paga extra
     */
    public ContratoIndefinido(String nome, String ape1, String ape2, double salarioBrutoAnual, double irpf, TipoPagasExtra tipopagaExtra) {
        super(nome, ape1, ape2, salarioBrutoAnual, irpf);
        this.tipoPagaExtra = tipoPagaExtra;
    }

    //Getters
    public TipoPagasExtra getTipopagaExtra() {
        return tipoPagaExtra;
    }

    @Override
    public double getSalarioMensualNeto(){

        if (getTipopagaExtra() == TipoPagasExtra.normal) {
            return (double) getSalarioBrutoAnual()/12;

        } else{
            return (double) getSalarioBrutoAnual()/14;
        }
    }

    @Override
    public String toString(){
        return "Contrato Indefinido <"+getNumContrato()+">: <"+getApelidos()+">, <"+getNome()+">. Salario mensual: <"+getSalarioMensualNeto()+">. Pagas anuais: <"+getTipopagaExtra()+">";
    }
}