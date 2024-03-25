package es.bulkynaden.common.geo;

import es.bulkynaden.common.INameHolder;


/**
 * The {@code IGeoLocation} interface extends the {@code INameHolder} and {@code ICoordinatesHolder}
 * interfaces. It represents geographic coordinates consisting of a name and an instance of
 * {@code IGeographicCoordinates}.
 *
 * <p>
 * The name represents the name of the location associated with the coordinates. The geographic coordinates
 * represent the longitude, latitude, and altitude values of the location.
 *
 * <p>
 * This interface provides methods to get and set the name and coordinates.
 *
 * @see INameHolder
 * @see ICoordinatesHolder
 * @see IGeographicCoordinates
 */
public interface IGeoLocation extends ICityHolder, IAddressHolder, ICoordinatesHolder<IGeographicCoordinates> {
}