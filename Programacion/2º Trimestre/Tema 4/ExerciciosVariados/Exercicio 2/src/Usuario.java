public class Usuario {
    
    //Atributos
    private String nomeUsuario;
    private String nomeDePila;
    private String claveHash;


    //Constructor
    public Usuario(String nomeUsuario, String nomeDePila, String claveHash) {
        this.setNomeUsuario(nomeUsuario);
        this.setNomeDePila(nomeDePila);
        this.setClaveHash(claveHash);
    }

    //Getters&Setters
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeDePila() {
        return nomeDePila;
    }

    public void setNomeDePila(String nomeDePila) {
        this.nomeDePila = nomeDePila;
    }

    public String getClaveHash() {
        return claveHash;
    }

    public void setClaveHash(String claveHash) {
        this.claveHash = HashPassword.hashPassword(claveHash);
    }

    
    public boolean iniciarSesion(String nome, String contrasinal){

        for (Usuario usuario : personas) {
            if (usuario.getNomeUsuario().equals(nome) &&
                usuario.getClaveHash().equals(HashPassword.hashPassword(contrasinal))) {
                
                    return true;
            }
        }

    }
}