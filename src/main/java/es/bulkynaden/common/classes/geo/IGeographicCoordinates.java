package es.bulkynaden.common.classes.geo;


/**
 * The {@code IGeographicCoordinates} interface extends the {@code ICoordinates} interface
 * and represents geographic coordinates consisting of longitude, latitude, and altitude.
 *
 * <p>
 * The longitude represents the angular distance of a point east or west of the prime meridian.
 * The latitude represents the angular distance of a point north or south of the equator.
 * The altitude represents the vertical distance of a point above or below a reference surface,
 * such as sea level.
 *
 * <p>
 * This interface provides methods to get and set the longitude, latitude, and altitude of the
 * geographic coordinates.
 *
 * @see ICoordinates
 */
public interface IGeographicCoordinates extends ICoordinates {

    /**
     * Returns the longitude value of the geographic coordinates.
     *
     * @return the longitude value of the geographic coordinates.
     */
    double getLongitude();

    /**
     * Sets the longitude value of the geographic coordinates.
     *
     * @param longitude the longitude value to be set
     */
    void setLongitude(double longitude);

    /**
     * Returns the latitude value of the geographic coordinates.
     *
     * @return the latitude value of the geographic coordinates.
     */
    double getLatitude();

    /**
     * Sets the latitude value of the geographic coordinates.
     *
     * @param latitude the latitude value to be set
     */
    void setLatitude(double latitude);

    /**
     * Returns the altitude value of the geographic coordinates.
     *
     * @return the altitude value of the geographic coordinates
     */
    double getAltitude();

    /**
     * Sets the altitude value of the geographic coordinates.
     *
     * @param altitude the altitude value to be set
     */
    void setAltitude(double altitude);
}