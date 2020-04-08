package models;

/**
 * Appointment object super class
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
    String dogNames;
    boolean deleted;

    /**
     * getter for deleted
     * @return
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     *setter for deleted
     * @param deleted
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     *getter for dogNames
     * @return
     */
    public String getDogNames() {
        return dogNames;
    }

    /**
     *setter for dogNames
     * @param dogNames
     */
    public void setDogNames(String dogNames) {
        this.dogNames = dogNames;
    }
    
    /**
     *Constructor for appointment
     * 
     * 
     * @param idNumber
     * @param dogIdNumber
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
    public Appointment(int idNumber, String dogIdNumber, String username, String startTime, String endTime, double total, double amountPaid, boolean isApproved, boolean isCancelled, boolean isPaid, String type, String additionalComments, String dogNames) {
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
        this.dogNames = dogNames;
    }

    /**
     *getter for type
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *setter for type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *default constructor
     */
    public Appointment() {
    }

    /**
     *getter for dogIDNumber
     * @return
     */
    public String getDogIdNumber() {
        return dogIdNumber;
    }

    /**
     *setter for dogIdNumber
     * @param dogIdNumber
     */
    public void setDogIdNumber(String dogIdNumber) {
        this.dogIdNumber = dogIdNumber;
    }
    
    /**
     *getter for appointment idNumber
     * @return
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     *setter for idNumber
     * @param idNumber
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     *getter for userName
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *setter for userName
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *getter for startTime
     * @return
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     *setter for startTime
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     *getter for endTime
     * @return
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     *setter for endTime
     * @param endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     *getter for total
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     *setter for total
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     *getter for ammountPaid
     * @return
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     *setter for amountPaid
     * @param amountPaid
     */
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     *getter for approved
     * @return
     */
    public boolean IsApproved() {
        return isApproved;
    }

    /**
     *setter for approved
     * @param isApproved
     */
    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    /**
     *getter for isCancelled
     * @return
     */
    public boolean isCancelled() {
        return isCancelled;
    }

    /**
     *setter for isCancelled
     * @param isCancelled
     */
    public void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    /**
     *getter for paid
     * @return
     */
    public boolean isPaid() {
        return isPaid;
    }

    /**
     *setter for isPaid
     * @param isPaid
     */
    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    /**
     *getter for additionalComments
     * @return
     */
    public String getAdditionalComments() {
        return additionalComments;
    }

    /**
     *setter for additionalComments
     * @param additionalComments
     */
    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }
}
