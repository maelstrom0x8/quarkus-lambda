package org.aeros.service.inventory;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@ApplicationScoped
@Path("/api")
public class InventoryResource {

    @Inject
    InventoryService service;

    public InventoryResource(InventoryService service) {
        this.service = service;
    }

    @GET
    @Path("/stock")
    public List<Item> getStockData() {
        return service.getStock();
    }

}
