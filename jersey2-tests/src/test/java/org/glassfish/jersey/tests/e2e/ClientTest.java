package org.glassfish.jersey.tests.e2e;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.InvocationException;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marek Potociar (marek.potociar at oracle.com)
 */
public class ClientTest extends JerseyTest {

    @Path("helloworld")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public static class HelloWorldResource {

        private static final String MESSAGE = "Hello world!";

        @GET
        public String getClichedMessage() {
            return MESSAGE;
        }
    }

    @Override
    protected ResourceConfig configure() {
        return new ResourceConfig(HelloWorldResource.class);
    }

    @Test
    public void testAccesingHelloworldResource() {
        Target resource = target().path("helloworld");
        Response r = resource.request().get();
        assertEquals(200, r.getStatus());

        String responseMessage = resource.request().get(String.class);
        assertEquals(HelloWorldResource.MESSAGE, responseMessage);
    }

    @Test
    public void testAccesingMissingResource() {
        Target missingResource = target().path("missing");
        Response r = missingResource.request().get();
        assertEquals(404, r.getStatus());


        try {
            missingResource.request().get(String.class);
        } catch (InvocationException ex) {
            assertEquals(404, ex.getResponse().getStatus());
            return;
        }

        fail("Expected InvocationException has not been thrown.");
    }
}
