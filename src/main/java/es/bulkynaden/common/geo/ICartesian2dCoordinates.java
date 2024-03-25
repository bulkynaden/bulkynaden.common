package es.bulkynaden.common.geo;


/**
 * A contract for Cartesian coordinates in a 2-dimensional space.
 */
public interface ICartesian2dCoordinates<T, U> extends ICoordinates {

    /**
     * Retrieves the x-coordinate of the Cartesian coordinates in a 2-dimensional space.
     *
     * @return the x-coordinate
     */
    T getX();

    /**
     * Sets the x-coordinate value for the Cartesian coordinates in a 2-dimensional space.
     *
     * @param x the new x-coordinate value
     */
    void setX(T x);

    /**
     * Retrieves the y-coordinate of the Cartesian coordinates in a 2-dimensional space.
     *
     * @return the y-coordinate
     */
    U getY();

    /**
     * Sets the y-coordinate value for the Cartesian coordinates in a 2-dimensional space.
     *
     * @param y the new
     */
    void setY(U y);
}