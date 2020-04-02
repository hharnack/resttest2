package services;

import database.UserDB;
import java.util.ArrayList;
import models.Address;
import models.User;

/**
 * This class is used to allow the RESTful API classes to access the database
 * and tables that are associated with user information.
 *
 * @author Hans Cabrera
 */
public class AccountService {

    /**
     * An instance of the UserDB class.
     */
    private final UserDB udb;

    /**
     * Default constructor that instantiates the UserDB object.
     */
    public AccountService() {
        udb = new UserDB();
    }

    /**
     * Checks the database if the specified username already exists.
     *
     * @param username The username to check.
     * @return true if an account with the specified username already exists
     * within the system.
     */
    public boolean checkUsername(String username) {
        return udb.checkUsername(username);
    }

    /**
     * Checks the database if the specified email address already exists.
     *
     * @param email The email address to check.
     * @return true if an account with the specified email address already
     * exists within the system.
     */
    public boolean checkEmail(String email) {
        return udb.checkEmail(email);
    }

    /**
     * Creates a new user and inserts the information into the database.
     *
     * @param user A user object.
     * @return true if the user was successfully inserted into the database.
     */
    public boolean register(User user) {
        return udb.insert(user) > 0;
    }

    /**
     * Updates the user information.
     *
     * @param user A user object.
     * @return true if the user information was successfully updated.
     */
    public boolean updateUser(User user) {
        return udb.updateUser(user) > 0;
    }

    /**
     * Updates the password in the database that is associated with the
     * specified username.
     *
     * @param username The username to change the password under.
     * @param password The new password.
     * @return true if the password was successfully updated.
     */
    public boolean changePassword(String username, String password) {
        return udb.changePassword(username, password) > 0;
    }

    /**
     * Queries the database to check the entered username and password
     * credentials.
     *
     * @param username The entered username.
     * @param password The entered password.
     * @return true if the specified username and password are valid.
     */
    public boolean login(String username, String password) {
        return udb.login(username, password);
    }

    /**
     * Gets the information of an account associated with the specified
     * username.
     *
     * @param username The username of the account information to retrieve.
     * @return A user object.
     */
    public User getUser(String username) {
        return udb.getUser(username);
    }

    /**
     * Gets the address information associated with the specified username.
     *
     * @param username The username of the address to retrieve.
     * @return An address object.
     */
    public Address getUserAddress(String username) {
        return udb.getUserAddress(username);
    }

    /**
     * Performs a soft delete on the account associated with the specified
     * username. A soft delete only sets the isactive column in the database to
     * false.
     *
     * @param username The username of the account to soft delete.
     * @return true if the isactive column was successfully updated,
     */
    public boolean delete(String username) {
        return udb.deleteUser(username) > 0;
    }

    /**
     * Gets all of the registered users within the database.
     *
     * @return A list of all users in the system.
     */
    public ArrayList<User> getUsers() {
        return udb.getUsers();
    }
}
