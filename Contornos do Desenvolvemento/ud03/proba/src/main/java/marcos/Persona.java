package marcos;

public class Persona {

    private String nombre;

    private String apellido;

    private int edad;

    private String dni;



    public void setNombre(String nombre) {

        this.nombre = nombre;

    }



    public String getNombre() {

        return nombre;

    }



    public void setApellido(String apellido) {

        this.apellido = apellido;

    }



    public String getApellido() {

        return apellido;

    }



    public void setEdad(int edad) {

        this.edad = edad;

    }



    public int getEdad() {

        return edad;

    }



    public void setDni(String dni) {

        this.dni = dni;

    }



    public String getDni() {

        return dni;

    }



    @Override

    public String toString() {

        return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni + "]";

    }

}
