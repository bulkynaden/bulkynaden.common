package es.bulkynaden.common.classes.geo;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
@Getter
@Setter
public class GeoLocation implements IGeoLocation {
    private String address;
    private ICity city;
    private IGeographicCoordinates coordinates;

    /**
     * Generates a comprehensive string representation of this {@code GeoLocation} instance,
     * incorporating the location's name, address, and city name (when available). The resulting
     * string is formatted to include the location's name and address, separated by a dash (' - '),
     * and optionally, the city name enclosed in parentheses.
     *
     * <p>The method intelligently omits any null or blank values for the name, address, or city name,
     * ensuring only meaningful data is included in the string representation. The inclusion of the
     * city name is conditional; it appears in the final string only if it is neither null nor blank.</p>
     *
     * <p>Format details:</p>
     * <ul>
     *   <li>If all elements (name, address, city name) are present and non-blank, the format will be:
     *       {@code "Name - Address (City Name)"}.</li>
     *   <li>If the city name is null or blank, it will be omitted, resulting in: {@code "Name - Address"}.</li>
     *   <li>If either the name or the address is null or blank, only the non-blank values are included.
     *       If both are non-blank, they're separated by a dash. If one is blank, the other is presented
     *       without a dash.</li>
     * </ul>
     *
     * <p><strong>Example:</strong> Given a {@code GeoLocation} with the name "Google", an address of
     * "123 Main St", and a city name of "San Francisco", the method returns
     * {@code "Google - 123 Main St (San Francisco)"}.</p>
     *
     * @return A string representation of the {@code GeoLocation}, formatted as described above. If all
     * fields (name, address, and city name) are blank or null, an empty string is returned.
     */
    @Override
    public String toString() {
        String addressPart = Optional.ofNullable(address)
                .filter(s -> !s.isBlank())
                .orElse("");

        String cityPart = Optional.ofNullable(city)
                .map(ICity::getName)
                .filter(cityName -> !cityName.isBlank())
                .orElse("");

        return Stream.of(addressPart, cityPart)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(", "));
    }
}