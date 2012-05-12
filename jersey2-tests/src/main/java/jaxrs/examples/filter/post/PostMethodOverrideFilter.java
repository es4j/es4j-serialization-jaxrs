package jaxrs.examples.filter.post;

import java.io.IOException;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.RequestFilter;
import javax.ws.rs.ext.Provider;

/**
 * PostMethodOverrideFilter class.
 *
 * @author Santiago.Pericas-Geertsen at oracle.com
 */
@Provider
public class PostMethodOverrideFilter implements RequestFilter {

    @Override
    public void preFilter(FilterContext requestContext) throws IOException {
        if (requestContext.getRequest().getMethod().equalsIgnoreCase("POST")) {
            String override = requestContext.getRequest()
                                            .getHeaders()
                                            .getHeaderValues("X-HTTP-Method-Override")
                                            .get(0);
            if (override != null) {
                //requestContext..setMethod(override);
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }
    }
}
