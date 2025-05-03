import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> listaNumeros = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listaNumeros.add(i);
        }

        // 1. Filtrar tódolos números pares da lista listaNumeros, elevalos ao cadrado e
        // mostralos por pantalla.
        listaNumeros.stream().filter(n -> n % 2 == 0).map(n -> n * n).forEach(n -> System.out.println(n));

        System.out.println("-------------");

        // 2. Converte unha lista de números nunha lista de String e garda na variable
        // listaString

        List<String> listaString = listaNumeros.stream().map(String::valueOf).collect(Collectors.toList());

        for (String s : listaString)
            System.out.println(s);

        System.out.println("-------------");

        // 3. Indica a cantidade de cadeas de listaString que teñen máis dun carácter
        long sol3 = listaString.stream().filter(n -> n.length() > 1).count();
        System.out.println(sol3);
    }
}
