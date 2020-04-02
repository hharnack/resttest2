/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.TestimonialDB;
import java.util.ArrayList;
import models.Testimonial;

/**
 *
 * @author 703174
 */
public class TestimonialService {

    /**
     * An instance of the TestimonialDB class.
     */
    private final TestimonialDB tdb;

    /**
     * Default constructor that instantiates the TestimonialDB object.
     */
    public TestimonialService() {
        tdb = new TestimonialDB();
    }

    /**
     * Inserts a testimonial into the system. All testimonial's is approved
     * column is automatically set to false.
     *
     * @param testimonial The submitted testimonial.
     * @return true if the testimonial was successfully inserted into the
     * database.
     */
    public boolean insert(Testimonial testimonial) {
        return tdb.insert(testimonial) > 0;
    }

    /**
     * Updates the isapproved column of a testimonial with the specified id
     * number.
     *
     * @param id The id number of the testimonial to approve.
     * @return true if the isapproved column was successfully updated.
     */
    public boolean approve(int id) {
        return tdb.approve(id) > 0;
    }

    /**
     * Deletes/disapproves the testimonial from the database.
     *
     * @param id The id number of the testimonial to delete/disapprove.
     * @return
     */
    public boolean disapprove(int id) {
        return tdb.disapprove(id) > 0;
    }

    /**
     * Gets all of the testimonials in the system where the isapproved column is
     * set to true.
     *
     * @return A list of all approved testimonials.
     */
    public ArrayList<Testimonial> getApproved() {
        return tdb.getApproved();
    }

    /**
     * Gets all of the testimonials in the system where the isapproved column is
     * set to false.
     *
     * @return A list of all pending testimonials.
     */
    public ArrayList<Testimonial> getPending() {
        return tdb.getPending();
    }

}
