package models;

import javax.json.Json;
import javax.json.JsonObject;

public class Veterinarian {
    
    private String name;
    private String clinic;
    private String phoneNumber;


    public Veterinarian() {
    }

    public Veterinarian(String name, String clinic, String phoneNumber) {
        this.name = name;
        this.clinic = clinic;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public javax.json.JsonObject toJSON() {
        // TODO
        JsonObject jo = Json.createObjectBuilder()
                .add("TODO", "Not Yet Implemented")
                .build();
        return jo;
    }
}