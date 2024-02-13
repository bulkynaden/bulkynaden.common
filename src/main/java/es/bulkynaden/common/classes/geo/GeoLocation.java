package es.bulkynaden.common.classes.geo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The {@code GeoLocation} class holds details of a geographical location including its
 * name, address, the city it belongs to, and its geographical coordinates,
 * represented by an instance of {@code IGeographicCoordinates}.
 *
 * <p>
 * The class is designed to be a robust representation of a physical location in a
 * geographical context.
 * Each instance of this class represents a unique location
 *
 * <p>
 * This class implements the {@code IGeoLocation} interface, allowing for a standardized
 * way to handle geographical locations throughout your application.
 *
 * @see IGeoLocation
 * @see IGeographicCoordinates
 */
@Data
@EqualsAndHashCode(of = {"name", "address"})
public class GeoLocation implements IGeoLocation {
    private String name;
    private String address;
    private ICity city;
    private IGeographicCoordinates coordinates;
}