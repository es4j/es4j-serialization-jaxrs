package org.es4j.serialization.jaxrs.api.ext;

//import javax.ws.rs.container.DynamicBinder;

/**
 * Interface for message body writer interceptors that wrap around calls
 * to {@link javax.ws.rs.ext.MessageBodyWriter#writeTo}.
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
 * @see MessageBodyWriter
 */
public interface WriterInterceptor {

    /**
     * Interceptor method wrapping calls to
     * {@link javax.ws.rs.ext.MessageBodyWriter#writeTo}. The parameters
     * of the wrapped method called are available from <code>context</code>.
     * Implementations of this method SHOULD explicitly call
     * {@link javax.ws.rs.ext.WriterInterceptorContext#proceed} to invoke
     * the next interceptor in the chain, and ultimately the wrapped method.
     *
     * @param context invocation context.
     * @throws java.io.IOException if an IO error arises.
     * @throws javax.ws.rs.WebApplicationException thrown by wrapped method.
     */
    void aroundWriteTo(WriterInterceptorContext context)
            throws java.io.IOException, org.es4j.serialization.jaxrs.api.ApplicationException;
}
