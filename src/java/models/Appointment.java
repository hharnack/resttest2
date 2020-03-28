/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 640195
 */
public class Appointment {
    int idNumber;
    String dogIdNumber;
    String username;
    String startTime;
    String endTime;
    double total;
    double amountPaid;
    boolean isApproved;
    boolean isCancelled;
    boolean isPaid;
    String type;
    String additionalComments;

    public Appointment(int idNumber, String dogIdNumber, String username, String startTime, String endTime, double total, double amountPaid, boolean isApproved, boolean isCancelled, boolean isPaid, String type, String additionalComments) {
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
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Appointment() {
    }

    public String getDogIdNumber() {
        return dogIdNumber;
    }

    public void setDogIdNumber(String dogIdNumber) {
        this.dogIdNumber = dogIdNumber;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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
