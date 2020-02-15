package cc.xpbootcamp.warmup.fibonacci;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Fibonacci {
    public long calculate(int position) {
        if(position < 1)
            throw new IllegalArgumentException();

        if (position == 1 || position == 2)
            return 1;
        else
            return calculate(position-1) + calculate(position-2);
    }

    public long[] output() {
        long[] fibs = new long[50];
        IntStream.rangeClosed(1, 50).forEach(i -> fibs[i - 1] = calculate(i));
        System.out.println(Arrays.toString(fibs));
        return fibs;
    }
}
