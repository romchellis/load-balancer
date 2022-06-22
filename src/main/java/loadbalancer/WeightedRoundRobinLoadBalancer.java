package loadbalancer;


public class WeightedRoundRobinLoadBalancer extends RoundRobinLoadBalancer {

    public WeightedRoundRobinLoadBalancer(NodeWeights nodeWeights) {
        super(nodeWeights.asList());
    }
}
