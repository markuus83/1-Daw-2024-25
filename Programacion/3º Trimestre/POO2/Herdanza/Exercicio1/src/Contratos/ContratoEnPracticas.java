package Contratos;

public class ContratoEnPracticas extends Contrato {
    
    //Atributos
    private String titulacion;

    
    /**
     * COnstructor propio da clase ContratEnPracticas. Recibe como parámetros todos os atributos da clase contrato mais o seu propio.
     * 
     * @param nome -> Nome do contratado
     * @param ape1 -> Primeiro apelido do contratado
     * @param ape2 -> Segundo apelido do contratado
     * @param salarioBrutoAnual -> Salario bruto anual do contratado
     * @param irpf -> Irpf
     * @param titulacion -> titulacion do empregado en prácticas
     */
    public ContratoEnPracticas(String nome, String ape1, String ape2, double salarioBrutoAnual, double irpf, String titulacion) {

        super(nome, ape1, ape2, salarioBrutoAnual, irpf);

        this.setTitulacion(titulacion);
    }

    //Getters&Setters
    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    @Override
    public String toString(){
        return "Contrato En Prácticas "+this.getNumContrato()+": <"+this.getApelidos()+">, <"+this.getNome()+">. Salario mensual: <"+this.getSalarioMensualNeto()+">. Titulacion: <"+this.getTitulacion()+">.";
    }
}