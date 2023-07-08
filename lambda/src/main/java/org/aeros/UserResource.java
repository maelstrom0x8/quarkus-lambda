package org.aeros.service.inventory;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
@Path("/users")
public class UserResource {

    @Inject
    InventoryService service;

    private final Map<String, String> users = new HashMap<>();
    private final String[] usernames = {"harry", "anna", "laura", "josef", "zain", "hajar", "chisom", "kanayo"};

    public UserResource() {
        for (int i = 0; i < usernames.length; i++) {
            users.put(usernames[i], UUID.randomUUID().toString());
        }
    }

    @GET
    @Path("/service-ids")
    public Map<String, String> getUsers() {
        return users;
    }

}
