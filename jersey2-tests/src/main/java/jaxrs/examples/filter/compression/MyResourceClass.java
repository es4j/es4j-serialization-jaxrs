package jaxrs.examples.filter.compression;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * 
 * @author Santiago Pericas-Geertsen
 */
@Path("/")
public class MyResourceClass {

    @Gzipped
    @GET
    @Produces("text/plain")
    @Path("{name}")
    public String hello(@PathParam("name") String name) {
        return "Hello " + name;
    }
}
