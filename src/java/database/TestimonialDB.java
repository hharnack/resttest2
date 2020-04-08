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
 * This class is used to perform all queries required by the system to manage
 * all information regarding testimonials.
 *
 * @author Hans Cabrera
 */
public class TestimonialDB {

    /**
     * Queries the database to insert a testimonial.
     *
     * @param testimonial a testimonial object.
     * @return the number of rows insert, should only be 0 or 1.
     */
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

    /**
     * Queries the database to update the isapproved column of a row with the
     * specified id number.
     *
     * @param id The id number of the testimonial to approve.
     * @return The number of rows updated, should only be 0 or 1.
     */
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

    /**
     * Queries the database to delete a testimonial from the database with the
     * specified id number.
     *
     * @param id The id number of the testimonial to delete.
     * @return The number of rows deleted, should only be 0 or 1.
     */
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

    /**
     * Queries the database to get all the testimonials that have true in the
     * isapproved column to display on the website.
     *
     * @return A list of all approved testimonials.
     */
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

    /**
     * Queries the database to get all the testimonials that have false in the
     * isapproved column for the admin to review.
     *
     * @return A list of all not approved testimonials.
     */
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
