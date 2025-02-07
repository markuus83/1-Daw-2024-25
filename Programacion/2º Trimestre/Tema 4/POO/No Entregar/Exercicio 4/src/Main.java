public class Main {
    public static void main(String[] args) throws Exception {

        Empregado empregado1 = new Empregado("55026812R", "Manuel", "Varela", "Lopez", 1500.0);

        System.out.println(empregado1.getDNI());

        empregado1.setDNI("55026811R");

        System.out.println("<" + empregado1.getApelidos() + ">, <" + empregado1.getNome() + "> con <" + empregado1.getDNI() + "> ten un salario neto de <" + empregado1.getSalarioNeto() + "> €");
    }
}
