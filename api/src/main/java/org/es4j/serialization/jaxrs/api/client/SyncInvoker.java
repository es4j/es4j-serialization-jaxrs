package org.es4j.serialization.jaxrs.api.client;

import org.es4j.serialization.jaxrs.api.core.Response;
import org.es4j.serialization.jaxrs.api.core.GenericType;

/**
 * Uniform interface for synchronous invocation of HTTP methods.
 *
 * @author Marek Potociar
 * @since 2.0
 */
public interface SyncInvoker {

    // GET
    /**
     * Invoke HTTP GET method for the current request synchronously.
     *
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    Response get() throws InvocationException;

    /**
     * Invoke HTTP GET method for the current request synchronously.
     *
     * @param <T> response entity type.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T get(Class<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP GET method for the current request synchronously.
     *
     * @param <T> generic response entity type.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T get(GenericType<T> responseType) throws InvocationException;

    // PUT
    /**
     * Invoke HTTP PUT method for the current request synchronously.
     *
     * @param entity request entity.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    Response put(Entity<?> entity) throws InvocationException;

    /**
     * Invoke HTTP PUT method for the current request synchronously.
     *
     * @param <T> response entity type.
     * @param entity request entity.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T put(Entity<?> entity, Class<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP PUT method for the current request synchronously.
     *
     * @param <T> generic response entity type.
     * @param entity request entity.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T put(Entity<?> entity, GenericType<T> responseType) throws InvocationException;

    // POST
    /**
     * Invoke HTTP POST method for the current request synchronously.
     *
     * @param entity request entity.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    Response post(Entity<?> entity) throws InvocationException;

    /**
     * Invoke HTTP POST method for the current request synchronously.
     *
     * @param <T> response entity type.
     * @param entity request entity.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T post(Entity<?> entity, Class<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP POST method for the current request synchronously.
     *
     * @param <T> generic response entity type.
     * @param entity request entity.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T post(Entity<?> entity, GenericType<T> responseType) throws InvocationException;

    // DELETE
    /**
     * Invoke HTTP DELETE method for the current request synchronously.
     *
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    Response delete() throws InvocationException;

    /**
     * Invoke HTTP DELETE method for the current request synchronously.
     *
     * @param <T> response entity type.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T delete(Class<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP DELETE method for the current request synchronously.
     *
     * @param <T> generic response entity type.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T delete(GenericType<T> responseType) throws InvocationException;

    // HEAD
    /**
     * Invoke HTTP HEAD method for the current request synchronously.
     *
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    Response head() throws InvocationException;

    // OPTIONS
    /**
     * Invoke HTTP OPTIONS method for the current request synchronously.
     *
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    Response options() throws InvocationException;

    /**
     * Invoke HTTP OPTIONS method for the current request synchronously.
     *
     * @param <T> response entity type.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T options(Class<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP OPTIONS method for the current request synchronously.
     *
     * @param <T> generic response entity type.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T options(GenericType<T> responseType) throws InvocationException;

    // TRACE
    /**
     * Invoke HTTP TRACE method for the current request synchronously.
     *
     * @param entity request entity.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    Response trace(Entity<?> entity) throws InvocationException;

    /**
     * Invoke HTTP TRACE method for the current request synchronously.
     *
     * @param <T> response entity type.
     * @param entity request entity.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T trace(Entity<?> entity, Class<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP TRACE method for the current request synchronously.
     *
     * @param <T> generic response entity type.
     * @param entity request entity.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T trace(Entity<?> entity, GenericType<T> responseType) throws InvocationException;

    // ARBITRARY METHOD
    /**
     * Invoke an arbitrary method for the current request synchronously.
     *
     * @param name method name.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    Response method(String name) throws InvocationException;

    /**
     * Invoke an arbitrary method for the current request synchronously.
     *
     * @param <T> response entity type.
     * @param name method name.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T method(String name, Class<T> responseType) throws InvocationException;

    /**
     * Invoke an arbitrary method for the current request synchronously.
     *
     * @param <T> generic response entity type.
     * @param name method name.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T method(String name, GenericType<T> responseType) throws InvocationException;

    /**
     * Invoke an arbitrary method for the current request synchronously.
     *
     * @param name method name.
     * @param entity request entity.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    Response method(String name, Entity<?> entity) throws InvocationException;

    /**
     * Invoke an arbitrary method for the current request synchronously.
     *
     * @param <T> response entity type.
     * @param name method name.
     * @param entity request entity.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T method(String name, Entity<?> entity, Class<T> responseType) throws InvocationException;

    /**
     * Invoke an arbitrary method for the current request synchronously.
     *
     * @param <T> generic response entity type.
     * @param name method name.
     * @param entity request entity.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response.
     * @throws InvocationException in case the invocation failed.
     */
    <T> T method(String name, Entity<?> entity, GenericType<T> responseType) throws InvocationException;
}
