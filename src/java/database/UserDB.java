package database;

import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Address;
import models.UserV2;

public class UserDB {

    public int insert(User user) throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        try {
            String preparedQuery = "INSERT INTO users (username, password, firstname, lastname, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());
            ps.setString(5, user.getEmail());
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot insert " + user.toString(), ex);
            throw new NotesDBException("Error inserting user");
        } finally {
            pool.freeConnection(connection);
        }
    }

    public int update(User user) throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        try {
            String preparedSQL = "UPDATE users SET password = ?, firstname = ?, lastname = ?, email = ? WHERE username = ?";

            PreparedStatement ps = connection.prepareStatement(preparedSQL);

            ps.setString(1, user.getPassword());
            ps.setString(2, user.getFirstname());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getUsername());

            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot update " + user.toString(), ex);
            throw new NotesDBException("Error updating user");
        } finally {
            pool.freeConnection(connection);
        }
    }

    public List<User> getAll() throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement("SELECT * FROM users;");
            rs = ps.executeQuery();
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email")));
            }
            pool.freeConnection(connection);
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            throw new NotesDBException("Error getting Users");
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
    }

    /**
     * Get a single user by their username.
     *
     * @param username The unique username.
     * @return A User object if found, null otherwise.
     * @throws NotesDBException
     */
    public User getUser(String username) throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM users WHERE username = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, username);
            rs = ps.executeQuery();

            User user = null;
            while (rs.next()) {
                user = new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"));
            }
            pool.freeConnection(connection);
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            throw new NotesDBException("Error getting Users");
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
    }

    public int delete(User user) throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String preparedQuery = "DELETE FROM users WHERE username = ?";
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(preparedQuery);
            ps.setString(1, user.getUsername());
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot delete " + user.toString(), ex);
            throw new NotesDBException("Error deleting User");
        } finally {
            pool.freeConnection(connection);
        }
    }

    public int insertV2(UserV2 user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryAccount = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot insert " + user.toString(), ex);
        } finally {
            pool.freeConnection(connection);
        }

        return 0;
    }
}
