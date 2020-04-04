package models;

/**
 * This class contains information and operations to create a veterinarian
 * object.
 *
 * @author Hans Cabrera
 */
public class Veterinarian {

    private int idNumber;
    private String name;
    private String clinic;
    private String phoneNumber;

    /**
     * Default constructor.
     */
    public Veterinarian() {

    }

    /**
     * Constructor to set all attributes.
     *
     * @param idNumber The id number.
     * @param name The name.
     * @param clinic The clinic name.
     * @param phoneNumber The phone number.
     */
    public Veterinarian(int idNumber, String name, String clinic, String phoneNumber) {
        this.idNumber = idNumber;
        this.name = name;
        this.clinic = clinic;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the id number.
     *
     * @return The id number.
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * Sets the id number.
     *
     * @param idNumber The id number.
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Gets the name.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name The name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the clinic name.
     *
     * @return The clinic name.
     */
    public String getClinic() {
        return clinic;
    }

    /**
     * Sets the clinic name.
     *
     * @param clinic The clinic name.
     */
    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    /**
     * Gets the phone number.
     *
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber The phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
