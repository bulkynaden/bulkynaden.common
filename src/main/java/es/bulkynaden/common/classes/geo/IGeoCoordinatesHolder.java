package es.bulkynaden.common.classes.geo;

/**
 * The {@code IGeoCoordinatesHolder} interface represents an object that holds geographic coordinates.
 * It provides methods to get and set the geographic coordinates of the object.
 */
public interface IGeoCoordinatesHolder {

    /**
     * Retrieves the geographic coordinates of the object.
     *
     * @return the geographic coordinates of the object
     */
    IGeoCoordinates getGeoCoordinates();

    /**
     * Sets the geographic coordinates of the object.
     *
     * @param geoCoordinates the geographic coordinates to be set
     */
    void setGeoCoordinates(IGeoCoordinates geoCoordinates);
}