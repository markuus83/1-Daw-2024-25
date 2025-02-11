package marcos;

public class Nivel {
    private String nivel;

    public Nivel() {
    }

    public Nivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Nivel [nivel=" + nivel + "]";
    }

}