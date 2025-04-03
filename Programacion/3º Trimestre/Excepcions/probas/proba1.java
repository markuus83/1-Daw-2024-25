public class proba1{

    public static void main(String[] args) {
        
        try {
            int[] numeros ={1,2,3};

            System.out.println(numeros[8]);

        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Ocorreu un erro: " + e.getMessage());
        }
    }

}