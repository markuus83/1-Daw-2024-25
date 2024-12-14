public class Suma{

	public static void main (String [] args){

	//Convertir los argumentos a numeros
	double numero1 = Double.parseDouble(args[0]);
	double numero2 = Double.parseDouble(args[1]);

	//Calcular la suma
	double suma = numero1 + numero2;

	//Imprimir el resultado
	System.out.println(suma);

	}

}
