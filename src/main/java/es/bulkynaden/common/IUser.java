package es.bulkynaden.common;

/**
 * The {@code IUser} interface extends multiple interfaces to provide functionality for holding user information.
 * It extends {@code IFullNameHolder}, {@code IEmailHolder}, {@code IUserNameHolder}, and {@code IPasswordHolder}.
 * Implementations of this interface will have methods for managing user information such as getting and setting
 * the user's full name, email address, username, and password.
 *
 * @see IFullNameHolder
 * @see IEmailHolder
 * @see IUserNameHolder
 * @see IPasswordHolder
 */
public interface IUser extends
        IFullNameHolder,
        IEmailHolder,
        IUserNameHolder,
        IPasswordHolder {
}