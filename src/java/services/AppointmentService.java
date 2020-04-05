package services;

import database.AppointmentDB;
import java.util.ArrayList;
import models.Appointment;
import models.Boarding;
import models.Daycare;
import models.Training;

/**
 * Appointment service for managing the broker
 * @author 640195
 */
public class AppointmentService {
    /**
     * Instace of an appointmentDB broker
     */
    private AppointmentDB adb;

    /**
     *Constructor that creates an instance of the appointmentDB broker
     */
    public AppointmentService() {
        adb = new AppointmentDB();
    }

    /**
     *  passes boarding appointment to broker to be inserted
     * @param bAppt
     * @return boolean
     */
    public boolean insert(Boarding bAppt) {
        return adb.insert(bAppt);
    }

    /**
     *passes training appointment to broker to be inserted
     * @param tAppt
     * @return boolean
     */
    public boolean insert(Training tAppt) {
        return adb.insert(tAppt);
    }

    /**
     *passes daycare appointment to broker to be inserted
     * @param dAppt
     * @return boolean
     */
    public boolean insert(Daycare dAppt) {
        return adb.insert(dAppt);
    }

    /**
     *passes boarding appointment to broker to be updated
     * @param boarding
     * @return boolean
     */
    public boolean update(Boarding boarding) {
        return adb.update(boarding);
    }

    /**
     *Calls the broker to get all appointments by username
     * @param username
     * @return boolean
     */
    public ArrayList<Appointment> getAppointmentsByUsername(String username) {
        return adb.getAppointmentsByUsername(username);
    }

    /**
     *Calls the broker to get all appointment in the database
     * @return boolean
     */
    public ArrayList<Appointment> getAllAppointments() {
        return adb.getAllAppointments();
    }

    /**
     *passes a training appointment to the broker to be updated
     * @param tAppt
     * @return boolean
     */
    public boolean update(Training tAppt) {
        return adb.update(tAppt);
    }

    /**
     *passes a daycare appointment to the broker to be updated
     * @param dAppt
     * @return boolean
     */
    public boolean update(Daycare dAppt) {
        return adb.update(dAppt);
    }

    /**
     *passes an id of an appointment to the broker to be deleted
     * @param id
     * @return boolean
     */
    public boolean delete(int id) {
        return adb.delete(id);
    }
}
