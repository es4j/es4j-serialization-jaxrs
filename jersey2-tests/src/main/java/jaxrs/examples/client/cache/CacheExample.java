package jaxrs.examples.client.cache;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;
import javax.ws.rs.ext.ClientFactory;

/**
 * @author Bill Burke
 * @author Marek Potociar
 */
public class CacheExample {

    public void cacheExample() {
        Client client = ClientFactory.newClient();
        client.configuration().register(CachingFeature.class);

        Target resource = client.target("http://example.com/foo/bar.txt");

        String text = resource.request("text/plain").get(String.class);
        String second = resource.request("text/plain").get(String.class);

        System.out.println(text);
        System.out.println(second);
    }
}