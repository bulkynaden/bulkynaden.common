package es.bulkynaden.common;

/**
 * The {@code ILastNameHolder} interface defines methods for getting and setting the last name.
 */
public interface ILastNameHolder {

    /**
     * Retrieves the last name.
     *
     * @return The last name as a {@code String}. If the last name is null, it returns null.
     */
    String getLastName();

    /**
     * Sets the last name of the object.
     *
     * @param lastName The last name to be set. Can be null.
     */
    void setLastName(String lastName);
}