package me.ellios.restlet;

import me.ellios.core.CountService;
import me.ellios.restlet.JsonBinder;
import org.restlet.resource.*;

import java.util.Map;


public class DemoServerResource extends ServerResource{

    private static JsonBinder jsonBinder = JsonBinder.buildNormalBinder();
    private CountService countService = new CountService();

    private String id;
    private String app;

    @Override
    protected void doInit() throws ResourceException {
        this.app = (String)getRequestAttributes().get("app");
        this.id = (String) getRequestAttributes().get("id");
    }

    @Get
    public String doGet() {
        return jsonBinder.toJson(countService.get(app, id));
    }

    @Post
    public String doPost() {
        return jsonBinder.toJson(countService.inc(app, id, 1));
    }

    @Delete
    public boolean doDelete() {
        Long count = countService.delete(app, id);
        if(count == null)
            return false;
        return true;
    }

}
