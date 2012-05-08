package org.es4j.serialization.jaxrs.api.container;

import java.io.IOException;

/**
 * An extension interface implemented by container response filters.
 *
 * By default, i.e. if no {@link javax.ws.rs.NameBinding name binding} is applied
 * to the filter implementation class, the {@code filter(...)} method is called
 * globally for all responses, i.e. even in case an actual resource matching
 * failed or has not been performed at all.
 * If there is a {@link javax.ws.rs.NameBinding &#64;NameBinding} annotation
 * applied to the filter, the filter will be executed only for responses
 * created for requests that were successfully matched to a resource method.
 * <p />
 * Implement a name-bound response filter in cases when you want limit the filter
 * functionality to a particular resource or resource method or if you depend on
 * a matched resource information in your filter processing. In other cases,
 * when the filter should be applied globally to all responses, even in those
 * cases when a request has not been matched to a resource implement an unbound
 * response filter.
 * <p />
 * Filters implementing this interface must be annotated with
 * {@link javax.ws.rs.ext.Provider &#64;Provider} to be discovered by the JAX-RS
 * runtime. Container response filter instances may also be discovered and
 * bound {@link DynamicBinder dynamically} to particular resource methods.
 *
 * @author Marek Potociar
 * @author Santiago Pericas-Geertsen
 *
 * @since 2.0
 *
 * @see javax.ws.rs.container.PostMatching
 * @see javax.ws.rs.container.ContainerRequestFilter
 */
public interface ContainerResponseFilter {

    /**
     * Filter method called after a response has been provided for a request
     * (either by a {@link ContainerRequestFilter request filter} or by a
     * matched resource method.
     *
     * By default, i.e. if no {@link javax.ws.rs.NameBinding name binding} is applied
     * to the filter implementation class, the {@code filter(...)} method is called
     * globally for all responses, i.e. even in case an actual resource matching
     * failed or has not been performed at all.
     * If there is a {@link javax.ws.rs.NameBinding &#64;NameBinding} annotation
     * applied to the filter, the filter will be executed only for responses
     * created for requests that were successfully matched to a resource method.
     * <p />
     * Filters in the filter chain are ordered according to their binding
     * priority (see {@link javax.ws.rs.BindingPriority}).
     *
     * @param requestContext request context.
     * @param responseContext response context.
     * @throws IOException if an I/O exception occurs.
     *
     * @see javax.ws.rs.container.PostMatching
     */
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException;
}
