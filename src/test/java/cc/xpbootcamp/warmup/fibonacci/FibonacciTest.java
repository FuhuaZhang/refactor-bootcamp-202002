package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {
    Fibonacci fibonacci = new Fibonacci();

    @Test
    void should_return_1_when_calculate_given_position_1() {
        int result = fibonacci.calculate(1);
        assertEquals(1, result);
    }

    @Test
    void should_throw_when_given_invalid_position() {
        assertThrows(IllegalArgumentException.class, ()->fibonacci.calculate(-1));
    }

    @Test
    void should_return_1_when_calculate_given_position_2() {
        int result = fibonacci.calculate(2);
        assertEquals(1, result);
    }

    @Test
    void should_return_2_when_calculate_given_position_3() {
        int result = fibonacci.calculate(3);
        assertEquals(2, result);
    }
}
