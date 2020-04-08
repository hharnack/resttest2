package models;

/**
 *
 * @author Hans Cabrera
 */
public class Veterinarian {

    private int idNumber;
    private String vetName;
    private String clinic;
    private String phoneNumber;

    public Veterinarian() {
    }

    public Veterinarian(int idNumber, String vetName, String clinic, String phoneNumber) {
        this.idNumber = idNumber;
        this.vetName = vetName;
        this.clinic = clinic;
        this.phoneNumber = phoneNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
