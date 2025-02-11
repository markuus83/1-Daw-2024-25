package marcos;

public class Ciclo {
    private String codigo;
    private String nombre;
    private Nivel nivel;
    private Centro centro;

    public Ciclo(){

    }

    public Ciclo(String codigo, String nombre, Nivel nivel, Centro centro) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.centro = centro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }

    @Override
    public String toString() {
        return "Ciclo [codigo=" + codigo + ", nombre=" + nombre + ", nivel=" + nivel + ", centro=" + centro + "]";
    }
}