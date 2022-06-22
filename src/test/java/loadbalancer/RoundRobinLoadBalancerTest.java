package loadbalancer;

import static loadbalancer.common.URLBuilder.url;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

public class RoundRobinLoadBalancerTest {

    @Test
    void should_return_urls_in_list_sequentially() {
        var roundRobinLoadBalancer = new RoundRobinLoadBalancer(
                List.of(url("http://1"), url("http://2"))
        );

        var firstUrl = roundRobinLoadBalancer.getIp();
        var secondUrl = roundRobinLoadBalancer.getIp();
        var thirdUrl = roundRobinLoadBalancer.getIp();

        assertThat(firstUrl).isEqualTo(url("http://1"));
        assertThat(secondUrl).isEqualTo(url("http://2"));
        assertThat(thirdUrl).isEqualTo(url("http://1"));
    }

}