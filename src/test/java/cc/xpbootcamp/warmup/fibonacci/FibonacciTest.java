package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {
    @Test
    void should_return_1_when_calculate_given_position_1() {
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.calculate(1);
        assertEquals(1, result);
    }

    @Test
    void should_throw_when_given_invalid_position() {
        Fibonacci fibonacci = new Fibonacci();
        assertThrows(IllegalArgumentException.class, ()->fibonacci.calculate(-1));
    }
}
