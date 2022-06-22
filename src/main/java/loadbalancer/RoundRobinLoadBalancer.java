package loadbalancer;

import static java.util.function.Function.identity;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Thread safe
 */
public class RoundRobinLoadBalancer extends LoadBalancer {

    private final Iterator<URL> iterator;

    public RoundRobinLoadBalancer(List<URL> servers) {
        super(servers);
        iterator = Stream.generate(servers::stream)
                .flatMap(identity())
                .iterator();
    }

    @Override
    public synchronized URL getIp() {
        return iterator.next();
    }

}
