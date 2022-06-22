package loadbalancer;

import java.net.URL;
import java.util.List;
import java.util.function.Supplier;

/**
 * Uses thread local random for random generation
 */
public class RandomLoadBalancer extends LoadBalancer {

    private final Supplier<Integer> randomAlgorithm;

    public RandomLoadBalancer(List<URL> servers) {
        this(servers, new ThreadLocalRandomGenerator(servers.size()));
    }

    /**
     * for test purposes only
     */
    RandomLoadBalancer(List<URL> servers,
                       Supplier<Integer> randomAlgorithm) {
        super(servers);
        this.randomAlgorithm = randomAlgorithm;
    }

    @Override
    public URL getIp() {
        final var index = randomAlgorithm.get();
        return servers.get(index);
    }
}
