package me.ellios.jersey;

import me.ellios.core.CountService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/api")
public class DemoResource {

    private static JsonBinder jsonBinder = JsonBinder.buildNormalBinder();
    private CountService countService = new CountService();

    @GET
    @Path("/{app}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String doGet(@PathParam("app") String app, @PathParam("id") String id) {
        return jsonBinder.toJson(countService.get(app, id));
    }

    @POST
    @Path("/{app}/{id}/")
    @Produces(MediaType.APPLICATION_JSON)
    public String doPost(@PathParam("app") String app, @PathParam("id") String id) {
        return jsonBinder.toJson(countService.inc(app, id, 1));
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
