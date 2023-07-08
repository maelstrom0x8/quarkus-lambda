package org.aeros;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
@Path("/api")
public class UserResource {

    private final Map<Integer, String> ids = new HashMap<>();

    public UserResource() {
        for (int i = 0; i < 10; i++) {
            ids.put(i, UUID.randomUUID().toString());
        }
    }

    @GET
    @Path("/ids")
    public Map<Integer, String> getUsers() {
        return ids;
    }

    @GET
    @Path("/ids/{id}")
    public String getUUID(@PathParam("id") Integer id) {
        return ids.get(id);
    }
}
