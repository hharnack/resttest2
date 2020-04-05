package models;

/**
 * Base class for an appointment object. Contains all of the attributes shared
 * by all appointment types.
 *
 * @author Carsen Johns
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
    String dogNames;
    boolean deleted;

    /**
     * Default constructor.
     */
    public Appointment() {

    }

    /**
     * Constructor to instantiate all of the attributes.
     * @param idNumber The appointment id number.
     * @param dogIdNumber The dog id number.
     * @param username The username that the dog belongs to.
     * @param startTime The starting time for the appointment.
     * @param endTime The ending time for the appointment.
     * @param total The total cost of the appointment.
     * @param amountPaid The amount currently paid.
     * @param isApproved If the appointment has been approved by an administrator.
     * @param isCancelled If the user or administrator has canceled the appointment.
     * @param isPaid If the appointment has been paid in full.
     * @param type The type of appointment.
     * @param additionalComments Any additional comments left by the booker.
     * @param dogNames If any other dogs are sharing an appointment.
     */
    public Appointment(int idNumber, String dogIdNumber, String username, String startTime, String endTime, double total, double amountPaid, boolean isApproved, boolean isCancelled, boolean isPaid, String type, String additionalComments, String dogNames) {
        this.idNumber = idNumber;
        this.dogIdNumber = dogIdNumber;
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
        this.dogNames = dogNames;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getDogIdNumber() {
        return dogIdNumber;
    }

    public void setDogIdNumber(String dogIdNumber) {
        this.dogIdNumber = dogIdNumber;
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

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public boolean isIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    public String getDogNames() {
        return dogNames;
    }

    public void setDogNames(String dogNames) {
        this.dogNames = dogNames;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
