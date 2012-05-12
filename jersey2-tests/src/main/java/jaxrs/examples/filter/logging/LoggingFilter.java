package jaxrs.examples.filter.logging;

import java.io.IOException;
/*
import javax.ws.rs.BindingPriority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
*/
/**
 * Example of a logging resource filter (server-side).
 *
 * @author Santiago Pericas-Geertsen
 * @author Marek Potociar (marek.potociar at oracle.com)
 */
/*
@Provider
@Logged // name-bound => resource filter
@BindingPriority(BindingPriority.USER)
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        log(requestContext);
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        log(responseContext);
    }

    private static void log(ContainerRequestContext context) {
        // implementation goes here
    }

    private static void log(ContainerResponseContext context) {
        // implementation goes here
    }
}
*/