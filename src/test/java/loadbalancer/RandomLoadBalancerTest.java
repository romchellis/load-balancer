package loadbalancer;

import static loadbalancer.common.URLBuilder.url;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class RandomLoadBalancerTest {


    //TDD approach
    // unit test
    // acceptance on my class
    // mock random algorithm
    @Test
    void should_get_expected_ip() {
        var urls = getTestUrls();
        var randomBalancer = new RandomLoadBalancer(urls, () -> 0);
        var expectedAddress = url("http://127.0.0.1:8080");

        var actualURL = randomBalancer.getIp();

        assertThat(actualURL).isEqualTo(expectedAddress);
    }

    //we have to check whether list contains specified url
    @Test
    void should_return_url_containing_in_list() {
        var urls = getTestUrls();
        var randomBalancer = new RandomLoadBalancer(urls, () -> new Random().nextInt(urls.size()));

        var actualURL = randomBalancer.getIp();

        assertThat(urls).contains(actualURL);
    }

    private ArrayList<URL> getTestUrls() {
        var urls = new ArrayList<URL>();
        urls.add(url("http://127.0.0.1:8080"));
        urls.add(url("http://127.0.0.2:8080"));
        urls.add(url("http://127.0.0.3:8080"));
        return urls;
    }

}