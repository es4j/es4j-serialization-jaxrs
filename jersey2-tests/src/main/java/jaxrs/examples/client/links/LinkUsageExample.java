package jaxrs.examples.client.links;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ClientFactory;

/**
 *
 * @author Marek Potociar
 */
/*
public class LinkUsageExample {

    public void testCLientSideLinks() {
        Client client = ClientFactory.newClient();

        Response current = client.target("http://examples.jax-rs-spec.com/current")
                .request(MediaType.APPLICATION_XML).get();

        Response next = client.target(current.getLink("next"))
                .request(MediaType.APPLICATION_XML).get();
    }
}
*/
