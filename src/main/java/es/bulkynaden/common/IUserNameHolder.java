package es.bulkynaden.common;

/**
 * The {@code IUserNameHolder} interface defines the contract for an object that holds a username.
 * It provides methods for getting and setting the username.
 */
public interface IUserNameHolder {

    /**
     * Gets the username associated with this object.
     *
     * @return the username
     */
    String getUserName();

    /**
     * Sets the username for this object.
     *
     * @param userName the username to be set
     */
    void setUserName(String userName);
}