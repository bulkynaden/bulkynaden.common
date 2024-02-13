package es.bulkynaden.common.classes.geo;

/**
 * The {@code ICityHolder} interface represents an object that holds an {@code ICity}.
 * It provides methods to get and set the city of the object.
 */
public interface ICityHolder {

    /**
     * Gets the city held by the {@code ICityHolder} object.
     *
     * @return the city held by the object
     */
    ICity getCity();

    /**
     * Sets the city for this {@code ICityHolder} object.
     *
     * @param city the {@code ICity} object to set as the city for this object
     */
    void setCity(ICity city);
}