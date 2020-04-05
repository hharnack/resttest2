/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 * Boarding appointment child class
 * @author 640195
 */
public class Boarding extends Appointment {
    boolean grooming;

    /**
     * Constructor for a boarding appointment
     * 
     * @param idNumber
     * @param dogid
     * @param username
     * @param startTime
     * @param endTime
     * @param total
     * @param amountPaid
     * @param isApproved
     * @param isCancelled
     * @param isPaid
     * @param type
     * @param additionalComments
     * @param grooming
     * @param dogNames
     */
    public Boarding(int idNumber, String dogid, String username, String startTime, String endTime, double total, double amountPaid, boolean isApproved, boolean isCancelled, boolean isPaid,  String type, String additionalComments, boolean grooming, String dogNames){
        super(idNumber, dogid, username, startTime, endTime, total, amountPaid, isApproved, isCancelled, isPaid, type, additionalComments, dogNames);
        this.grooming=grooming;
    }

    /**
     * Default constructor 
     */
    public Boarding() {
        
    }

    /**
     * getter for is grooming
     * @return
     */
    public boolean isGrooming() {
        return grooming;
    }

    /**
     * setter for is grooming
     * @param grooming
     */
    public void setGrooming(boolean grooming) {
        this.grooming = grooming;
    }
    
}
