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
    
    private TestimonialDB tdb;
    
    public TestimonialService() {
        tdb = new TestimonialDB();
    }
    
    public boolean insert(Testimonial testimonial) {
        return tdb.insert(testimonial) > 0;
    }
    
    public boolean approve(int id) {
        return tdb.approve(id) > 0;
    }
    
    public boolean disapprove(int id) {
        return tdb.disapprove(id) > 0;
    }
    
    public ArrayList<Testimonial> getApproved() {
        return tdb.getApproved();
    }
    
    public ArrayList<Testimonial> getPending() {
        return tdb.getPending();
    }
    
}
