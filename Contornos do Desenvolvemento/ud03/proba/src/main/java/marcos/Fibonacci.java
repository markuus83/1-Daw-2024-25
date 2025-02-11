package marcos;

public class Fibonacci {

	public static int fib(int n) {

		if (n <= 1) {
			return n;
		}
		int fib = 1;
		int prevFib = 1;

		for (int i = 2; i < n; i++) {
			int temp = fib;
			fib += prevFib;
			prevFib = temp;
		}
		return fib;
	}

	public static int[] bubbleSort(int[] arr) {
		int n = arr.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// Intercambiar elementos
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			// Si no hubo intercambios, el array ya está ordenado
			if (!swapped)
				break;
		}
		return arr;
	}
}