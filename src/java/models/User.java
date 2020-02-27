package models;

import javax.json.Json;
import javax.json.JsonObject;

public class User {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Address address;
    private Veterinarian veterinarian; // Unused at the time
    private String email;
    private String phoneNumber;
    private String emergencyPhone;
    private String emergencyName;
    private boolean isActive;
    private boolean isDisabled;

    public User() {
        this.address = new Address();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }
    
    public javax.json.JsonObject toJSON() {
        JsonObject jo = Json.createObjectBuilder()
                .add("username", username)
                .add("password", password)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("email", email)
                .add("phone", phoneNumber)
                .add("emergencyPhone", emergencyPhone)
                .add("emergencyName", emergencyName)
                .add("address", address.toJSON())
                .add("veterinarian", veterinarian.toJSON())
                .build();
        return jo;
    }
}
