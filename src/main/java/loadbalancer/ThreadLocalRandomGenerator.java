package loadbalancer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class ThreadLocalRandomGenerator implements Supplier<Integer> {

    private final int upperBound;

    public ThreadLocalRandomGenerator(int upperBound) {
        this.upperBound = upperBound;
    }

    @Override
    public Integer get() {
        var current = ThreadLocalRandom.current();
        return current.nextInt(0, upperBound);
    }
}
