/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Testimonial;

/**
 *
 * @author 703174
 */
public class TestimonialDB {
    
    public int insert(Testimonial testimonial) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "INSERT INTO testimonials (username, contents, isapproved) "
                + "VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, testimonial.getUsername());
            ps.setString(2, testimonial.getContent());
            ps.setBoolean(3, false);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TestimonialDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }
    
    public int approve(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "UPDATE testimonials SET isapproved = true WHERE test_id = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TestimonialDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }
    
    public int disapprove(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "DELETE FROM testimonials WHERE test_id = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TestimonialDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return 0;
    }
    
    public ArrayList<Testimonial> getApproved() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM testimonials WHERE isapproved = true";
        
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Testimonial> testimonials = new ArrayList<>();
            while (rs.next()) {
                testimonials.add(new Testimonial(rs.getInt("test_id"), rs.getString("username"), rs.getString("contents"), true));
            }
            return testimonials;
        } catch (SQLException ex) {
            Logger.getLogger(TestimonialDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }
    
    public ArrayList<Testimonial> getPending() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM testimonials WHERE isapproved = false";
        
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Testimonial> testimonials = new ArrayList<>();
            while (rs.next()) {
                testimonials.add(new Testimonial(rs.getInt("test_id"), rs.getString("username"), rs.getString("contents"), false));
            }
            return testimonials;
        } catch (SQLException ex) {
            Logger.getLogger(TestimonialDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.freeConnection(connection);
        }
        return null;
    }
}
