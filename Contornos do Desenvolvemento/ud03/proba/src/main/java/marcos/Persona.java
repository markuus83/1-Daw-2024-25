package marcos;
import java.util.Date;

public class Persona {

    //Atributos
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private Integer movil;
    private Date fecNacimiento;
    private String iban;

    public Persona(){
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Integer getMovil() {
        return movil;
    }
    public void setMovil(Integer movil) {
        this.movil = movil;
    }
    public Date getFecNacimiento() {
        return fecNacimiento;
    }
    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }
    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
                + ", correo=" + correo + ", movil=" + movil + ", fecNacimiento=" + fecNacimiento + ", iban=" + iban
                + "]";
    }
}
