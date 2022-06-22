package loadbalancer;

import java.net.URL;
import java.util.List;

public abstract class LoadBalancer {

    // 1,2,3
    protected final List<URL> servers;
    // servers.add(4)

    protected LoadBalancer(List<URL> servers) {
        this.servers = List.copyOf(servers);
    }

    public abstract URL getIp();
}


//random

// random from range [2-0,3-1,1-2]
// roundrobbin
// getip -0 , getip - 1, getip - 2, getip - 0 , getip - 1 ,


// getip -0 , getip - 1, getip - 2, getip - 0 , getip - 1 ,

