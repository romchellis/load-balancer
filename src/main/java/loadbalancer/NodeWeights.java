package loadbalancer;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NodeWeights {

    private final Map<URL, Integer> nodeToCount;

    public NodeWeights(Map<URL, Integer> nodeToCount) {
        this.nodeToCount = nodeToCount;
    }

    public List<URL> asList() {
        var list = new ArrayList<URL>();
        nodeToCount.entrySet().forEach(entry -> {
            URL key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                list.add(key);
            }
        });
        return list;
    }
}
