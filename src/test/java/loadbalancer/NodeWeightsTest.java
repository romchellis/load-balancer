package loadbalancer;

import static loadbalancer.common.URLBuilder.url;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class NodeWeightsTest {

    @Test
    void should_return_list_with_repeating_nodes_by_their_count() {
        NodeWeights nodeWeights = new NodeWeights(
                Map.of(
                        url("http://2"), 2,
                        url("http://1"), 1
                ));

        List<URL> urls = nodeWeights.asList();

        assertThat(urls).containsExactlyInAnyOrder(
                url("http://2"),
                url("http://2"),
                url("http://1")
        );
    }
}