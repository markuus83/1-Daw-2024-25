public class proba2 extends Throwable{
    public static void main(String[] args) {
        try {
            int resultado = 10/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}