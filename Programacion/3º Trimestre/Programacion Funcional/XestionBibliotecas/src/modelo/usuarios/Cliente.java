package modelo.usuarios;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.libros.Prestamo;
import utiles.clasesStatic.ComprobarCorreo;
import utiles.clasesStatic.ComprobarDNI;
import utiles.enumerandos.TipoUsuario;
import utiles.excepcions.CorreoInvalido;
import utiles.excepcions.DNIIncorrecto;

public class Cliente extends Usuario implements Serializable{

    //Atributos
    private String nome;
    private String apelidos;
    private String dni;
    private String correo;

    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    /**
     * Método constructor da clase Cliente
     * 
     * @param contrasinal -> Contrasinal do cliente
     * @param nomeUsuario -> Nome de usuario do cliente
     * @param nome -> Nome real do cliente
     * @param apelidos -> Apelidos do cliente
     * @param dni -> Dni do cliente
     * @param correo -> Correo do cliente
     * @throws DNIIncorrecto -> Posible excepción personalizada
     * @throws CorreoInvalido -> Posible excepción personalizada
     */
    public Cliente(String contrasinal, String nomeUsuario, String nome, String apelidos, String dni, String correo) throws DNIIncorrecto, CorreoInvalido{
        super(contrasinal, nomeUsuario);
        this.setNome(nome);
        this.setApelidos(apelidos);
        this.setDni(dni);
        this.setCorreo(correo);
    }
    
    //Getters&Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getApelidos() {
        return apelidos;
    }
    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }
    public String getDni() {
        return dni;
    }
    public String getCorreo() {
        return correo;
    }

    /**
     * Método encargado de avaliar se un DNI é correcto
     * 
     * @param dni -> Dni a avaliar
     * @throws DNIIncorrecto -> Posible excepción a capturar
     */
    public void setDni(String dni)throws DNIIncorrecto {
        if (ComprobarDNI.comprobarDNI(dni)) {
            this.dni = dni;
        } else{
            throw new DNIIncorrecto("DNI inválido!");
        }
    }

    /**
     * Método encargado de avaliar se un correo é correcto
     * @param correo -> Correo a avaliar
     * @throws CorreoInvalido -> Posible excepción a capturar
     */
    public void setCorreo(String correo) throws CorreoInvalido{
        if (ComprobarCorreo.comprobarCorreo(correo)) {
            this.correo = correo;
        } else {
            throw new CorreoInvalido("Correo inválido!");
        }
    }

    /**
     * Método encargado de devolver se o cliente ten un prestamo activo
     */
    public boolean tenPrestamoActivo() {
        return prestamos    .stream()
                            .filter(p -> !p.estaDevolto())
                            .findFirst()
                            .isPresent(); //Verificamos se o Optional contén algún préstamo

                            
    /**
     * Is present devolve true se o valor != null, senon devolve false
     */
    }


    /**
     * Engade un préstamo ao historial do cliente.
     * @param p Préstamo a engadir
     */
    public void engadirPrestamo(Prestamo p) {
        prestamos.add(p);
    }

    /**
     * Devolve o historial completo de préstamos do cliente.
     * @return Lista de préstamos
     */
    public ArrayList<Prestamo> getHistorialPrestamos() {
        return prestamos;
    }

    @Override
    public TipoUsuario getRol() {
        return TipoUsuario.CLIENTE;
    }
    
}
