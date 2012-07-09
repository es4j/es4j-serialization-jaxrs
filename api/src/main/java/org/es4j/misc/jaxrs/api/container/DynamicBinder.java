package org.es4j.misc.jaxrs.api.container;

import org.es4j.serialization.jaxrs.api.ext.ReaderInterceptor;
import org.es4j.serialization.jaxrs.api.ext.WriterInterceptor;

/**
 * A dynamic ({@link PostMatching post-matching}) filter or interceptor binding
 * provider.
 *
 * Dynamic binding provider is used by JAX-RS runtime to provide a the filter or
 * interceptor that shall be applied to a particular resource class and method and
 * overrides any annotation-based binding definitions defined on the returned
 * resource filter or interceptor instance.
 * <p />
 * Providers implementing this interface MUST be annotated with
 * {@link javax.ws.rs.ext.Provider &#64;Provider} annotation to be discovered
 * by JAX-RS runtime. This type of providers is supported only as part of the
 * Server API.
 *
 * @param <T> Filter or interceptor type provided by the dynamic binder.
 *
 * @author Santiago Pericas-Geertsen
 * @author Bill Burke
 * @author Marek Potociar
 *
 * @since 2.0
 * @see javax.ws.rs.NameBinding
 */
public interface DynamicBinder<T> {

    /**
     * Get the filter or interceptor instance that should be bound to the particular
     * resource method.
     *
     * The returned instance is expected to return an instance implementing one
     * or more of the following interfaces:
     * <ul>
     *     <li>{@link ContainerRequestFilter}</li>
     *     <li>{@link ContainerResponseFilter}</li>
     *     <li>{@link ReaderInterceptor}</li>
     *     <li>{@link WriterInterceptor}</li>
     * </ul>
     * A returned instance that does not implement any of the interfaces above
     * is ignored and a {@link java.util.logging.Level#WARNING warning} message
     * is logged.
     * <p />
     * The method is called during a (sub)resource method discovery phase (typically
     * once per each discovered (sub)resource method) to return a filter instance
     * that should be bound to a particular (sub)resource method identified by the
     * supplied {@link ResourceInfo resource information}.
     *
     * @param resourceInfo resource class and method information.
     * @return a filter or interceptor instance that should be dynamically bound
     *     to the (sub)resource method or {@code null} otherwise.
     */
    public T getBoundInstance(ResourceInfo resourceInfo);
}
