package es.bulkynaden.common.geo;


/**
 * The {@code IAddressHolder} interface represents an object that holds an address.
 * It provides methods to get and set the address of the object.
 */
public interface IAddressHolder {

    /**
     * Returns the address held by the object.
     *
     * @return the address held by the object
     */
    String getAddress();

    /**
     * Sets the address of the object.
     *
     * @param address the address to be set
     */
    void setAddress(String address);
}