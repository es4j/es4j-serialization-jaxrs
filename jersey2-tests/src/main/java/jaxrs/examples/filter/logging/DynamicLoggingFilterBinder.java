package jaxrs.examples.filter.logging;

/*
import javax.ws.rs.GET;
import javax.ws.rs.ext.DynamicBinding;
import javax.ws.rs.container.PostMatching;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.ext.Provider;
*/
/**
 * Dynamic binder for a logging request/response {@link PostMatching post-matching}
 * filter that dynamically decides to bind the logging filter only to GET processing
 * resource methods on all subclasses of {@link MyResourceClass} and the
 * {@code MyResourceClass} itself.
 *
 * @author Santiago Pericas-Geertsen
 * @author Marek Potociar
 */
/*
@Provider
public class DynamicLoggingFilterBinder implements DynamicBinder<LoggingFilter> {

    @Override
    public LoggingFilter getBoundInstance(ResourceInfo resourceInfo) {
        if (MyResourceClass.class.isAssignableFrom(resourceInfo.getResourceClass())
                && resourceInfo.getResourceMethod().isAnnotationPresent(GET.class)) {
            return new LoggingFilter();
        }

        return null;
    }
}
*/