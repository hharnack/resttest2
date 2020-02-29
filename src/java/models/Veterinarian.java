package models;

import javax.json.Json;
import javax.json.JsonObject;

public class Veterinarian {

    String name;
    String clinic;
    String phoneNumber;

    public Veterinarian() {
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
