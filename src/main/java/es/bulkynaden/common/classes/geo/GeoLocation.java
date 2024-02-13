package es.bulkynaden.common.classes.geo;

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
public class GeoLocation implements IGeoLocation {
    private String name;
    private String address;
    private ICity city;
    private IGeographicCoordinates coordinates;

    /**
     * Returns the name of the location associated with the geographic coordinates.
     *
     * @return the name of the location associated with the geographic coordinates.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the location associated with the geographic coordinates.
     *
     * @param name the new name for the location associated with the geographic coordinates.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the geographic coordinates associated with the location.
     *
     * @return the geographic coordinates
     */
    @Override
    public IGeographicCoordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets the geographic coordinates associated with the location.
     *
     * @param coordinates the geographic coordinates to be set
     */
    @Override
    public void setCoordinates(IGeographicCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Returns the address held by the object.
     *
     * @return the address held by the object
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the object.
     *
     * @param address the address to be set
     */
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the city held by the {@code ICityHolder} object.
     *
     * @return the city held by the object
     */
    @Override
    public ICity getCity() {
        return city;
    }

    /**
     * Sets the city for this {@code ICityHolder} object.
     *
     * @param city the {@code ICity} object to set as the city for this object
     */
    @Override
    public void setCity(ICity city) {
        this.city = city;
    }
}