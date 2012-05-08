package org.es4j.serialization.jaxrs.api;

//import javax.ws.rs.core.Response;

/**
 * Runtime exception for applications.
 * <p>
 * This exception may be thrown by a resource method, provider or
 * {@link javax.ws.rs.core.StreamingOutput} implementation if a specific
 * HTTP error response needs to be produced. Only effective if thrown prior to
 * the response being committed.
 *
 * @author Paul.Sandoz@Sun.Com
 * @since 1.0
 */
// Was WebApplicationException
public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 11660101L;
  //private final Response    response;

    /**
     * Construct a new instance with a blank message and default HTTP status code of 500.
     */
    public ApplicationException() {
        //this(null, Response.Status.INTERNAL_SERVER_ERROR);
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Construct a new instance using the supplied response.
     *
     * @param response the response that will be returned to the client, a value
     * of null will be replaced with an internal server error response (status
     * code 500).
     */
    //public WebApplicationException(final Response response) {
    //    throw new UnsupportedOperationException("Not yet implemented");
        //this(null, response);
    //}

    /**
     * Construct a new instance with a blank message and specified HTTP status code.
     *
     * @param status the HTTP status code that will be returned to the client.
     */
    public ApplicationException(final int status) {
        throw new UnsupportedOperationException("Not yet implemented");
        //this(null, status);
    }

    /**
     * Construct a new instance with a blank message and specified HTTP status code.
     *
     * @param status the HTTP status code that will be returned to the client.
     * @throws IllegalArgumentException if status is {@code null}.
     */
    //public WebApplicationException(final Response.Status status) throws IllegalArgumentException {
    //    this(null, status);
    //}

    /**
     * Construct a new instance with a blank message and default HTTP status code of 500.
     *
     * @param cause the underlying cause of the exception.
     */
    public ApplicationException(final Throwable cause) {
        //this(cause, Response.Status.INTERNAL_SERVER_ERROR);
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Construct a new instance using the supplied response.
     *
     * @param response the response that will be returned to the client,
     *     a value of null will be replaced with an internal server error
     *     response (status code 500).
     * @param cause the underlying cause of the exception.
     */
    /*
    public WebApplicationException(final Throwable cause, final Response response) {
        super(cause);
        if (response == null) {
            //this.response = Response.serverError().build();
            throw new UnsupportedOperationException("Not yet implemented");
        } else {
            //this.response = response;
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }
    */

    /**
     * Construct a new instance with a blank message and specified HTTP status code.
     *
     * @param status the HTTP status code that will be returned to the client.
     * @param cause the underlying cause of the exception.
     */
    public ApplicationException(final Throwable cause, final int status) {
        //this(cause, Response.status(status).build());
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Construct a new instance with a blank message and specified HTTP status code.
     *
     * @param status the HTTP status code that will be returned to the client.
     * @param cause the underlying cause of the exception.
     * @throws IllegalArgumentException if status is {@code null}.
     */
    //public WebApplicationException(final Throwable cause, final Response.Status status)
    //                                                  throws IllegalArgumentException {
        //this(cause, Response.status(status).build());
    //    throw new UnsupportedOperationException("Not yet implemented");
    //}

    /**
     * Get the HTTP response.
     *
     * @return the HTTP response.
     */
    //public final Response getResponse() {
    //    throw new UnsupportedOperationException("Not yet implemented");
        //return response;
    //}
}
