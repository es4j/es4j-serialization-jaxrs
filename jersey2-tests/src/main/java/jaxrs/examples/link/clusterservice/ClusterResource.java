/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright (c) 2011 Oracle and/or its affiliates. All rights reserved.
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

package jaxrs.examples.link.clusterservice;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import jaxrs.examples.link.clusterservice.Cluster.Status;

/**
 * ClusterResource class.
 *
 * @author Santiago.Pericas-Geertsen@oracle.com
 */
@Path("/cluster")
public class ClusterResource {

    private Cluster cluster = Model.getCluster();
    
    @GET
    @Produces({"application/json"})
    public Response self() {
        return Response.ok(cluster).links(getTransitionalLinks()).build();
    }
    
    @POST
    @Path("onliner")
    @Produces({"application/json"})
    public Response onliner() {
        cluster.setStatus(Status.ONLINE);
        return Response.ok(cluster).links(getTransitionalLinks()).build();
    }
    
    @POST
    @Path("offliner")
    @Produces({"application/json"})
    public Response offliner() {
        cluster.setStatus(Status.OFFLINE);
        return Response.ok(cluster).links(getTransitionalLinks()).build();
    }
    
    private Link[] getTransitionalLinks() {
        Link self = Link.fromResourceMethod(getClass(), "self").build();
        Link item = Link.fromResourceMethod(MachineResource.class, "self").rel("item").build();
        Link onliner = Link.fromResourceMethod(getClass(), "onliner").build();
        Link offliner = Link.fromResourceMethod(getClass(), "offliner").build();
        
        return cluster.getStatus() == Status.ONLINE ? 
                new Link[] { self, item, offliner } : 
                new Link[] { self, item, onliner };
    }
    
}
