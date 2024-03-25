package es.bulkynaden.common;

/**
 * The {@code IPasswordHolder} interface defines the contract for an object that holds a password.
 * It provides methods for getting and setting the password.
 */
public interface IPasswordHolder {

    /**
     * Returns the password held by the object implementing the {@code IPasswordHolder} interface.
     *
     * @return the password as a String
     */
    String getPassword();

    /**
     * Sets a new password for the object implementing the {@code IPasswordHolder} interface.
     * This method will update the password in the object with the new specified password.
     */
    void setPassword();
}