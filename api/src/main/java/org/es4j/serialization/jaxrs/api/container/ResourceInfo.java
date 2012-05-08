package org.es4j.serialization.jaxrs.api.container;

import java.lang.reflect.Method;

/**
 * An injectable class to access the resource class and resource method
 * matched by the current request. Methods in this class MAY return
 * <code>null</code> if a resource class and method have not been matched,
 * e.g. in a standalone, pre-matching {@link ContainerRequestFilter} that was
 * not provided by a post-matching {@link PostMatching}.
 *
 * @author Santiago Pericas-Geertsen
 * @since 2.0
 */
public interface ResourceInfo {

    /**
     * Get the resource method that is the target of a request,
     * or <code>null</code> if this information is not available.
     *
     * @return resource method instance or null
     * @see #getResourceClass()
     */
    Method getResourceMethod();

    /**
     * Get the resource class that is the target of a request,
     * or <code>null</code> if this information is not available.
     *
     * @return resource class instance or null
     * @see #getResourceMethod()
     */
    Class<?> getResourceClass();
}
