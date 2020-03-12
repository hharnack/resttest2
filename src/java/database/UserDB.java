package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Address;
import models.User;

public class UserDB {

    /**
     *
     * @param username
     * @return true if the specified username is already in use
     */
    public boolean checkUsername(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT username FROM users WHERE username = ?";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, username);
            rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() != 0) {
                return true;
            }

        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot check username", e);
        } finally {
            pool.freeConnection(connection);
        }
        return false;
    }

    /**
     *
     * @param email
     * @return true if the specified email is already in use
     */
    public boolean checkEmail(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT email FROM users WHERE email = ?";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, email);
            rs = ps.executeQuery();

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

    /**
     *
     * @param user
     * @return
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

            if (ps.executeUpdate() != 0){
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

    public boolean login(String username, String password) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String queryPassword = "SELECT username FROM users WHERE password = ? AND username = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(queryPassword);
            ps.setString(1, password);
            ps.setString(2, username);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() != 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot find login match", e);
        } finally {
            pool.freeConnection(connection);
        }
        return false;
    }

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
                user.setAddress(getUserAddress(username));
                user.setAdmin(rs.getBoolean("is_admin"));
                return user;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot return user information", e);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }

    public Address getUserAddress(String username) {
        // TODO query address table using username
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
}
