package me.ellios.restlet;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;



public class DemoApplication extends Application {

    /**
     * Creates a root Router to dispatch call to server resources.
     */
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/{app}/{id}/", DemoServerResource.class);
        return router;
    }
}
