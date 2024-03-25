package es.bulkynaden.common.geo;

/**
 * The {@code IGeoLocationHolder} interface represents an object that holds geographic location.
 * It provides methods to get and set the geographic location of the object.
 */
public interface IGeoLocationHolder {

    /**
     * Retrieves the geographic location of the object.
     *
     * @return the geographic location of the object
     */
    IGeoLocation getGeoLocation();

    /**
     * Sets the geographic location of the object.
     *
     * @param geoLocation the geographic location to be set
     */
    void setGeoLocation(IGeoLocation geoLocation);
}