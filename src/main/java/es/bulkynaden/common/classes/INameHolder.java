package es.bulkynaden.common.classes;

/**
 * The {@code INameHolder} interface represents an object that holds a name.
 * It provides methods to get and set the name of the object.
 */
public interface INameHolder {
    /**
     * Returns the name of the object.
     *
     * @return the name of the object
     */
    String getName();

    /**
     * Sets the name of the object.
     *
     * @param name the new name for the object
     */
    void setName(String name);
}