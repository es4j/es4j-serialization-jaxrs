package jaxrs.examples.filter.caching;

import java.io.IOException;

import javax.ws.rs.BindingPriority;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.RequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * ServerCachingFilter class.
 *
 * @author Santiago Pericas-Geertsen
 */
@Provider
@BindingPriority(BindingPriority.USER)
public class ServerCachingFilter implements RequestFilter {

    @Override
    public void preFilter(FilterContext requestContext) throws IOException {
        Response.ResponseBuilder res = getCachedResponse(requestContext);
        if (res != null) {
            // stop the filter chain
            throw new WebApplicationException(res.build());
        }
    }

    private Response.ResponseBuilder getCachedResponse(FilterContext requestContext) {
        // implemetation goes here
        return null;
    }
}
