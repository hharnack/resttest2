package models;

/**
 * This class contains information and operations to create a user object.
 *
 * @author Hans Cabrera
 */
public class User {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Address address;
    private String email;
    private String phoneNumber;
    private String emergencyPhone;
    private String emergencyName;
    private boolean isActive;
    private boolean isDisabled;
    private boolean admin;

    /**
     * Default constructor that instantiates an address object.
     */
    public User() {
        this.address = new Address();
    }

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username The username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password The password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the first name.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName The first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName The last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the address.
     *
     * @return The address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address The address.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets the email address.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     *
     * @param email The email address.
     */
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * Gets the emergency phone number.
     *
     * @return The emergency phone number.
     */
    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    /**
     * Sets the emergency phone number.
     *
     * @param emergencyPhone The emergency phone number.
     */
    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    /**
     * Gets the emergency contact name.
     *
     * @return The emergency contact name.
     */
    public String getEmergencyName() {
        return emergencyName;
    }

    /**
     * Sets the emergency contact name.
     *
     * @param emergencyName The emergency contact name.
     */
    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    /**
     * Indicates whether the account is active or not.
     *
     * @return true if the account is active.
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Sets whether the account is active or not.
     *
     * @param isActive if the account is active or not.
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Indicates whether the account is disabled or not.
     *
     * @return true if the account is disabled.
     */
    public boolean isIsDisabled() {
        return isDisabled;
    }

    /**
     * Sets whether the account is disabled or not.
     *
     * @param isDisabled whether the account is disabled.
     */
    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    /**
     * Indicates whether the account is of administrative type.
     *
     * @return true if the account is of administrative type.
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Sets whether the account is of administrative type.
     *
     * @param admin if the account is of administrative type.
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
