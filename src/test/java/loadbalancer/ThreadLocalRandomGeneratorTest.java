package loadbalancer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ThreadLocalRandomGeneratorTest {

    private static final int upperBound = 10;

    @Test
    void generated_number_should_be_in_range_between_zero_and_upper_bound() {
        var threadLocalRandomGenerator = new ThreadLocalRandomGenerator(upperBound);

        var actual = threadLocalRandomGenerator.get();

        assertThat(actual).isBetween(0, upperBound);
    }
}