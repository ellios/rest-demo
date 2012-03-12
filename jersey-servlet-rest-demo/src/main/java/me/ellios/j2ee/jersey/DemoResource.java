package me.ellios.j2ee.jersey;

import me.ellios.core.CountService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/api")
public class DemoResource {

    private CountService countService = new CountService();

    @GET
    @Path("/{app}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map doGet(@PathParam("app") String app, @PathParam("id") String id) {
        return countService.get(app, id);
    }

    @POST
    @Path("/{app}/{id}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Map doPost(@PathParam("app") String app, @PathParam("id") String id) {
        return countService.inc(app, id, 1);
    }

    @DELETE
    @Path("/{app}/{id}/")
    public boolean doDelete(@PathParam("app") String app, @PathParam("id") String id) {
        Long count = countService.delete(app, id);
        if(count == null)
            return false;
        return true;
    }
	
}