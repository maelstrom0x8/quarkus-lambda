package org.aeros;

import jakarta.json.bind.annotation.JsonbProperty;

import java.time.LocalDate;
import java.util.UUID;


public record Car(UUID id, String name, String model,
                  @JsonbProperty("release_date") LocalDate releaseDate) {
}
