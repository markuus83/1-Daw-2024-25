package marcos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FibonacciTest {
    
    @Test
    public void testFib() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(0, fibonacci.fib(0));
        assertEquals(1, fibonacci.fib(1));
        assertEquals(1, fibonacci.fib(2));
        assertEquals(2, fibonacci.fib(3));
        assertEquals(3, fibonacci.fib(4));
        assertEquals(5, fibonacci.fib(5));
        assertEquals(8, fibonacci.fib(6));
        assertEquals(13, fibonacci.fib(7));
        assertEquals(21, fibonacci.fib(8));
        assertEquals(34, fibonacci.fib(9));
        assertEquals(55, fibonacci.fib(10));
    }

}
