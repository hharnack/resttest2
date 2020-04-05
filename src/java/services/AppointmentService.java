package services;

import database.AppointmentDB;
import java.util.ArrayList;
import models.Appointment;
import models.Boarding;
import models.Daycare;
import models.Training;

/**
 * This class is used to allow the RESTful API classes to access the database
 * and tables that are associated with appointment information.
 *
 * @author 640195
 */
public class AppointmentService {

    private final AppointmentDB adb;

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
}
