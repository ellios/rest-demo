package me.ellios.restlet;

import org.restlet.data.Protocol;

public class DemoComponent extends org.restlet.Component{


    public DemoComponent() {
        // Set basic properties
        setName("restful demo");
        setDescription("restful demo server component");

        // Add client connectors
        getClients().add(Protocol.CLAP);

        // Adds server connectors
        getServers().add(Protocol.HTTP, 8102);
        getDefaultHost().attach("/api", new DemoApplication());

    }

}
