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
public class Appointment {
    int idNumber;
    int dogIdNumber;
    String username;
    Date startTime;
    Date endTime;
    double total;
    double amountPaid;
    boolean isApproved;
    boolean isCancelled;
    boolean isPaid;
    String additionalComments;

    public Appointment(int idNumber, int dogIdNumber, String username, Date startTime, Date endTime, double total, double amountPaid, boolean isApproved, boolean isCancelled, boolean isPaid, String additionalComments) {
        this.idNumber = idNumber;
        this.dogIdNumber=dogIdNumber;
        this.username = username;
        this.startTime = startTime;
        this.endTime = endTime;
        this.total = total;
        this.amountPaid = amountPaid;
        this.isApproved = isApproved;
        this.isCancelled = isCancelled;
        this.isPaid = isPaid;
        this.additionalComments = additionalComments;
    }
    public Appointment(){};
     public int getDogIdNumber() {
        return dogIdNumber;
    }

    public void setDogIdNumber(int dogIdNumber) {
        this.dogIdNumber=dogIdNumber;
    }
    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public boolean IsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }
       
}
