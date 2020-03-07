/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.AppointmentDB;
import java.util.ArrayList;
import models.Appointment;
import models.Boarding;

/**
 *
 * @author 640195
 */
public class AppointmentService {

    AppointmentDB adb;

    public AppointmentService() {
        adb = new AppointmentDB();
    }

    public boolean insert(Boarding bAppt) {
        return adb.insert(bAppt);
    }
    
    public boolean update(Appointment appointment) {
        return false;
    }
    
    public Appointment getAppointmentsByUsername(String username) {
        return null;
    }
    
    public ArrayList<Appointment> getAllAppointments() {
        return null;
    }
}
