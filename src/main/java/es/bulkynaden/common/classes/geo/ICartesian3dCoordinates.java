package es.bulkynaden.common.classes.geo;


/**
 * A contract for Cartesian coordinates in a 3-dimensional space.
 *
 * @param <T> the type of the x-coordinate
 * @param <U> the type of the y-coordinate
 * @param <V> the type of the z-coordinate
 */
public interface ICartesian3dCoordinates<T, U, V> extends ICartesian2dCoordinates<T, U> {

    /**
     * Retrieves the z-coordinate of the Cartesian coordinates in a 3-dimensional space.
     *
     * @return the z-coordinate
     */
    V getZ();
    
    /**
     * Sets the z-coordinate value for the Cartesian coordinates in a 3-dimensional space.
     *
     * @param z the new z-coordinate value
     */
    void setZ(V z);
}