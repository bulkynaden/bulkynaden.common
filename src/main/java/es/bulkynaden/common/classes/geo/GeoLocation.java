package es.bulkynaden.common.classes.geo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
@EqualsAndHashCode(of = {"name", "address"})
@Getter
@Setter
public class GeoLocation implements IGeoLocation {
    private String name;
    private String address;
    private ICity city;
    private IGeographicCoordinates coordinates;

    @Override
    public String toString() {
        StringBuilder fullName = new StringBuilder();

        if (!name.isBlank()) {
            fullName.append(name)
                    .append(" - ");
        }

        if (address != null) {
            fullName.append(address)
                    .append(", ");
        }

        if (city != null) {
            fullName.append(city.getName());
        }

        return fullName.toString();
    }
}