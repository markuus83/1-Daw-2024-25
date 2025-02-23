import java.util.HashMap;

public class Prueba {
    public static void main(String[] args) {
        // Crear un HashMap
        HashMap<String, Integer> edades = new HashMap<>();

        // Agregar elementos (clave, valor)
        edades.put("Juan", 25);
        edades.put("Maria", 30);
        edades.put("Carlos", 28);

        // Mostrar los elementos con un índice
        int indice = 0;
        for (String clave : edades.keySet()) {
            System.out.println(indice + ": " + clave + " - " + edades.get(clave));
            indice++;
        }
    }
}
