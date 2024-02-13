package es.bulkynaden.common.classes.geo;

/**
 * The {@code ICoordinates} interface represents a contract for coordinates.
 * It serves as a base interface for various coordinate types, such as Cartesian and geographic coordinates.
 *
 * <p>
 * Coordinates typically have an x-coordinate and a y-coordinate, but different coordinate types may have additional properties.
 *
 * <p>
 * Implementations of this interface should provide methods to get and set the coordinate values.
 *
 * <p>
 * The specific coordinate type can be determined by the implementing class.
 *
 * @see ICartesian2dCoordinates
 * @see ICartesian3dCoordinates
 * @see IGeographicCoordinates
 */
public interface ICoordinates {
}