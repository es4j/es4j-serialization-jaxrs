package org.es4j.serialization.jaxrs.api.client;

import java.util.Locale;

//import javax.ws.rs.core.Form;

import org.es4j.serialization.jaxrs.api.core.MediaType;
import org.es4j.serialization.jaxrs.api.core.MultivaluedMap;
import org.es4j.serialization.jaxrs.api.core.Variant;

/**
 * Encapsulates message entity including the associated variant information.
 *
 * @param <T> entity type.
 * @author Marek Potociar
 */
public final class Entity<T> {

    private final T entity;
    private final Variant variant;

    /**
     * Create an entity using a supplied content media type.
     *
     * @param <T> entity Java type.
     * @param entity entity data.
     * @param mediaType entity content type.
     * @return entity instance.
     */
    public static <T> Entity<T> entity(final T entity, final MediaType mediaType) {
        return new Entity<T>(entity, mediaType);
    }

    /**
     * Create an entity using a supplied content media type.
     *
     * @param <T> entity Java type.
     * @param entity entity data.
     * @param mediaType entity content type.
     * @return entity instance.
     * @throws IllegalArgumentException if the supplied string cannot be parsed
     *     or is {@code null}.
     */
    public static <T> Entity<T> entity(final T entity, final String mediaType) throws IllegalArgumentException {
        return new Entity<T>(entity, MediaType.valueOf(mediaType));
    }

    /**
     * Create an entity using a supplied content media type.
     *
     * @param <T> entity Java type.
     * @param entity entity data.
     * @param variant entity {@link Variant variant} information.
     * @return entity instance.
     */
    public static <T> Entity<T> entity(final T entity, final Variant variant) {
        return new Entity<T>(entity, variant);
    }

    /**
     * Create a {@value javax.ws.rs.core.MediaType#TEXT_PLAIN} entity.
     *
     * @param <T> entity Java type.
     * @param entity entity data.
     * @return {@value javax.ws.rs.core.MediaType#TEXT_PLAIN} entity instance.
     */
    public static <T> Entity<T> text(final T entity) {
        return new Entity<T>(entity, MediaType.TEXT_PLAIN_TYPE);
    }

    /**
     * Create an {@value javax.ws.rs.core.MediaType#APPLICATION_XML} entity.
     *
     * @param <T> entity Java type.
     * @param entity entity data.
     * @return {@value javax.ws.rs.core.MediaType#APPLICATION_XML} entity instance.
     */
    public static <T> Entity<T> xml(final T entity) {
        return new Entity<T>(entity, MediaType.APPLICATION_XML_TYPE);
    }

    /**
     * Create an {@value javax.ws.rs.core.MediaType#APPLICATION_JSON} entity.
     *
     * @param <T> entity Java type.
     * @param entity entity data.
     * @return {@value javax.ws.rs.core.MediaType#APPLICATION_JSON} entity instance.
     */
    public static <T> Entity<T> json(final T entity) {
        return new Entity<T>(entity, MediaType.APPLICATION_JSON_TYPE);
    }

    /**
     * Create a {@value javax.ws.rs.core.MediaType#TEXT_HTML} entity.
     *
     * @param <T> entity Java type.
     * @param entity entity data.
     * @return {@value javax.ws.rs.core.MediaType#TEXT_HTML} entity instance.
     */
    public static <T> Entity<T> html(final T entity) {
        return new Entity<T>(entity, MediaType.TEXT_HTML_TYPE);
    }

    /**
     * Create an {@value javax.ws.rs.core.MediaType#APPLICATION_XHTML_XML} entity.
     *
     * @param <T> entity Java type.
     * @param entity entity data.
     * @return {@value javax.ws.rs.core.MediaType#APPLICATION_XHTML_XML} entity
     *     instance.
     */
    public static <T> Entity<T> xhtml(final T entity) {
        return new Entity<T>(entity, MediaType.APPLICATION_XHTML_XML_TYPE);
    }

    /**
     * Create an {@value javax.ws.rs.core.MediaType#APPLICATION_FORM_URLENCODED}
     * form entity.
     *
     * @param form form data.
     * @return {@value javax.ws.rs.core.MediaType#APPLICATION_FORM_URLENCODED}
     *     form entity instance.
     */
    //public static Entity<Form> form(final Form form) {
    //    return new Entity<Form>(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE);
    //}

    /**
     * Create an {@value javax.ws.rs.core.MediaType#APPLICATION_FORM_URLENCODED}
     * form entity.
     *
     * @param formData multivalued map representing the form data.
     * @return {@value javax.ws.rs.core.MediaType#APPLICATION_FORM_URLENCODED}
     *     form entity instance.
     */
    //public static Entity<Form> form(final MultivaluedMap<String, String> formData) {
    //    return new Entity<Form>(new Form(formData), MediaType.APPLICATION_FORM_URLENCODED_TYPE);
    //}

    private Entity(final T entity, final MediaType mediaType) {
        this.entity = entity;
        this.variant = new Variant(mediaType, null, null);
    }

    private Entity(final T entity, final Variant variant) {
        this.entity = entity;
        this.variant = variant;
    }

    /**
     * Get entity {@link Variant variant} information.
     *
     * @return entity variant information.
     */
    public Variant getVariant() {
        return variant;
    }

    /**
     * Get entity media type.
     *
     * @return entity media type.
     */
    public MediaType getMediaType() {
        return variant.getMediaType();
    }

    /**
     * Get entity encoding.
     *
     * @return entity encoding.
     */
    public String getEncoding() {
        return variant.getEncoding();
    }

    /**
     * Get entity language.
     *
     * @return entity language.
     */
    public Locale getLanguage() {
        return variant.getLanguage();
    }

    /**
     * Get entity data.
     *
     * @return entity data.
     */
    public T getEntity() {
        return entity;
    }
}
