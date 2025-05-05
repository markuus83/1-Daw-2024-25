package modelo.usuarios;

import utiles.clasesStatic.ComprobarCorreo;
import utiles.clasesStatic.ComprobarDNI;
import utiles.enumerandos.TipoUsuario;
import utiles.excepcions.CorreoInvalido;
import utiles.excepcions.DNIIncorrecto;

public class Cliente extends Usuario {

    //Atributos
    private String nome;
    private String apelidos;
    private String dni;
    private String correo;

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
            throw new CorreoInvalido("Correo inválida!");
        }
    }

    @Override
    public TipoUsuario getRol() {
        return TipoUsuario.CLIENTE;
    }
    
}
