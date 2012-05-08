package org.es4j.serialization.jaxrs.api.ext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;

import org.es4j.serialization.jaxrs.api.core.MediaType;

/**
 * Context shared by message body interceptors that can be used to wrap
 * calls to {@link javax.ws.rs.ext.MessageBodyReader#readFrom} and
 * {@link javax.ws.rs.ext.MessageBodyWriter#writeTo}. The getters and
 * setters in this context class correspond to the parameters in
 * the aforementioned methods.
 *
 * @author Santiago Pericas-Geertsen
 * @author Bill Burke
 * @since 2.0
 * @see ReaderInterceptor
 * @see WriterInterceptor
 * @see ReaderInterceptorContext
 * @see WriterInterceptorContext
 */
public interface InterceptorContext {

    /**
     * Get a mutable map of request-scoped properties that can be used for communication
     * between different request/response processing components.
     *
     * May be empty, but MUST never be {@code null}. In the scope of a single
     * request/response processing a same property map instance is shared by the
     * following methods:
     * <ul>
     *     <li>{@link javax.ws.rs.container.ContainerRequestContext#getProperties() }</li>
     *     <li>{@link javax.ws.rs.container.ContainerResponseContext#getProperties() }</li>
     *     <li>{@link javax.ws.rs.client.ClientRequestContext#getProperties() }</li>
     *     <li>{@link javax.ws.rs.client.ClientResponseContext#getProperties() }</li>
     *     <li>{@link javax.ws.rs.ext.InterceptorContext#getProperties() }</li>
     * </ul>
     *
     * A request-scoped property is an application-defined property that may be
     * added, removed or modified by any of the components (user, filter,
     * interceptor etc.) that participate in a given request/response processing
     * flow.
     * <p />
     * On the client side, this property map is initialized by calling
     * {@link javax.ws.rs.client.Configuration#setProperties(java.util.Map) } or
     * {@link javax.ws.rs.client.Configuration#setProperty(java.lang.String, java.lang.Object) }
     * on the configuration object associated with the corresponding
     * {@link javax.ws.rs.client.Invocation request invocation}.
     * <p />
     * On the server side, specifying the initial values is implementation-specific.
     * <p />
     * If there are no initial properties set, the request-scoped property map is
     * initialized to an empty map.
     *
     * @return a mutable request-scoped property map.
     * @see javax.ws.rs.client.Configuration
     */
    Map<String, Object> getProperties();

    /**
     * Get annotations on the formal declaration of the resource
     * method parameter that is the target of the message body
     * conversion. As part of the client API, this method will
     * return null.
     *
     * @return annotations on the resource method parameter
     */
    Annotation[] getAnnotations();

    /**
     * Update annotations on the formal declaration of the resource
     * method parameter that is the target of the message body conversion.
     * Calling this method has no effect in the client API.
     *
     * @param annotations annotations for the resource method parameter
     */
    void setAnnotations(Annotation[] annotations);

    /**
     * Get Java type supported by corresponding message body provider.
     *
     * @return java type supported by provider
     */
    Class<?> getType();

    /**
     * Update Java type before calling message body provider.
     *
     * @param type java type for provider
     */
    void setType(Class<?> type);

    /**
     * Get the type of the object to be produced or written.
     *
     * @return type of object produced or written
     */
    Type getGenericType();

    /**
     * Update type of the object to be produced or written.
     *
     * @param genericType new type for object
     */
    void setGenericType(Type genericType);

    /**
     * Get media type of HTTP entity.
     *
     * @return media type of HTTP entity
     */
    MediaType getMediaType();

    /**
     * Update media type of HTTP entity.
     *
     * @param mediaType new type for HTTP entity
     */
    void setMediaType(MediaType mediaType);
}
