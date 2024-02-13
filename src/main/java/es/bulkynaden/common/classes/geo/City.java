package es.bulkynaden.common.classes.geo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The {@code City} class represents a city object.
 * It implements the {@code ICity} interface, which provides methods to get and set the name of the city.
 * The {@code City} class is annotated with {@code @Data} and {@code @EqualsAndHashCode(of = "name")}.
 * This annotation generates getter and setter methods for all fields in the class,
 * as well as implementations for {@code equals()} and {@code hashCode()} methods based on the "name" field.
 */
@Data
@EqualsAndHashCode(of = "name")
public class City implements ICity {
    private String name;
}