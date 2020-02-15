package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    @Test
    void should_return_1_when_calculate_given_position_1() {
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.calculate(1);
        assertEquals(1, result);
    }
}
