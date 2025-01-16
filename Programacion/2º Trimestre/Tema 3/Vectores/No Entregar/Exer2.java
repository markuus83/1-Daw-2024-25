import java.util.Scanner;

public class Exer2 {
	
    public static void main(String[] args) {
    
    	Scanner scanner = new Scanner(System.in);
    	
        //Inicializamos o array a traballar
    	int[] numeros = {3,5,7,2,9};

        //Definimos a condicion
    	while (numeros.length > 0) {

            //Recorremos o array e amosamos o seu contido
            for(int i=0;i < numeros.length ;i++){
                System.out.print(numeros[i] + " ");
            }

            //Deixamos unha linea 
            System.out.println();

            //preguntamos o índice do elemento a eliminar
            System.out.print("Ingrese o índice do elemento a eliminar: ");
            int indice = scanner.nextInt();

            //Erro se o indice non entra nos valores permitidos
            if (indice >= numeros.length || indice < 0) {
                System.out.println("Erro");
            }else{
                //Amosamos o índice do elemento a eliminar
                System.out.println("Elemento eliminado: " + numeros[indice]);

                //Inicializamos un array cun elemento menos
                int[] array = new int [numeros.length -1];

                //Recorremos o primeiro array
                int j=0;
                for (int i =0; i<numeros.length;i++){

                    if (i!= indice) {
                        array[j++]=numeros[i];
                    }
                }

                numeros = array;
            }
        }
        //Imprimimos "Fin"
        System.out.println("Fin");
    scanner.close();
    }
}
