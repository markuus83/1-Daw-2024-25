public class Cliente implements Comparable<Cliente>{

    //Atributos
    private String dni;
    private String nome;
    private int idade;
    private double soldo;

    
    /**
     * Método constructor da clase Cliente
     * 
     * @param dni -> DNI do cliente
     * @param nome -> Nome do cliente
     * @param idade -> Idade do cliente
     * @param soldo -> Soldo do cliente
     */
    public Cliente(String dni, String nome, int idade, double soldo) {
        this.setDni(dni);
        this.setNome(nome);
        this.setIdade(idade);
        this.setSoldo(soldo);
    }


    //Getters&Setters
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double getSoldo() {
        return soldo;
    }
    public void setSoldo(double soldo) {
        this.soldo = soldo;
    }


    @Override
    public String toString() {
        return this.getDni()+" - "+this.getNome()+". Idade "+this.getIdade()+". Soldo: "+this.getSoldo();
    }
    
    @Override
    public boolean equals(Object obj){
        Cliente cliente = (Cliente) obj;

        return this.dni.equals(cliente.getDni());
    }


    @Override
    public int compareTo(Cliente o) {
        return this.getDni().compareTo(o.getDni());
    }
    
}