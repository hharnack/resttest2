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
import models.Daycare;
import models.Training;

/**
 *
 * @author 640195
 */
public class AppointmentService {

    private AppointmentDB adb;

    public AppointmentService() {
        adb = new AppointmentDB();
    }

    public boolean insert(Boarding bAppt) {
        return adb.insert(bAppt);
    }

    public boolean insert(Training tAppt) {
        return adb.insert(tAppt);
    }

    public boolean insert(Daycare dAppt) {
        return adb.insert(dAppt);
    }

    public boolean update(Boarding boarding) {
        return adb.update(boarding);
    }

    public ArrayList<Appointment> getAppointmentsByUsername(String username) {
        return adb.getAppointmentsByUsername(username);
    }

    public ArrayList<Appointment> getAllAppointments() {
        return adb.getAllAppointments();
    }

    public boolean update(Training tAppt) {
        return adb.update(tAppt);
    }

    public boolean update(Daycare dAppt) {
        return adb.update(dAppt);
    }

    public boolean delete(int id) {
        return adb.delete(id);
    }
}
