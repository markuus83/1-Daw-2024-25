public class Empregado {

    private String dni;
    private String nome;
    private String apelido1;
    private String apelido2;
    private Double salarioBruto;

    private static double tarifaIRPF = 0.15;


    private Boolean comprobacionDNI(String dni){

        dni = dni.toUpperCase().trim();

   

        if (dni.length() !=9){
            return false;
        } 

        /**
         * tengo que comprobar longitud
         * última letra
         * primeros 8 caracteres son numéricos
         * 
         * 
         */
        
        if (dni.) {
            
        }

            
        
    }
}

