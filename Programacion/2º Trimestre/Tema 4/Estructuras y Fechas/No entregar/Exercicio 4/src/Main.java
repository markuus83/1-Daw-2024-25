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
        

        HashMap<String, Double> produtos = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nIngrese a opción desexada: ");
            System.out.println("\t1. Engadir nome");
            System.out.println("\t2. Eliminar produto");
            System.out.println("\t3. Mostrar produtos cun determinado prezo");
            System.out.println("\t4. Sair do programa");
            System.out.println("\t5. Amosar HashMap");

            System.out.print("Opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();


            switch (option) {
                
                case 1 -> {
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Prezo do produto: ");
                    double prezo = scanner.nextDouble();

                    boolean existeProduto = produtos.containsKey(nome);

                    if (existeProduto) {
                        System.out.println("O produto xa existe.");

                    } else {
                        produtos.put(nome, prezo);
                        System.out.println("Produto engadido con éxito.");
                    }

                    continue;
                }

                case 2 -> {
                    boolean estaBaleiro = produtos.isEmpty();

                    if (estaBaleiro) {
                        System.out.println("Non se pode borrar un produto dunha colección vacía.");

                        continue;

                    } else{
                        int id = 0;
                        for (String produto : produtos.keySet()) {
                            System.out.println(id + ": " + produto + " - " + produtos.get(produto));
                            id++;
                        }
    
                        System.out.print("Ingrese o índice do produto a eliminar: ");
                        int indice = scanner.nextInt();
    
                        if (indice < 0 || indice >= produtos.size()) {
                            System.out.println("O índice ingresado non é válido.");
    
                            continue;
                            
                        } else {
                            String produto = (String) produtos.keySet().toArray()[indice];
                            produtos.remove(produto);
                            System.out.println("Produto eliminado con éxito.");
                        }
                        
                        continue;

                    }
                }

                case 3 -> {
                    System.out.print("Prezo mínimo: ");
                    double prezoMin = scanner.nextDouble();

                    System.out.print("Prezo máximo: ");
                    double prezoMax = scanner.nextDouble();

                    for (String produto : produtos.keySet()) {
                        double produtoPrezo = produtos.get(produto);

                        if (produtoPrezo >= prezoMin && produtoPrezo <= prezoMax) {
                            System.out.println(produto + " - " + produtoPrezo);
                        }
                    }
                    
                    continue;
                }

                case 4 -> {
                    System.out.println("Saindo do programa...");
                    continue;
                }

                case 5 -> {
                    for (String produto : produtos.keySet()) {
                        System.out.println(produto + " - " + produtos.get(produto));
                    }
                    continue;
                }

                default -> System.out.println("Erro. Opción non válida");
            }
            scanner.close();
        }
    }
}