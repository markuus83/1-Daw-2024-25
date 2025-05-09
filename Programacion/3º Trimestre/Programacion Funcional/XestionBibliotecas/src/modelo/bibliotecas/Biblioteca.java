package modelo.bibliotecas;

import java.util.HashMap;
import java.util.Optional;

import modelo.libros.Exemplar;
import modelo.usuarios.AdministradorBiblioteca;

public class Biblioteca {
    
    //Atributos
    private int idBiblioteca; 
    private String nome;
    private String direccion;
    private String cidade;
    private String provincia;
    private AdministradorBiblioteca admin;
    private boolean tenAdmin;
    private HashMap<Integer,Exemplar> exemplares;

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
        this.tenAdmin = false;
        this.exemplares = new HashMap<>();

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

    /**
     * Método encargado de asignar un administrador
     */
    public void setAdministradorBiblioteca(AdministradorBiblioteca adminB){
        this.admin = adminB;
        this.tenAdmin = true;
    }
    
    /**
     * Método encargado de devolver o Administrador dunha biblioteca
     */
    public Optional<AdministradorBiblioteca> getAdmin() {
        if (this.tenAdmin) return Optional.of(this.admin);
        else return Optional.empty();
    }

    /**
     * Método encargado de devolver se unha biblioteca ten administrador ou non
     */
    public boolean isTenAdmin() {
        return tenAdmin;
    }

    /**
     * Método encargado de engadir un exemplar
     */
    public void engadirExemplares(Exemplar e){
       exemplares.put(e.getIdentificador(), e);
    }

    /**
     * Método encargado de eliminar un exemplar
     */
    public void eliminarExemplar(int id){
        exemplares.remove(id);
    }

    @Override
    public String toString(){
        return this.getIdBiblioteca()+" "+this.getNome()+", "+this.getDireccion()+"; "+this.getCidade()+" ("+this.getProvincia()+").";
    }
}
