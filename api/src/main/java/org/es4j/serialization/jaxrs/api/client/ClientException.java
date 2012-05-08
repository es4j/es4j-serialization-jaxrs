package org.es4j.serialization.jaxrs.api.client;

/**
 * Root exception for all JAX-RS client-side specific exceptions.
 *
 * @author Marek Potociar
 * @since 2.0
 */
public class ClientException extends RuntimeException {

    private static final long serialVersionUID = -4232431597816056514L;

    /**
     * Constructs a new client-side runtime exception with the specified cause
     * and a detail message of {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of {@code cause}).
     * This constructor is useful for runtime exceptions that are little more
     * than wrappers for other throwables.
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *     {@link #getCause()} method). (A {@code null} value is permitted,
     *     and indicates that the cause is nonexistent or unknown.)
     */
    public ClientException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new client-side runtime exception with the specified detail
     * message and cause.
     * <p/>
     * Note that the detail message associated with {@code cause} is <i>not</i>
     * automatically incorporated in this runtime exception's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *     by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *     {@link #getCause()} method). (A {@code null} value is permitted,
     *     and indicates that the cause is nonexistent or unknown.)
     */
    public ClientException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new client-side runtime exception with the specified detail
     * message. The cause is not initialized, and may subsequently be initialized
     * by a call to {@link #initCause}.
     *
     * @param  message the detail message (which is saved for later retrieval
     *     by the {@link #getMessage()} method).
     */
    public ClientException(final String message) {
        super(message);
    }
}
