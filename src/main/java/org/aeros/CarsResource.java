package org.aeros;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
@Path("/api")
public class CarsResource {

    private final Logger LOG = LoggerFactory.getLogger(CarsResource.class);

    @Inject
    private CarService carService;

    public CarsResource(CarService carService) {
        this.carService = carService;
    }

    @GET
    @Path("/cars")
    public List<Car> getAllCars() {
        LOG.info("Fetching all available cars");
        return carService.getCars();
    }


}

