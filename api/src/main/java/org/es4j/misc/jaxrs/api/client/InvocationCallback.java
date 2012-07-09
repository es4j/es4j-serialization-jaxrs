package org.es4j.misc.jaxrs.api.client;

/**
 * Callback that can be implemented to receive the asynchronous processing
 * events from the invocation processing.
 *
 * @param <RESPONSE> response type. It can be either a general-purpose
 *     {@link javax.ws.rs.core.Response} or the anticipated response entity
 *     type.
 *
 * @author Marek Potociar
 * @since 2.0
 */
public interface InvocationCallback<RESPONSE> {

    /**
     * Called when the invocation was successfully completed. Note that this does
     * not necessarily mean the response has bean fully read. This depends on the
     * expected invocation callback response type.
     *
     * @param response response data.
     */
    public void completed(RESPONSE response);

    /**
     * Called when the invocation has failed for any reason.
     *
     * @param error contains failure details.
     */
    public void failed(InvocationException error);
}
