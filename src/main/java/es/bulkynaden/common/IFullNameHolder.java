package es.bulkynaden.common;

/**
 * The {@code IFullNameHolder} interface extends the {@code IFirstNameHolder} and {@code ILastNameHolder} interfaces.
 * It provides a method to construct a full name by concatenating the first name and the last name. The method handles
 * null values gracefully and returns the full name as a string, making sure that no "null" strings are included.
 */
public interface IFullNameHolder extends IFirstNameHolder, ILastNameHolder {

    /**
     * Constructs a full name by concatenating the first name and the last name.
     * This method handles null values gracefully, ensuring that no "null" strings
     * are included in the full name.
     *
     * @return A string representing the full name, which is a concatenation of
     * the first name and the last name, separated by a space. If either the
     * first name or the last name is null, it returns the non-null name without
     * additional spaces. If both are null, it returns an empty string.
     */
    default String getFullName() {
        String firstName = getFirstName();
        String lastName = getLastName();

        if (firstName == null && lastName == null) {
            return "";
        } else if (firstName == null) {
            return lastName;
        } else if (lastName == null) {
            return firstName;
        } else {
            return firstName + " " + lastName;
        }
    }
}