package org.glassfish.jersey.tests.e2e.server;

import java.io.IOException;
import java.security.Principal;
import static junit.framework.Assert.assertEquals;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.PreMatchRequestFilter;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.collection.Ref;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.jvnet.hk2.annotations.Inject;

import org.junit.Assert;
import org.junit.Test;

/**
 * End to end test class for testing security context in the Filter and
 * resource.
 *
 * @author Miroslav Fuksa (miroslav.fuksa at oracle.com)
 */
public class SecurityContextFilterTest extends JerseyTest {

    private static final String PRINCIPAL_NAME = "test_principal_setByFilter";
    private static final String SKIP_FILTER = "skipFilter";
    private static final String PRINCIPAL_IS_NULL = "principalIsNull";

    @Override
    protected ResourceConfig configure() {
        return new ResourceConfig(SecurityContextFilter.class, Resource.class);
    }

    @Provider
    public static class SecurityContextFilter implements PreMatchRequestFilter {

        @Inject
        Ref<SecurityContext> securityContextRef;
        @Context
        SecurityContext securityContext;

        @Override
        public void preMatchFilter(FilterContext context) throws IOException {
            // test injections
            Assert.assertNotNull(securityContext);
            Assert.assertEquals(securityContextRef.get(), securityContext);


            String header = context.getRequest().getHeaders().getHeader(SKIP_FILTER);
            if ("true".equals(header)) {
                return;
            }

            // test injections
            Assert.assertNotNull(securityContext);
            Assert.assertEquals(securityContextRef.get(), securityContext);

            // set new Security Context
            securityContextRef.set(new SecurityContext() {

                @Override
                public boolean isUserInRole(String role) {
                    return false;
                }

                @Override
                public boolean isSecure() {
                    return false;
                }

                @Override
                public Principal getUserPrincipal() {
                    return new Principal() {

                        @Override
                        public String getName() {
                            return PRINCIPAL_NAME;
                        }
                    };
                }

                @Override
                public String getAuthenticationScheme() {
                    return null;
                }
            });
        }
    }

    /**
     * Tests SecurityContext in filter.
     *
     * @throws Exception Thrown when request processing fails in the
     * application.
     */
    @Test
    public void testSecurityContextInjectionFilter() throws Exception {
        Response response = target().path("test").request().get();
        assertEquals(200, response.getStatus());
        String entity = response.readEntity(String.class);
        assertEquals(PRINCIPAL_NAME, entity);
    }

    /**
     * Tests SecurityContext in filter.
     *
     * @throws Exception Thrown when request processing fails in the
     * application.
     */
    @Test
    public void testContainerSecurityContext() throws Exception {
        Response response = target().path("test").request().header(SKIP_FILTER, "true").get();
        assertEquals(200, response.getStatus());
        String entity = response.readEntity(String.class);
        Assert.assertTrue(!entity.equals(PRINCIPAL_NAME));
    }

    @Path("test")
    /**
     * Test resource class.
     */
    public static class Resource {

        /**
         * Test resource method.
         *
         * @param securityCtx security context.
         * @return String response with principal name.
         */
        @GET
        public String getPrincipal(@Context SecurityContext securityCtx) {
            Assert.assertNotNull(securityCtx);
            Principal userPrincipal = securityCtx.getUserPrincipal();
            return userPrincipal == null ? PRINCIPAL_IS_NULL : userPrincipal.getName();
        }
    }
}
