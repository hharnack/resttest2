package rest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import java.sql.Date;  
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import models.Dog;

/**
 *
 * @author 703174
 */
@Path("registerDog")
public class RegisterDog {

    public RegisterDog() {

    }

    @Context
    private UriInfo context;

    /**
     * PUT method for updating or creating an instance of
     *
     * @param content representation for the resource
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        JsonParser parser = Json.createParser(new StringReader(content));
        Dog dog = new Dog();

        parser.next();       // START_OBJECT

        // {dogname, breed, dob, gender, weight, neuteredspayed, medication, allergies, physlimit, veterinarian, stranger, larger, small, puppy, da2pp, rabies, bordetella}
        
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        dog.setName(parser.getString());
        
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        dog.setBreed(parser.getString());
        
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        Date dob = Date.valueOf(parser.getString());
        dog.setDateOfBirth(dob);
        
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        dog.setGender(parser.getString());
        
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        dog.setWeight(Double.parseDouble(parser.getString()));
        
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        if(parser.getString().equals("yes")){
            dog.setSpayedNeutered(true);
        } else {
            dog.setSpayedNeutered(false);
        }
        
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        // something
        
        return null;
    }
}
