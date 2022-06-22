package loadbalancer;

import static loadbalancer.common.URLBuilder.url;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import java.util.List;

public class WeightedRoundRobinLoadBalancerTest {

    @Test
    void should_return_nodes_sequentially_by_their_count() {
        var nodeWeights = mock(NodeWeights.class);
        when(nodeWeights.asList()).thenReturn(List.of(
                        url("http://2"),
                        url("http://2"),
                        url("http://1"),
                        url("http://2")
                )
        );
        var weightedRoundRobinLoadBalancer = new WeightedRoundRobinLoadBalancer(nodeWeights);

        assertThat(weightedRoundRobinLoadBalancer.getIp()).isEqualTo(url("http://2"));
        assertThat(weightedRoundRobinLoadBalancer.getIp()).isEqualTo(url("http://2"));
        assertThat(weightedRoundRobinLoadBalancer.getIp()).isEqualTo(url("http://1"));
        assertThat(weightedRoundRobinLoadBalancer.getIp()).isEqualTo(url("http://2"));
    }
}