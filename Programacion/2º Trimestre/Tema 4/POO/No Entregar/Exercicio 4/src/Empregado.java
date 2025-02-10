public class Empregado {

    private String dni;
    private String nome;
    private String apelido1;
    private String apelido2;
    private Double salarioBruto;
    private static final double tarifaIRPF = 0.15;

    public Empregado(String dni, String nome, String apelido1, String apelido2, Double salarioBruto) {
        this.dni = dni;  // Non validamos o DNI no constructor
        this.nome = nome;
        this.apelido1 = apelido1;
        this.apelido2 = apelido2;
        this.salarioBruto = salarioBruto;
    }

    public Empregado(String dni, String nome, String apelido1, Double salarioBruto) {
        this.dni = dni;  // Non validamos o DNI no constructor
        this.nome = nome;
        this.apelido1 = apelido1;
        this.salarioBruto = salarioBruto;
    }

    public Empregado(String nome, String apelido1, Double salarioBruto) {
        this.nome = nome;
        this.apelido1 = apelido1;
        this.salarioBruto = salarioBruto;
        this.dni = "Sen información";  // Non se proporciona DNI
        this.apelido2 = "";  // Sen apelido2
    }

    public String getNome() {
        return nome;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public String getApelidos() {
        return apelido1 + " " + apelido2;
    }

    public Double getSalarioNeto() {
        return salarioBruto * (1 - tarifaIRPF);  // Restando o IRPF
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApelido1(String apelido1) {
        this.apelido1 = apelido1;
    }

    public void setApelido2(String apelido2) {
        this.apelido2 = apelido2;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    private boolean comprobacionDNI(String dni) {
        // Convertir a mayúsculas y eliminar espacios
        dni = dni.toUpperCase().trim();
    
        // Comprobar que el DNI tiene 9 caracteres
        if (dni.length() != 9) {
            return false;
        }
    
        // Comprobar que los primeros 8 caracteres son dígitos
        if (!dni.substring(0, 8).matches("\\d{8}")) {
            return false;
        }
    
        // Comprobar que el último carácter es una letra
        if (!dni.substring(8).matches("[A-Z]")) {
            return false;
        }
    
        // Obtener el número y la letra del DNI
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letra = dni.charAt(8);
    
        // Calculamos la letra válida para el número
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE"; // Mapeo de letras según el DNI
        char letraValida = letras.charAt(numero % 23);
    
        // Comprobar si la letra proporcionada coincide con la letra válida
        return letra == letraValida;
    }
    

    public String getDNI() {
        if (dni.equals("Sen información")) {
            return "Sen información";
        } else {
            return dni;
        }
    }

    public void setDNI(String dni) {
        if (this.comprobacionDNI(dni)) {
            this.dni = dni;
        } else {
            this.dni = "Sen información";  
        }
    }
}
