package models;

import javax.json.Json;
import javax.json.JsonObject;

public class Veterinarian {
    
    public javax.json.JsonObject toJSON() {
        // TODO
        JsonObject jo = Json.createObjectBuilder()
                .add("TODO", "Not Yet Implemented")
                .build();
        return jo;
    }
}