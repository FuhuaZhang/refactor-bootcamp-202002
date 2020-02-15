package cc.xpbootcamp.warmup.fibonacci;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Fibonacci {
    public ArrayList<Long> calculate(int position) {
        if(position < 1)
            throw new IllegalArgumentException();

        ArrayList<Long> fibs = new ArrayList<>();
        fibs.add(1L);
        fibs.add(1L);

        if (position >= 3)
            IntStream.rangeClosed(3, position).forEach(i -> fibs.add(fibs.get(i-2) + fibs.get(i-3)));

        return fibs;
    }
}
