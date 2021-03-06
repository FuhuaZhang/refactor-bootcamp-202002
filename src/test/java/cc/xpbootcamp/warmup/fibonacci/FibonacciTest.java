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
        long result = fibonacci.calculate(1).get(0);
        assertEquals(1, result);
    }

    @Test
    void should_throw_when_given_invalid_position() {
        assertThrows(IllegalArgumentException.class, ()->fibonacci.calculate(-1));
    }

    @Test
    void should_return_1_when_calculate_given_position_2() {
        long result = fibonacci.calculate(2).get(1);
        assertEquals(1, result);
    }

    @Test
    void should_return_2_when_calculate_given_position_3() {
        long result = fibonacci.calculate(3).get(2);
        assertEquals(2, result);
    }

    @Test
    void should_return_50_fibs_when_output_given_position_50() {
        ArrayList<Long> expectFibs = new ArrayList<Long>(Arrays.asList(1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L, 610L,
                987L, 1597L, 2584L, 4181L, 6765L, 10946L, 17711L, 28657L, 46368L, 75025L, 121393L,
                196418L, 317811L, 514229L, 832040L, 1346269L, 2178309L, 3524578L, 5702887L,
                9227465L, 14930352L, 24157817L, 39088169L, 63245986L, 102334155L, 165580141L,
                267914296L, 433494437L, 701408733L, 1134903170L, 1836311903L, 2971215073L,
                4807526976L, 7778742049L, 12586269025L));
        ArrayList<Long> result = fibonacci.calculate(50);
        assertEquals(expectFibs, result);
    }
}
