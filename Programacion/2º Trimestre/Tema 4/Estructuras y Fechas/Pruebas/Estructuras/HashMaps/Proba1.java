package Estructuras.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class Proba1 {
    
    public static void main(String[] args) {

        //Inicializamos un HashMap
        HashMap<String, Integer> idades = new HashMap<>();

        idades.put("Nora", 18);
        idades.put("Marcos", 20);
        idades.put("Dani", 25);


        //Obtener un valor
        Integer idade = idades.get("Nora");
        System.out.println("\nA idade de Ana é: " + idade);


        //Eliminar un valor
        idades.remove("Dani");


        //Iterar sobre un HashMap
        System.out.println("\n\tPrimera iteracción: ");
        for (String nombre : idades.keySet()) {
            System.out.println(nombre + " -> " + idades.get(nombre));
        }


        //Comprobar se contén unha clave ou valor
        boolean existeClave = idades.containsKey("Nora");
        boolean existeValor = idades.containsValue(20);
        System.out.println("\nClave: " + existeClave + "|-| Valor: " + existeValor);


        //Obter tamaño do HashMap
        int tamaño = idades.size();
        System.out.println("\nEl tamaño del HashMap es: "+tamaño);

        
        //Obter conxuntos de claves e valores
        ArrayList<String> claves = new ArrayList<>(idades.keySet());
        ArrayList<Integer> valores = new ArrayList<>(idades.values());

        
        //Limpar o HashMap
        idades.clear();
        
    }

}
