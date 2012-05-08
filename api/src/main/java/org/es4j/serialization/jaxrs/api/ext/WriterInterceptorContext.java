package org.es4j.serialization.jaxrs.api.ext;

import java.io.IOException;
import java.io.OutputStream;
import org.es4j.serialization.jaxrs.api.core.MultivaluedMap;

/**
 * Context class used by {@link javax.ws.rs.ext.WriterInterceptor}
 * to intercept calls to {@link javax.ws.rs.ext.MessageBodyWriter#writeTo}.
 * The getters and setters in this context class correspond to the
 * parameters of the intercepted method.
 *
 * @author Santiago Pericas-Geertsen
 * @author Bill Burke
 * @since 2.0
 * @see WriterInterceptor
 * @see MessageBodyWriter
 */
public interface WriterInterceptorContext extends InterceptorContext {

    /**
     * Proceed to the next interceptor in the chain.
     *
     * Interceptors MUST explicitly call this method to continue the execution
     * chain; the call to this method in the last interceptor of the chain will
     * invoke {@link javax.ws.rs.ext.MessageBodyWriter#writeTo} method.
     *
     * @throws IOException if an IO exception arises.
     */
    void proceed() throws IOException;

    /**
     * Get object to be written as HTTP entity.
     *
     * @return object to be written as HTTP entity.
     */
    Object getEntity();

    /**
     * Update object to be written as HTTP entity.
     *
     * @param entity new object to be written.
     */
    void setEntity(Object entity);

    /**
     * Get the output stream for the object to be written.
     *
     * @return output stream for the object to be written.
     */
    OutputStream getOutputStream();

    /**
     * Update the output stream for the object to be written.
     *
     * @param os new output stream for the object to be written.
     */
    public void setOutputStream(OutputStream os);

    /**
     * Get mutable map of HTTP headers.
     *
     * @return map of HTTP headers.
     */
    MultivaluedMap<String, Object> getHeaders();
}
