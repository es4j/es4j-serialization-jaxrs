package org.es4j.serialization.jaxrs.api.ext;

//import javax.ws.rs.core.Response;
//import org.ex4j.serialization.api.jaxrs.Response;


/**
 * Contract for a provider that maps Java exceptions to
 * {@link javax.ws.rs.core.Response}. An implementation of this interface must
 * be annotated with {@link Provider}.
 *
 * @param <E> exception type supported by the provider.
 *
 * @author Paul Sandoz
 * @author Marc Hadley
 * @see Provider
 * @see javax.ws.rs.core.Response
 * @since 1.0
 */
public interface ExceptionMapper<E extends Throwable> {

    /**
     * Map an exception to a {@link javax.ws.rs.core.Response}. Returning
     * {@code null} results in a {@link javax.ws.rs.core.Response.Status#NO_CONTENT}
     * response. Throwing a runtime exception results in a
     * {@link javax.ws.rs.core.Response.Status#INTERNAL_SERVER_ERROR} response
     * @param exception the exception to map to a response
     * @return a response mapped from the supplied exception
     */
    Object/*Response*/ toResponse(E exception);
}
