package jaxrs.examples.client.custom;

import java.net.URI;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.ws.rs.client.Client;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.client.Configuration;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Marek Potociar (marek.potociar at oracle.com)
 */
public final class ThrottledClient implements Client {

    private final BlockingQueue<FilterContext> requestQueue;

    public ThrottledClient() {
        this(10);
    }

    public ThrottledClient(int queueCapacity) {
        this.requestQueue = new ArrayBlockingQueue<FilterContext>(queueCapacity);
    }

    public ThrottledClient(Configuration configuration, int queueCapacity) {
        this(queueCapacity);

        configuration().update(configuration);
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Target target(String uri) throws IllegalArgumentException, NullPointerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Target target(URI uri) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Target target(UriBuilder uriBuilder) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Target target(Link link) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Configuration configuration() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Invocation invocation(Link link) throws NullPointerException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Invocation invocation(Link link, Entity<?> entity) throws NullPointerException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
