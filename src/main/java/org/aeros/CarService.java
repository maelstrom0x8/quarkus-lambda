package org.aeros;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CarService {

    private final List<Car> cars = List.of(
            new Car(UUID.randomUUID(), "tesla", "model s", LocalDate.of(2021, 4,11)),
            new Car(UUID.randomUUID(), "bmw", "ix m60", LocalDate.of(2009, 9, 12)),
            new Car(UUID.randomUUID(), "nissan", "gt-r nismo", LocalDate.of(2024, 2, 17))
    );


    public List<Car> getCars() {
        return  cars;
    }

}
