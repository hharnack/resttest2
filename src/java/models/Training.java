/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author 640195
 */
public class Training extends Appointment {

    ArrayList<String> trainingGoals;

    public Training(int idNumber, String username, Date startTime, Date endTime, double total, double amountPaid, boolean isApproved, boolean isCancelled, boolean isPaid, String additionalComments, ArrayList<String> trainingGoals) {
        super(idNumber, username, startTime, endTime, total, amountPaid, isApproved, isCancelled, isPaid, additionalComments);
        this.trainingGoals = trainingGoals;
    }

    public ArrayList<String> getTrainingGoals() {
        return trainingGoals;
    }

    public void setTrainingGoals(ArrayList<String> trainingGoals) {
        this.trainingGoals = trainingGoals;
    }

}
