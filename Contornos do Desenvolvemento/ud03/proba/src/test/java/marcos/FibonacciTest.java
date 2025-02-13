package marcos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class FibonacciTest {
    
    @Test
    public void testFib() {
        assertEquals(0, Fibonacci.fib(0));
        assertEquals(1, Fibonacci.fib(1));
        assertEquals(1, Fibonacci.fib(2));
        assertEquals(2, Fibonacci.fib(3));
        assertEquals(3, Fibonacci.fib(4));
        assertEquals(5, Fibonacci.fib(5));
        assertEquals(8, Fibonacci.fib(6));
        assertEquals(13, Fibonacci.fib(7));
        assertEquals(21, Fibonacci.fib(8));
        assertEquals(34, Fibonacci.fib(9));
        assertEquals(55, Fibonacci.fib(10));
    }
    
    @Test
    public void testBubbleSort() {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        int[] expected = { 11, 12, 22, 25, 34, 64, 90 };
        assertArrayEquals(expected, Fibonacci.bubbleSort(arr));
    }
}
