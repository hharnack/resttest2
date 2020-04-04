package models;

/**
 *
 * @author 640195
 */
public class Daycare extends Appointment {

    public Daycare(int idNumber, String dogid, String username, String startTime, String endTime, double total, double amountPaid, boolean isApproved, boolean isCancelled, boolean isPaid, String type, String additionalComments, String dogNames) {
        super(idNumber, dogid, username, startTime, endTime, total, amountPaid, isApproved, isCancelled, isPaid, type, additionalComments, dogNames);
    }

    public Daycare() {
        super();
    }

}
