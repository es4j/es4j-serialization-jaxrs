package org.es4j.serialization.jaxrs.api.core;

import java.io.IOException;
import java.io.InputStream;

import org.es4j.serialization.jaxrs.api.ApplicationException;

/**
 * A type that may be used as a resource method return value or as the entity
 * in a {@link Response} when the application wishes to stream the output.
 * This is a lightweight alternative to a {@link javax.ws.rs.ext.MessageBodyWriter}.
 *
 * @author Paul Sandoz
 * @author Marc Hadley
 * @see javax.ws.rs.ext.MessageBodyWriter
 * @see javax.ws.rs.core.Response
 * @since 1.0
 */
public interface StreamingInput {

    /**
     * Called to write the message body.
     * @param input the OutputStream to read from.
     * @throws java.io.IOException if an IO error is encountered
     * @throws javax.ws.rs.WebApplicationException if a specific
     * HTTP error response needs to be produced. Only effective if thrown prior
     * to any bytes being written to output.
     */
    void write(InputStream input) throws IOException, ApplicationException;
}
