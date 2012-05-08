package org.es4j.serialization.jaxrs.api.ext;

//import javax.ws.rs.container.DynamicBinder;

/**
 * Interface for message body reader interceptors that wrap around calls
 * to {@link javax.ws.rs.ext.MessageBodyReader#readFrom}.
 *
 * Message body interceptors implementing this interface must be annotated with
 * {@link javax.ws.rs.ext.Provider &#64;Provider} to be discovered by the JAX-RS
 * runtime. Message body interceptor instances may also be discovered and
 * bound {@link DynamicBinder dynamically} to particular resource methods.
 *
 * @author Santiago Pericas-Geertsen
 * @author Bill Burke
 * @author Marek Potociar (marek.potociar at oracle.com)
 * @since 2.0
 * @see MessageBodyReader
 */
public interface ReaderInterceptor {

    /**
     * Interceptor method wrapping calls to
     * {@link javax.ws.rs.ext.MessageBodyReader#readFrom}. The parameters
     * of the wrapped method called are available from <code>context</code>.
     * Implementations of this method SHOULD explicitly call
     * {@link javax.ws.rs.ext.ReaderInterceptorContext#proceed} to invoke
     * the next interceptor in the chain, and ultimately the wrapped method.
     *
     * @param context invocation context.
     * @return result of next interceptor invoked or the wrapped method if
     *         last interceptor in chain.
     * @throws java.io.IOException if an IO error arises.
     * @throws javax.ws.rs.WebApplicationException thrown by wrapped method.
     */
    Object aroundReadFrom(ReaderInterceptorContext context)
            throws java.io.IOException, org.es4j.serialization.jaxrs.api.ApplicationException;
}
