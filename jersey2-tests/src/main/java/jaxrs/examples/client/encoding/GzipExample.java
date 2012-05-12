package jaxrs.examples.client.encoding;

import jaxrs.examples.filter.compression.GzipEntityInterceptor;

import javax.ws.rs.client.Target;
import javax.ws.rs.ext.ClientFactory;
import javax.ws.rs.client.Entity;


/**
 * @author Bill Burke
 * @author Marek Potociar
 */
public class GzipExample {

    public void gzipExample() {
        Target target = ClientFactory.newClient().target("http://example.com/foo/bar.txt");
        target.configuration().register(GzipEntityInterceptor.class);

        // getting a gzip encoded body
        String body = target.request("text/plain").get(String.class);

        // send a gzip encoded body
        target.request().header("Content-Encoding", "gzip").post(Entity.text(body));
    }
}