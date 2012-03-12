package me.ellios.restlet; /**
 * Copyright 2005-2011 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL 1.0 (the
 * "Licenses"). You can select the license that you prefer but you may not use
 * this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1.php
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1.php
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 * Mail client retrieving a mail then storing it again on the same resource.
 */
public class DemoClient {

    public static void main(String[] args) throws Exception {
        ClientResource mailClient = new ClientResource(
                "http://127.0.0.1/view/photo/333/");

//        Representation mailRepresentation = mailClient
//                .get(MediaType.APPLICATION_XML);
//        mailClient.put(mailRepresentation);
        Representation representation = mailClient.post(MediaType.APPLICATION_JSON);
        System.out.println(representation.getText());
//        Representation mailRepresentation2 = mailClient.get(MediaType.APPLICATION_JSON);
//        System.out.println(mailRepresentation2.getText());
//        mailClient.get(mailRepresentation);
    }

}
