package org.es4j.misc.jaxrs.api.container;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.es4j.serialization.jaxrs.api.NameBinding;

/**
 * Global binding annotation that can be applied to a {@link ContainerRequestFilter
 * container request filter} or a {@link ContainerResponseFilter container response
 * filter} to indicate that such filter should be applied globally on all resources
 * in the application but depends on a matched resource information being available.
 * <p />
 * The JAX-RS runtime will apply the filters marked with the {@code @PostMatching}
 * annotation globally to all resources, but only in case the incoming request
 * has been matched to a particular resource method. In case the request has not
 * been matched, the filter implementations annotated with the {@code @PostMatching}
 * annotation will not be applied.
 *
 * @author Marek Potociar (marek.potociar at oracle.com)
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@NameBinding
public @interface PostMatching {
}
