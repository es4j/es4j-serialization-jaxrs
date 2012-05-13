package org.es4j.misc.jaxrs.api.container;

import java.io.IOException;

/**
 * An extension interface implemented by container request filters.
 *
 * By default, i.e. if no {@link javax.ws.rs.NameBinding name binding} is applied
 * to the filter implementation class, the {@code filter(...)} method is called
 * at the <i>pre-match</i> extension point, i.e. prior to the actual resource
 * matching takes place in the JAX-RS runtime.
 * If there is a {@link javax.ws.rs.NameBinding &#64;NameBinding} annotation
 * applied to the filter, the filter will be executed at the <i>post-match</i>
 * extension point, i.e. after a request was successfully matched with a
 * resource method.
 * <p />
 * Use a pre-match request filter to update the input to the JAX-RS matching algorithm,
 * e.g., the HTTP method, Accept header, return cached responses etc. Otherwise,
 * the use of a request filter invoked at the <i>post-match</i> extension point
 * (after a successful resource method matching) is recommended.
 * <p />
 * Filters implementing this interface must be annotated with
 * {@link javax.ws.rs.ext.Provider &#64;Provider} to be discovered by the JAX-RS
 * runtime. Container request filter instances may also be discovered and
 * bound {@link DynamicBinder dynamically} to particular resource methods.
 *
 * @author Marek Potociar
 * @author Santiago Pericas-Geertsen
 *
 * @since 2.0
 *
 * @see javax.ws.rs.container.PostMatching
 * @see javax.ws.rs.container.ContainerResponseFilter
 */
public interface ContainerRequestFilter {

    /**
     * Filter method called before a request has been dispatched to a resource.
     *
     * By default, i.e. if no {@link javax.ws.rs.NameBinding name binding} is applied
     * to the filter implementation class, the {@code filter(...)} method is called
     * at the <i>pre-match</i> extension point, i.e. prior to the actual resource
     * matching takes place in the JAX-RS runtime.
     * If there is a {@link javax.ws.rs.NameBinding &#64;NameBinding} annotation
     * applied to the filter, the filter will be executed at the <i>post-match</i>
     * extension point, i.e. after a request was successfully matched with a
     * resource method.
     * <p />
     * Filters in the filter chain are ordered according to their binding
     * priority (see {@link javax.ws.rs.BindingPriority}). If a request filter
     * produces a response by calling {@link ContainerRequestContext#abortWith}
     * method, the execution of the (either pre-match or post-match) request filter
     * chain is stopped and the response is passed to the corresponding response
     * filter chain (either pre-match or post-match). For example, a pre-match
     * caching filter may produce a response in this way, which would effectively
     * skip any post-match request filters as well as post-match response filters.
     * Note however that a responses produced in this manner would still be processed
     * by the pre-match response filter chain.
     *
     * @param requestContext request context.
     * @throws IOException if an I/O exception occurs.
     *
     * @see javax.ws.rs.container.PostMatching
     */
    public void filter(ContainerRequestContext requestContext) throws IOException;
}
