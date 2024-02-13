package es.bulkynaden.common.classes.geo;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The {@code GeographicCoordinates} class represents geographic coordinates consisting of
 * longitude, latitude, and altitude. It implements the {@code IGeographicCoordinates} interface.
 *
 * <p>
 * The longitude represents the angular distance of a point east or west of the prime meridian.
 * The latitude represents the angular distance of a point north or south of the equator.
 * The altitude represents the vertical distance of a point above or below a reference surface,
 * such as sea level.
 *
 * @see IGeographicCoordinates
 */
@Data
@EqualsAndHashCode(of = {"latitude", "longitude", "altitude"})
public class GeographicCoordinates implements IGeographicCoordinates {
    private double latitude;
    private double longitude;
    private double altitude;
}
