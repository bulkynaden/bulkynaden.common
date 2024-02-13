package es.bulkynaden.common.classes.geo;


/**
 * The {@code GeoCoordinates} class represents geographic coordinates
 * consisting of a name and an instance of {@code IGeographicCoordinates}.
 *
 * <p>
 * The name represents the name of the location associated with the coordinates.
 * The geographic coordinates represent the longitude, latitude, and altitude values
 * of the location.
 *
 * <p>
 * This class implements the {@code IGeoCoordinates} interface, which provides methods
 * to get and set the name and coordinates.
 *
 * @see IGeoCoordinates
 */
public class GeoCoordinates implements IGeoCoordinates {
    private String name;
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
}