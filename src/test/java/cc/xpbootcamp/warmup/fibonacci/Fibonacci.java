package cc.xpbootcamp.warmup.fibonacci;

import java.util.ArrayList;

public class Fibonacci {
    public int calculate(int position) {
        if(position < 1)
            throw new IllegalArgumentException();

        ArrayList<Integer> fibs = new ArrayList<>();
        fibs.add(0);
        fibs.add(1);
        fibs.add(fibs.get(1)+fibs.get(0));

        return fibs.get(position);
    }
}
