package es.bulkynaden.common.classes.geo;

/**
 * The {@code ICapitalCityHolder} interface represents an object that holds a capital city.
 * It provides methods to get and set the capital city.
 */
public interface ICapitalCityHolder {

    /**
     * Retrieves the capital city held by this object.
     *
     * @return the capital city held by this object
     */
    ICity getCapital();

    /**
     * Sets the capital city of this object.
     *
     * @param city the new capital city for this object
     */
    void setCapital(ICity city);
}