package es.bulkynaden.common.classes.geo;

/**
 * The {@code ICoordinatesHolder} interface represents an object that holds coordinates.
 * It provides methods to get and set the coordinates of the object.
 *
 * @param <T> the type of the coordinates
 */
public interface ICoordinatesHolder<T extends ICoordinates> {

    /**
     * Retrieves the coordinates of the object.
     *
     * @return the coordinates of the object
     */
    T getCoordinates();

    /**
     * Sets the coordinates of the object.
     *
     * @param coordinates the coordinates to be set
     */
    void setCoordinates(T coordinates);
}