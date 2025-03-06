import java.util.ArrayList;

public class Usuario {
    
    // Atributos
    private String nomeUsuario;
    private String nomeDePila;
    private String claveHash;
    private ArrayList<Tarefa> tarefasPendentes;
    private ArrayList<Tarefa> tarefasRealizadas;

    /**
     * Método constructor da clase Usuario, onde pasamos como parámetros o nome de usuario, o nome de pila e o hash da clave. Ademais, inicializamos as listas de tarefas pendentes e realizadas.
     * 
     * @param nomeUsuario -> String co nome de usuario
     * @param nomeDePila -> String co nome de pila
     * @param claveHash -> String co hash da clave
     */
    public Usuario(String nomeUsuario, String nomeDePila, String claveHash) {
        this.setNomeUsuario(nomeUsuario);
        this.setNomeDePila(nomeDePila);
        this.setClaveHash(claveHash);
        this.tarefasPendentes = new ArrayList<>();
        this.tarefasRealizadas = new ArrayList<>();
    }

    // Getters y Setters
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

    public ArrayList<Tarefa> getTarefasPendentes() {
        return tarefasPendentes;
    }

    public ArrayList<Tarefa> getTarefasRealizadas() {
        return tarefasRealizadas;
    }

    /**
     * Método que devolve a lista de tarefas pendentes do usuario en formato de cadea.
     * 
     * @return -> String coa lista de tarefas pendentes
     */
    public void agregarTarefaPendente(Tarefa tarefa) {
        this.tarefasPendentes.add(tarefa);
    }

    /**
     * Método que devolve a lista de tarefas realizadas do usuario en formato de cadea.
     * 
     * @param tarefa -> Tarefa a marcar como realizada
     */
    public void marcarTarefaComoRealizada(Tarefa tarefa) {
        this.tarefasPendentes.remove(tarefa);
        this.tarefasRealizadas.add(tarefa);
    }

    /**
     * Método que devolve a lista de tarefas realizadas do usuario en formato de cadea.
     * 
     * @param usuarios -> ArrayList de usuarios
     * @param nomeUsuario -> String co nome de usuario
     * @return -> Booleano que indica se existe o usuario
     */
    public static boolean existeUsuario(ArrayList<Usuario> usuarios, String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNomeUsuario().equals(nomeUsuario)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que devolve a lista de tarefas realizadas do usuario en formato de cadea.
     * 
     * @param nome -> String co nome de usuario
     * @param contrasinal -> String co contrasinal
     * @return -> Booleano que indica se se iniciou sesión correctamente
     */
    public boolean iniciarSesion(String nome, String contrasinal) {
        if (this.getNomeUsuario().equals(nome)) {
            if (this.getClaveHash().equals(HashPassword.hashPassword(contrasinal))) {
                return true;
            }
        }
        return false;
    }
}
