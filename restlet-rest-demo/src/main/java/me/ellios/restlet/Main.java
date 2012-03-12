package me.ellios.restlet;

import org.restlet.Component;


public class Main {

    public static void main(String[] args) throws Exception {
        Component component = new DemoComponent();
        component.start();
    }
}
