/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011-2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package jaxrs.examples.client.webdav;

import java.util.Locale;
import java.util.Set;

import javax.ws.rs.client.Configuration;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.InvocationException;
import javax.ws.rs.core.*;

/**
 *
 * @author Marek Potociar (marek.potociar at oracle.com)
 */
public class WebDavTargetedBuilder implements Invocation.Builder, WebDavSyncInvoker {

    public Invocation buildSearch(Object entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Invocation build(String method) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Invocation build(String method, Entity<?> entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Invocation buildDelete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Invocation buildGet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Invocation buildPost(Entity<?> entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Invocation buildPut(Entity<?> entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public WebDavAsyncInvoker async() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public WebDavTargetedBuilder acceptLanguage(Locale... locales) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public WebDavTargetedBuilder acceptLanguage(String... locales) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public WebDavTargetedBuilder cookie(Cookie cookie) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public WebDavTargetedBuilder allow(String... methods) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public WebDavTargetedBuilder allow(Set<String> methods) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public WebDavTargetedBuilder cacheControl(CacheControl cacheControl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public WebDavTargetedBuilder header(String name, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //@Override
    public WebDavTargetedBuilder headers(MultivaluedMap<String, Object> headers) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public Builder headers(RequestHeaders rh) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Response get() throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T get(Class<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T get(GenericType<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Response put(Entity<?> entity) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T put(Entity<?> entity, Class<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T put(Entity<?> entity, GenericType<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Response post(Entity<?> entity) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T post(Entity<?> entity, Class<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T post(Entity<?> entity, GenericType<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Response delete() throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T delete(Class<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T delete(GenericType<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Response head() throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Response options() throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T options(Class<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T options(GenericType<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Response trace(Entity<?> entity) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T trace(Entity<?> entity, Class<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T trace(Entity<?> entity, GenericType<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Response method(String name) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T method(String name, Class<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T method(String name, GenericType<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Response method(String name, Entity<?> entity) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T method(String name, Entity<?> entity, Class<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T method(String name, Entity<?> entity, GenericType<T> responseType) throws InvocationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Response search(Entity<?> entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Configuration configuration() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
