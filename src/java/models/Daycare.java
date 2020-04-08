package models;

/**
 *  Daycare appointment object child class
 * @author 640195
 */
public class Daycare extends Appointment{
    
    /**
     *
     * Constructor for daycare appointment
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
     * @param dogNames
     */
    public Daycare(int idNumber, String dogid, String username, String startTime, String endTime, double total, double amountPaid, boolean isApproved, boolean isCancelled, boolean isPaid, String type, String additionalComments, String dogNames) {
        super(idNumber, dogid, username, startTime, endTime, total, amountPaid, isApproved, isCancelled, isPaid, type, additionalComments, dogNames);
    }

    /**
     * Default constructor
     */
    public Daycare() {
        super();
    }

    
}
