package org.es4j.serialization.jaxrs.api.client;

import java.util.concurrent.Future;

import org.es4j.serialization.jaxrs.api.core.GenericType;
import org.es4j.serialization.jaxrs.api.core.Response;

/**
 * Uniform interface for asynchronous invocation of HTTP methods.
 *
 * @author Marek Potociar
 * @since 2.0
 */
public interface AsyncInvoker {

    // GET
    /**
     * Invoke HTTP GET method for the current request asynchronously.
     *
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    Future<Response> get() throws InvocationException;

    /**
     * Invoke HTTP GET method for the current request asynchronously.
     *
     * @param <T> response entity type.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> get(Class<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP GET method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> get(GenericType<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP GET method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param callback asynchronous invocation callback.
     * @return invocation response {@link Future future}.
     */
    <T> Future<T> get(InvocationCallback<T> callback);

    // PUT
    /**
     * Invoke HTTP PUT method for the current request asynchronously.
     *
     * @param entity request entity.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    Future<Response> put(Entity<?> entity) throws InvocationException;

    /**
     * Invoke HTTP PUT method for the current request asynchronously.
     *
     * @param <T> response entity type.
     * @param entity request entity.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> put(Entity<?> entity, Class<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP PUT method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param entity request entity.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> put(Entity<?> entity, GenericType<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP PUT method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param entity request entity.
     * @param callback asynchronous invocation callback.
     * @return invocation response {@link Future future}.
     */
    <T> Future<T> put(Entity<?> entity, InvocationCallback<T> callback);

    // POST
    /**
     * Invoke HTTP POST method for the current request asynchronously.
     *
     * @param entity request entity.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    Future<Response> post(Entity<?> entity) throws InvocationException;

    /**
     * Invoke HTTP POST method for the current request asynchronously.
     *
     * @param <T> response entity type.
     * @param entity request entity.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> post(Entity<?> entity, Class<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP POST method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param entity request entity.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> post(Entity<?> entity, GenericType<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP POST method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param entity request entity.
     * @param callback asynchronous invocation callback.
     * @return invocation response {@link Future future}.
     */
    <T> Future<T> post(Entity<?> entity, InvocationCallback<T> callback);

    // DELETE
    /**
     * Invoke HTTP DELETE method for the current request asynchronously.
     *
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    Future<Response> delete() throws InvocationException;

    /**
     * Invoke HTTP DELETE method for the current request asynchronously.
     *
     * @param <T> response entity type.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> delete(Class<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP DELETE method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> delete(GenericType<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP DELETE method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param callback asynchronous invocation callback.
     * @return invocation response {@link Future future}.
     */
    <T> Future<T> delete(InvocationCallback<T> callback);

    // HEAD
    /**
     * Invoke HTTP HEAD method for the current request asynchronously.
     *
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    Future<Response> head() throws InvocationException;

    /**
     * Invoke HTTP HEAD method for the current request asynchronously.
     *
     * @param callback asynchronous invocation callback.
     * @return invocation response {@link Future future}.
     */
    Future<Response> head(InvocationCallback<Response> callback);

    // OPTIONS
    /**
     * Invoke HTTP OPTIONS method for the current request asynchronously.
     *
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    Future<Response> options() throws InvocationException;

    /**
     * Invoke HTTP OPTIONS method for the current request asynchronously.
     *
     * @param <T> response entity type.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> options(Class<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP OPTIONS method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> options(GenericType<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP OPTIONS method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param callback asynchronous invocation callback.
     * @return invocation response {@link Future future}.
     */
    <T> Future<T> options(InvocationCallback<T> callback);

    // TRACE
    /**
     * Invoke HTTP TRACE method for the current request asynchronously.
     *
     * @param entity request entity.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    Future<Response> trace(Entity<?> entity) throws InvocationException;

    /**
     * Invoke HTTP TRACE method for the current request asynchronously.
     *
     * @param <T> response entity type.
     * @param entity request entity.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> trace(Entity<?> entity, Class<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP TRACE method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param entity request entity.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> trace(Entity<?> entity, GenericType<T> responseType) throws InvocationException;

    /**
     * Invoke HTTP TRACE method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param entity request entity.
     * @param callback asynchronous invocation callback.
     * @return invocation response {@link Future future}.
     */
    <T> Future<T> trace(Entity<?> entity, InvocationCallback<T> callback);

    // ARBITRARY METHOD
    /**
     * Invoke an arbitrary method for the current request asynchronously.
     *
     * @param name method name.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    Future<Response> method(String name) throws InvocationException;

    /**
     * Invoke an arbitrary method for the current request asynchronously.
     *
     * @param <T> response entity type.
     * @param name method name.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> method(String name, Class<T> responseType) throws InvocationException;

    /**
     * Invoke an arbitrary method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param name method name.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> method(String name, GenericType<T> responseType) throws InvocationException;

    /**
     * Invoke an arbitrary method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param name method name.
     * @param callback asynchronous invocation callback.
     * @return invocation response {@link Future future}.
     */
    <T> Future<T> method(String name, InvocationCallback<T> callback);

    /**
     * Invoke an arbitrary method for the current request asynchronously.
     *
     * @param name method name.
     * @param entity request entity.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    Future<Response> method(String name, Entity<?> entity) throws InvocationException;

    /**
     * Invoke an arbitrary method for the current request asynchronously.
     *
     * @param <T> response entity type.
     * @param name method name.
     * @param entity request entity.
     * @param responseType Java type the response entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> method(String name, Entity<?> entity, Class<T> responseType) throws InvocationException;

    /**
     * Invoke an arbitrary method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param name method name.
     * @param entity request entity.
     * @param responseType representation of a generic Java type the response
     *     entity will be converted to.
     * @return invocation response {@link Future future}.
     * @throws InvocationException in case the invocation failed.
     */
    <T> Future<T> method(String name, Entity<?> entity, GenericType<T> responseType) throws InvocationException;

    /**
     * Invoke an arbitrary method for the current request asynchronously.
     *
     * @param <T> generic response entity type.
     * @param name method name.
     * @param entity request entity.
     * @param callback asynchronous invocation callback.
     * @return invocation response {@link Future future}.
     */
    <T> Future<T> method(String name, Entity<?> entity, InvocationCallback<T> callback);
}
