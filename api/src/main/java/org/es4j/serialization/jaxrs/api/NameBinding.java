package org.es4j.serialization.jaxrs.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Meta-annotation used to create name binding annotations for filters
 * and interceptors. Name binding via annotations
 * is only supported as part of the Server API. In name binding,
 * an annotation is defined using this meta-annotation and it is
 * then used to decorate both the filter or interceptor class and
 * the resource method or class that it applies to.
 *
 * <p>See <a href="http://jcp.org/en/jsr/detail?id=339">JAX-RS 2.0: The
 * Java API for RESTful Web Services</a> specification for examples
 * on how to use this meta-annotation for name binding of filters
 * and interceptors.</p>
 *
 * @author Santiago Pericas-Geertsen
 * @since 2.0
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NameBinding {
}
