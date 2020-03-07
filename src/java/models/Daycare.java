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
public class Daycare extends Appointment{

    public Daycare(int idNumber, String username, Date startTime, Date endTime, double total, double amountPaid, boolean isApproved, boolean isCancelled, boolean isPaid, String additionalComments) {
        super(idNumber, username, startTime, endTime, total, amountPaid, isApproved, isCancelled, isPaid, additionalComments);
    }


    public Daycare() {
        super();
    }

    
}
