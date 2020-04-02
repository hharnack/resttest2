package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Address;
import models.User;

/**
 * This class contains all of the operations to manage data associated with user
 * data.
 *
 * @author Hans Cabrera
 */
public class UserDB {

    //SELECT QUERIES
    /**
     * Queries the database to check if a login attempt is valid and the account
     * is active.
     *
     * @param username The entered username.
     * @param password The entered password.
     * @return true if the login credentials match.
     */
    public boolean login(String username, String password) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT username, isactive FROM users WHERE password = ? AND username = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, username);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() != 0) {
                return rs.getBoolean("isactive");
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot find login match", e);
        } finally {
            pool.freeConnection(connection);
        }
        return false;
    }

    /**
     * Queries the database to check if the account is an administrative
     * account.
     *
     * @param username The entered username.
     * @return true if the account is of administrative type.
     */
    public boolean checkAdmin(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT isadmin FROM users WHERE username = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            return ps.executeQuery().getBoolean("isadmin");
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }

        return false;
    }

    /**
     * Queries the database to select a user based on the specified username.
     *
     * @param username The specified username.
     * @return A user object.
     */
    public User getUser(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryUser = "SELECT * FROM users WHERE username = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(queryUser);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() > 0) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setEmergencyName(rs.getString("emergency_name"));
                user.setEmergencyPhone(rs.getString("emergency_phone"));
                user.setIsActive(rs.getBoolean("isactive"));
                user.setAdmin(rs.getBoolean("isadmin"));
                user.setAddress(getUserAddress(username));
                return user;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot return user information", e);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    /**
     * Queries the database to retrieve the user's address information. This
     * method called by the getUser and getUsers methods to instantiate the
     * Address object within the user class.
     *
     * @param username The username that is associated with the address.
     * @return An address object.
     */
    public Address getUserAddress(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAddress = "SELECT * FROM user_address WHERE username = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(queryAddress);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() > 0) {
                Address add = new Address();
                add.setBuildingNum(rs.getString("building_num"));
                add.setHouseNum(rs.getString("house_apt_num"));
                add.setStreetName(rs.getString("street"));
                add.setCity(rs.getString("city"));
                add.setProvince(rs.getString("province"));
                add.setPostal(rs.getString("postal"));
                return add;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot return address information", e);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    /**
     * Queries the database to check if an account under the specified username
     * already exists.
     *
     * @param username The username to check.
     * @return true if the specified username is already in use.
     */
    public boolean checkUsername(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT username, isactive FROM users WHERE username = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(selectSQL);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() != 0) {
                return rs.getBoolean("isactive");
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot check username", e);
        } finally {
            pool.freeConnection(connection);
        }
        return false;
    }

    /**
     * Queries the database to return all user information, including users
     * whose isactive column is set to false.
     *
     * @return A list of all users in the database.
     */
    public ArrayList<User> getUsers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM users";

        try {
            ResultSet rs = connection.prepareStatement(query).executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setEmergencyName(rs.getString("emergency_name"));
                user.setEmergencyPhone(rs.getString("emergency_phone"));
                user.setIsActive(rs.getBoolean("isactive"));
                user.setAdmin(rs.getBoolean("isadmin"));
                user.setAddress(getUserAddress(user.getUsername()));
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    /**
     * Queries the database to check if an account under the specified email
     * address already exists.
     *
     * @param email The email to check.
     * @return true if the specified email is already in use
     */
    public boolean checkEmail(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT email FROM users WHERE email = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(selectSQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() != 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot check email", e);
        } finally {
            pool.freeConnection(connection);
        }
        return false;
    }

    //INSERT QUERIES
    /**
     * Queries the database to insert a new user.
     *
     * @param user A user object.
     * @return The number of rows inserted, should only be 0 or 1.
     */
    public int insert(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAccount = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String queryAddress = "INSERT INTO user_address VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareCall(queryAccount);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPhoneNumber());
            ps.setString(7, user.getEmergencyPhone());
            ps.setString(8, user.getEmergencyName());
            ps.setBoolean(9, true);
            ps.setBoolean(10, user.isIsDisabled());
            ps.setBoolean(11, user.isAdmin());

            if (ps.executeUpdate() != 0) {
                ps = connection.prepareCall(queryAddress);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getAddress().getBuildingNum());
                ps.setString(3, user.getAddress().getHouseNum());
                ps.setString(4, user.getAddress().getStreetName());
                ps.setString(5, user.getAddress().getCity());
                ps.setString(6, user.getAddress().getProvince());
                ps.setString(7, user.getAddress().getPostal());
                return ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot insert " + user.toString(), ex);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }

    //UPDATE QUERIES
    /**
     * Queries the database to update user information.
     *
     * @param user A user object.
     * @return The number of rows updated, should only be 0 or 1.
     */
    public int updateUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAcctUpdate = "UPDATE users SET first_name = ?, last_name = ?, email = ?, phone_number = ?, emergency_phone = ?, emergency_name = ? WHERE username = ?";
        String queryAddrUpdate = "UPDATE user_address SET building_num = ?, house_apt_num = ?, street = ?, city = ?, province = ?, postal = ? WHERE username = ?";

        try {
            // Query account update
            PreparedStatement ps = connection.prepareCall(queryAcctUpdate);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhoneNumber());
            ps.setString(5, user.getEmergencyPhone());
            ps.setString(6, user.getEmergencyName());
            ps.setString(7, user.getUsername());
            ps.executeUpdate();

            if (ps.executeUpdate() != 0) {
                // Query address update
                ps = connection.prepareCall(queryAddrUpdate);
                ps.setString(1, user.getAddress().getBuildingNum());
                ps.setString(2, user.getAddress().getHouseNum());
                ps.setString(3, user.getAddress().getStreetName());
                ps.setString(4, user.getAddress().getCity());
                ps.setString(5, user.getAddress().getProvince());
                ps.setString(6, user.getAddress().getPostal());
                ps.setString(7, user.getUsername());

                return ps.executeUpdate();
            }

        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot insert " + user.toString(), e);
        } finally {
            pool.freeConnection(connection);
        }

        return 0;
    }

    /**
     * Queries the database to change the password under the specified username.
     *
     * @param username The username of the password to change.
     * @param password The new password.
     * @return The number of rows updated, should only be 0 or 1.
     */
    public int changePassword(String username, String password) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryPassword = "UPDATE users SET password = ? WHERE username = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(queryPassword);
            ps.setString(1, password);
            ps.setString(2, username);
            return ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot update password", e);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }

    //PSEUDO DELETE QUERIES
    /**
     * This method is used to perform a pseudo delete on a row in the database
     * by setting the isactive column to false in the row where the specified
     * username is given.
     *
     * @param username the username of the account to pseudo delete
     * @return the number of rows update, should only ever be 0 or 1
     */
    public int deleteUser(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "UPDATE users SET isactive = false WHERE username = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }

        return 0;
    }
}
