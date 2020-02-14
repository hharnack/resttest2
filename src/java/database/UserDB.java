package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class UserDB {
    
    /**
     * 
     * @param username
     * @return true if the specified username is already in use
     */
    public boolean checkUsername(String username) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        String selectSQL = "SELECT username FROM users WHERE username = ?";
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            if (rs.getFetchSize() != 0) {
                return true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * 
     * @param email
     * @return true if the specified email is already in use
     */
    public boolean checkEmail(String email) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        String selectSQL = "SELECT email FROM users WHERE email = ?";
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            if (rs.getFetchSize() != 0) {
                return true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
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
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot insert " + user.toString(), ex);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }
}
