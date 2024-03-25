package es.bulkynaden.common;

/**
 * The {@code IFirstNameHolder} interface defines methods for getting and setting the first name.
 */
public interface IFirstNameHolder {

    /**
     * Retrieves the first name.
     *
     * @return The first name as a {@code String}. If the first name is null, it returns null.
     */
    String getFirstName();

    /**
     * Sets the first name of the object.
     *
     * @param firstName The first name to be set. It should be a non-null {@code String}.
     */
    void setFirstName(String firstName);
}