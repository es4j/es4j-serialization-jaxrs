package org.glassfish.jersey.tests.e2e.common;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import javax.xml.bind.annotation.XmlRootElement;

import org.glassfish.jersey.media.json.JsonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test case for unsupported media type.
 *
 * @author Miroslav Fuksa (miroslav.fuksa at oracle.com)
 *
 */
public class MessageBodyReaderUnsupportedTest extends JerseyTest {

    @Override
    protected ResourceConfig configure() {
        // JsonJaxbModule must not be registered in the application for this test case.
        return new ResourceConfig(Resource.class);
    }

    /**
     * Send request to with application/json content to server where JsonJaxbModule is not registered. UNSUPPORTED_MEDIA_TYPE
     * should be returned.
     */
    @Test
    public void testUnsupportedMesageBodyReader() {
        client().configuration().enable(new JsonFeature());
        TestEntity entity = new TestEntity("testEntity");
        Response response = target().path("test").request("application/json").post(Entity.json(entity));

        // JsonJaxbModule is not registered on the server and therefore the server should return UNSUPPORTED_MEDIA_TYPE
        assertEquals(Status.UNSUPPORTED_MEDIA_TYPE.getStatusCode(), response.getStatus());
        assertFalse(Resource.methodJsonCalled);
        String responseEntity = response.readEntity(String.class);
        assertTrue((responseEntity == null) || (responseEntity.length() == 0));
    }

    /**
     * Test Resource class.
     *
     * @author Miroslav Fuksa (miroslav.fuksa at oracle.com)
     *
     */
    @Path("test")
    public static class Resource {

        private static boolean methodJsonCalled;

        @POST
        @Produces("application/json")
        @Consumes("application/json")
        public TestEntity processJsonAndProduceNullAsJson(TestEntity entity) {
            methodJsonCalled = true;
            return null;
        }
    }

    /**
     * Test bean.
     *
     * @author Miroslav Fuksa (miroslav.fuksa at oracle.com)
     *
     */
    @XmlRootElement
    public static class TestEntity {

        private String value;

        public String getValue() {
            return value;
        }

        public TestEntity(String value) {
            super();
            this.value = value;
        }
    }
}
