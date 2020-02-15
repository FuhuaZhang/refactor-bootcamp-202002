package cc.xpbootcamp.warmup.fibonacci;

import java.util.ArrayList;

public class Fibonacci {
    public int calculate(int position) {
        if(position < 1)
            throw new IllegalArgumentException();

        if (position == 1 || position == 2)
            return 1;
        else
            return calculate(position-1) + calculate(position-2);

    }
}
