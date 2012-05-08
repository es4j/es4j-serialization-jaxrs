package org.es4j.serialization.jaxrs.api;

/**
 * The exception thrown by JAX-RS runtime in case the processing of a message
 * entity failed in a request or response filter.
 *
 * @author Marek Potociar
 * @since 2.0
 */
public class MessageProcessingException extends RuntimeException {
    private static final long serialVersionUID = 1867031673462562629L;

    /**
     * Constructs a new message processing exception with the specified cause and
     * a detail message of {@code (cause==null ? null : cause.toString())}.
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *     {@link #getCause()} method).  (A {@code null} value is permitted, and
     *     indicates that the cause is nonexistent or unknown.)
     */
    public MessageProcessingException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new message processing exception with the specified cause and
     * a detail message.
     *
     * @param message detailed exception message.
     * @param  cause the cause (which is saved for later retrieval by the
     *     {@link #getCause()} method).  (A {@code null} value is permitted, and
     *     indicates that the cause is nonexistent or unknown.)
     */
    public MessageProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new message processing exception with a specified detail
     * message.
     *
     * @param message detailed exception message.
     */
    public MessageProcessingException(String message) {
        super(message);
    }

}
