package org.es4j.serialization.jaxrs.api.ext;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import org.es4j.serialization.jaxrs.api.core.MediaType;
import org.es4j.serialization.jaxrs.api.core.MultivaluedMap;

/**
 * Contract for a provider that supports the conversion of a stream to a
 * Java type. To add a <code>MessageBodyReader</code> implementation, annotate the
 * implementation class with <code>@Provider</code>.
 *
 * A <code>MessageBodyReader</code> implementation may be annotated
 * with {@link javax.ws.rs.Consumes} to restrict the media types for which it will
 * be considered suitable.
 *
 * @param <T> Java type supported by the provider
 *
 * @author Paul Sandoz
 * @author Marc Hadley
 * @see Provider
 * @see javax.ws.rs.Consumes
 * @since 1.0
 */
public interface MessageBodyReader<T> {

    /**
     * Ascertain if the MessageBodyReader can produce an instance of a
     * particular type. The {@code type} parameter gives the
     * class of the object that should be produced, the {@code genericType} parameter
     * gives the {@link java.lang.reflect.Type java.lang.reflect.Type} of the object
     * that should be produced.
     * E.g. if the object to be produced is List&lt;String&gt;, the {@code type} parameter
     * will be {@code java.util.List} and the {@code genericType} parameter will be
     * {@link java.lang.reflect.ParameterizedType java.lang.reflect.ParameterizedType}.
     *
     * @param type the class of object to be produced.
     * @param genericType the type of object to be produced. E.g. if the
     *     message body is to be converted into a method parameter, this will be
     *     the formal type of the method parameter as returned by
     *     {@code Method.getGenericParameterTypes}.
     * @param annotations an array of the annotations on the declaration of the
     *     artifact that will be initialized with the produced instance. E.g. if the
     *     message body is to be converted into a method parameter, this will be
     *     the annotations on that parameter returned by
     *     {@code Method.getParameterAnnotations}.
     * @param mediaType the media type of the HTTP entity, if one is not
     *     specified in the request then {@code application/octet-stream} is
     *     used.
     * @return {@code true} if the type is supported, otherwise {@code false}.
     */
    boolean isReadable(Class<?>     type, 
	                   Type         genericType,
                       Annotation[] annotations, 
					   MediaType    mediaType);

    /**
     * Read a type from the {@link InputStream}.
     *
     * @return the type that was read from the stream.
     * @param type the type that is to be read from the entity stream.
     * @param genericType the type of object to be produced. E.g. if the
     *     message body is to be converted into a method parameter, this will be
     *     the formal type of the method parameter as returned by
     *     <code>Method.getGenericParameterTypes</code>.
     * @param annotations an array of the annotations on the declaration of the
     *     artifact that will be initialized with the produced instance. E.g.
     *     if the message body is to be converted into a method parameter, this
     *     will be the annotations on that parameter returned by
     *     <code>Method.getParameterAnnotations</code>.
     * @param mediaType the media type of the HTTP entity.
     * @param httpHeaders the read-only HTTP headers associated with HTTP entity.
     * @param entityStream the {@link InputStream} of the HTTP entity. The
     *     caller is responsible for ensuring that the input stream ends when the
     *     entity has been consumed. The implementation should not close the input
     *     stream.
     * @throws java.io.IOException if an IO error arises
     * @throws javax.ws.rs.WebApplicationException if a specific
     *     HTTP error response needs to be produced. Only effective if thrown
     *     prior to the response being committed.
     */
    T readFrom(Class<T>                       type, 
	           Type                           genericType,
               Annotation[]                   annotations, 
			   MediaType                      mediaType,
               MultivaluedMap<String, String> httpHeaders,
               InputStream                    entityStream) throws java.io.IOException, 
			                                           org.es4j.serialization.jaxrs.api.ApplicationException;
}
