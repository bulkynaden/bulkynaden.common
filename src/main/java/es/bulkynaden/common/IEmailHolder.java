package es.bulkynaden.common;

/**
 * The {@code IEmailHolder} interface defines the contract for an object that holds an email address.
 * It provides methods for getting and setting the email address.
 */
public interface IEmailHolder {
    /**
     * This method returns the email address stored in the object implementing the {@code IEmailHolder} interface.
     *
     * @return The email address stored in the object.
     */
    String getEmail();

    /**
     * This method sets the email address in the object implementing the IEmailHolder interface.
     *
     * @param email The email address to be set.
     */
    void setEmail(String email);
}