package Estructuras.ArrayList;

import java.util.ArrayList;

public class Proba1 {
    public static void main(String[] args) {
    
        //Inicializamos el ArrayList
        ArrayList<String> nombresArrayList = new ArrayList<>();
        nombresArrayList.add("Carlos");
        nombresArrayList.add("Ana");
        nombresArrayList.add("Elena");

        //Iterar sobre un ArrayList
        System.out.println("\n\tPrimera iteración del ArrayList: ");
        for (String nombre : nombresArrayList) {
            System.out.println(nombre);
        }

        //Obtener elementos
        String obtenerNombre = nombresArrayList.get(0);
        System.out.println("\n"+obtenerNombre);

        //Actualizar elementos
        nombresArrayList.set(1, "Lucía");
        System.out.println("\n\tSegunda iteración del ArrayList: ");
        for (String nombre : nombresArrayList) {
            System.out.println(nombre);
        }

        //Eliminar elementos: Podemos hacerlo por íncide o por valor.
        nombresArrayList.remove("Lucía");
        System.out.println("\n\tTercera iteración del ArrayList: ");
        for (String nombre : nombresArrayList) {
            System.out.println(nombre);
        }

        //Comprobar existencia
        boolean existe = nombresArrayList.contains("Carlos");
        System.out.println("\nEl valor de dicho nombre es: " + existe);

        //Obtener tamaño del ArrayList
        int tamaño = nombresArrayList.size();
        System.out.println("\nTamaño del arraylist: " + tamaño);

        //Convertir un ArrayList en un Array
        System.out.println("\n\tCuarta iteración, pero ahora convertido en un array: ");
        String[] array = nombresArrayList.toArray(new String[0]);
        for (String nombre : array) {
            System.out.println(nombre);
        }

        //Eliminar todos los elementos de la lista
        nombresArrayList.clear();
        for (String vacioString : array) {
            System.out.println(vacioString);
        }
    }   
}
