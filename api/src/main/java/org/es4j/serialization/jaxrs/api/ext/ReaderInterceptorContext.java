package org.es4j.serialization.jaxrs.api.ext;

import java.io.IOException;
import java.io.InputStream;
import org.es4j.serialization.jaxrs.api.core.MultivaluedMap;

/**
 * Context class used by {@link javax.ws.rs.ext.ReaderInterceptor}
 * to intercept calls to (@link javax.ws.rs.ext.MessageBodyReader#readFrom}.
 * The getters and setters in this context class correspond to the
 * parameters of the intercepted method.
 *
 * @author Santiago Pericas-Geertsen
 * @author Bill Burke
 * @since 2.0
 * @see ReaderInterceptor
 * @see MessageBodyReader
 */
public interface ReaderInterceptorContext extends InterceptorContext {

    /**
     * Proceed to the next interceptor in the chain. Return the result of the
     * next interceptor invoked. Interceptors MUST explicitly call this method
     * to continue the execution chain; the call to this method in the
     * last interceptor of the chain will invoke
     * {@link javax.ws.rs.ext.MessageBodyReader#readFrom}.
     *
     * @return result of next interceptor invoked
     * @throws IOException if an IO error arises
     */
    Object proceed() throws IOException;

    /**
     * Get the input stream of the object to be read.
     *
     * @return input stream of the object to be read
     */
    InputStream getInputStream();

    /**
     * Update the input stream of the object to be read.
     * For example, by wrapping it with another input stream
     *
     * @param is new input stream
     */
    void setInputStream(InputStream is);

    /**
     * Get mutable map of HTTP headers.
     *
     * @return map of HTTP headers
     */
    MultivaluedMap<String, String> getHeaders();
}
