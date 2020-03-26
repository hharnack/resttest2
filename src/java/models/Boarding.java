/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;


/**
 *
 * @author 640195
 */
public class Boarding extends Appointment {
    boolean grooming;
    public Boarding(int idNumber, String dogid, String username, String startTime, String endTime, double total, double amountPaid, boolean isApproved, boolean isCancelled, boolean isPaid,  String type, String additionalComments, boolean grooming, String dogNames){
        super(idNumber, dogid, username, startTime, endTime, total, amountPaid, isApproved, isCancelled, isPaid, type, additionalComments, dogNames);
        this.grooming=grooming;
    }

    public Boarding() {
        
    }

    public boolean isGrooming() {
        return grooming;
    }

    public void setGrooming(boolean grooming) {
        this.grooming = grooming;
    }
    
}
