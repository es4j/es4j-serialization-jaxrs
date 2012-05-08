package org.es4j.serialization.jaxrs.api.ext;

import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import org.es4j.serialization.jaxrs.api.core.MediaType;
import org.es4j.serialization.jaxrs.api.core.MultivaluedMap;

/**
 * Contract for a provider that supports the conversion of a Java type to a
 * stream. To add a <code>MessageBodyWriter</code> implementation, annotate the
 * implementation class with <code>@Provider</code>.
 *
 * A <code>MessageBodyWriter</code> implementation may be annotated
 * with {@link javax.ws.rs.Produces} to restrict the media types for which it will
 * be considered suitable.
 *
 * @param <T> the type that can be written
 *
 * @author Paul Sandoz
 * @author Marc Hadley
 * @see Provider
 * @see javax.ws.rs.Produces
 * @since 1.0
 */
public interface MessageBodyWriter<T> {

    /**
     * Ascertain if the MessageBodyWriter supports a particular type.
     *
     * @param type the class of object that is to be written.
     * @param genericType the type of object to be written, obtained either
     * by reflection of a resource method return type or via inspection
     * of the returned instance. {@link javax.ws.rs.core.GenericEntity}
     * provides a way to specify this information at runtime.
     * @param annotations an array of the annotations on the resource
     * method that returns the object.
     * @param mediaType the media type of the HTTP entity.
     * @return true if the type is supported, otherwise false.
     */
    boolean isWriteable(Class<?>     type, 
	                    Type         genericType,
                        Annotation[] annotations, 
						MediaType    mediaType);

    /**
     * Called before <code>writeTo</code> to ascertain the length in bytes of
     * the serialized form of <code>t</code>. A non-negative return value is
     * used in a HTTP <code>Content-Length</code> header.
     * @param t the instance to write
     * @param type the class of object that is to be written.
     * @param genericType the type of object to be written, obtained either
     * by reflection of a resource method return type or by inspection
     * of the returned instance. {@link javax.ws.rs.core.GenericEntity}
     * provides a way to specify this information at runtime.
     * @param annotations an array of the annotations on the resource
     * method that returns the object.
     * @param mediaType the media type of the HTTP entity.
     * @return length in bytes or -1 if the length cannot be determined in
     * advance
     */
    long getSize(T            t, 
	             Class<?>     type, 
				 Type         genericType, 
				 Annotation[] annotations,
                 MediaType    mediaType);

    /**
     * Write a type to an HTTP message. The message header map is mutable
     * but any changes must be made before writing to the output stream since
     * the headers will be flushed prior to writing the message body.
     *
     * @param t the instance to write.
     * @param type the class of object that is to be written.
     * @param genericType the type of object to be written, obtained either
     *     by reflection of a resource method return type or by inspection
     *     of the returned instance. {@link javax.ws.rs.core.GenericEntity}
     *     provides a way to specify this information at runtime.
     * @param annotations an array of the annotations on the resource
     *     method that returns the object.
     * @param mediaType the media type of the HTTP entity.
     * @param httpHeaders a mutable map of the HTTP message headers.
     * @param entityStream the {@link OutputStream} for the HTTP entity. The
     *     implementation should not close the output stream.
     * @throws java.io.IOException if an IO error arises
     * @throws javax.ws.rs.WebApplicationException if a specific
     *     HTTP error response needs to be produced. Only effective if thrown
     *     prior to the message being committed.
     */
    void writeTo(T                              t, 
	             Class<?>                       type, 
	             Type                           genericType, 
				 Annotation[]                   annotations,
                 MediaType                      mediaType,
                 MultivaluedMap<String, Object> httpHeaders,
                 OutputStream                   entityStream) throws java.io.IOException, 
				                                     org.es4j.serialization.jaxrs.api.ApplicationException;
}
