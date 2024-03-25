package es.bulkynaden.common.geo;

import es.bulkynaden.common.INameHolder;

/**
 * The {@code ICountry} interface represents a country object.
 * It extends the {@code INameHolder}, {@code ICapitalCityHolder}, and {@code IAutonomousCommunityCollectionHolder} interfaces.
 * <p>
 * The {@code INameHolder} interface provides methods to get and set the name of the country.
 * The {@code ICapitalCityHolder} interface provides methods to get and set the capital city of the country.
 * The {@code IAutonomousCommunityCollectionHolder} interface provides methods to retrieve and modify a collection of autonomous communities associated with the country.
 *
 * @see INameHolder
 * @see ICapitalCityHolder
 * @see IAutonomousCommunityCollectionHolder
 */
public interface ICountry extends INameHolder, ICapitalCityHolder, IAutonomousCommunityCollectionHolder {
}