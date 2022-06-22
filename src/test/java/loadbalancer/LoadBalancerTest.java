package loadbalancer;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;

public class LoadBalancerTest {

    @Test
    void should_throw_exception_if_list_null() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new MockLoadBalancer(null));
    }

    static class MockLoadBalancer extends LoadBalancer {

        protected MockLoadBalancer(List<URL> servers) {
            super(servers);
        }

        @Override
        public URL getIp() {
            return null;
        }
    }
}