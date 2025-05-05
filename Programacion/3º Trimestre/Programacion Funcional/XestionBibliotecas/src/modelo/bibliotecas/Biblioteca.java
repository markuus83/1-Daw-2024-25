package modelo.bibliotecas;

public class Biblioteca {
    
    //Atributos
    private int idBiblioteca; 
    private String nome;
    private String direccion;
    private String cidade;
    private String provincia;

    //Atributo static
    private static int contador = 0;

    /**
     * Método constructor da clase Biblioteca.
     * 
     * @param nome -> Nome da biblioteca
     * @param direccion -> Dirección da biblioteca
     * @param cidade -> Cidade da biblioteca
     * @param provincia -> Provincia da biblioteca
     */
    public Biblioteca(String nome, String direccion, String cidade, String provincia) {
        this.setNome(nome);
        this.setDireccion(direccion);
        this.setCidade(cidade);
        this.setProvincia(provincia);

        //Non fai falta que vaia de último posto que non existen excepcións a capturar.
        this.idBiblioteca = contador++;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public int getIdBiblioteca(){
        return idBiblioteca;
    }

    @Override
    public String toString(){
        return this.getIdBiblioteca()+" "+this.getNome()+", "+this.getDireccion()+"; "+this.getCidade()+" ("+this.getProvincia()+").";
    }
}
