/**
 * Realiza un programa utilizando a clase HashMap na que se almacene unha lista de produtos e o seu prezo. O nome do produto será a clave, e o seu valor o prezo. Constará do seguinte menú:
 * 
 *  1. Engadir produto: Engadirase un novo produto. Se xa existe o produto avisarase ao usuario se decide ou non actualizar o prezo.
 * 
 *  2. Eliminar produto: Mostrarase un menú para eliminar un produto
 * 
 *  3. Mostrar produtos cun determinado prezo: o usuario engadirá por teclado un prezo máximo e un mínimo e mostraranse os produtos cun prezo nese intervalo
 * 
 *  4. Saír do programa: cerrarase o programa
 */
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {

        HashMap <String , Double> produtos = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nIngrese a opción desexada: ");
            System.out.println("\t1. Engadir nome");
            System.out.println("\t2. Eliminar produto");
            System.out.println("\t3. Eliminar nome");
            System.out.println("\t4. Sair do programa");

            int option = scanner.nextInt();
            scanner.nextLine();

            //Engadir produto
            if (option == 1) {
                System.out.print("Ingrese o nome do produto: ");
                String nome = scanner.nextLine();

                System.out.print("Ingrese o prezo do produto: ");
                double prezo = scanner.nextDouble();


                produtos.put(nome, prezo);


            //Eliminar produto
            } else if (option == 2) {
                for (String nome : produtos.keySet()) {
                    System.out.println(nome + " - " + produtos.get(nome));
                }
            
            //Mostrar produtos nun intervalo
            } else if (option == 3) {
            

            //Sair
            } else if (option == 4) {
                System.out.println("Saindo do programa...");
                break;

            //Erros
            } else {
                System.out.println("Erro. Opción non válida");
            }
        }

        scanner.close();
    }
}
