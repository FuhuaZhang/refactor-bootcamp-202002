package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {
    Fibonacci fibonacci = new Fibonacci();

    @Test
    void should_return_1_when_calculate_given_position_1() {
        long result = fibonacci.calculate(1);
        assertEquals(1, result);
    }

    @Test
    void should_throw_when_given_invalid_position() {
        assertThrows(IllegalArgumentException.class, ()->fibonacci.calculate(-1));
    }

    @Test
    void should_return_1_when_calculate_given_position_2() {
        long result = fibonacci.calculate(2);
        assertEquals(1, result);
    }

    @Test
    void should_return_2_when_calculate_given_position_3() {
        long result = fibonacci.calculate(3);
        assertEquals(2, result);
    }

    @Test
    void should_return_50_fibs_when_output_given_position_50() {
        long[] expectFibs = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610,
                987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393,
                196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887,
                9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141,
                267914296, 433494437, 701408733, 1134903170, 1836311903, 2971215073L,
                4807526976L, 7778742049L, 12586269025L};
        long[] result = fibonacci.output();
        assertArrayEquals(expectFibs, result);
    }
}
