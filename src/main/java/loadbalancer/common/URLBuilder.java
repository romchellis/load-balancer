package loadbalancer.common;

import java.net.MalformedURLException;
import java.net.URL;

import loadbalancer.exception.ValidationException;

public class URLBuilder {

    public static URL url(String address) {
        try {
            return new URL(address);
        } catch (MalformedURLException e) {
            throw new ValidationException("URL cannot be constructed because of: " + e);
        }
    }

}
