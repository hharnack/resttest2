package rest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.UserV2;
import services.AccountService;

/**
 *
 * @author 703174
 */
@Path("register2")
public class RegisterAccountV2 {
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RegisterAccountV2
     */
    public RegisterAccountV2() {
    }

    /**
     * Retrieves representation of an instance of rest.RegisterAccountV2
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "Boo";
    }

    /**
     * PUT method for updating or creating an instance of RegisterAccountV2
     * @param content representation for the resource
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        System.out.println(content);
        UserV2 user = new UserV2();
        
        JsonParser parser = Json.createParser(new StringReader(content));
        
        JsonParser.Event event = parser.next(); // START_OBJECT
        
        // Username
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.setUsername(parser.getString());
        
        // Password first
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        parser.getString(); // Password first
        
        // Password confirm
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.setPassword(parser.getString()); // Password confirm
        
        // First Name
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.setFirstName(parser.getString());
        
        // Last Name
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.setLastName(parser.getString());
        
        // Email
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.setEmail(parser.getString());
        
        // Phone
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.setPhoneNumber(parser.getString());
        
        // Appt/House number
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.getAddress().setHouseNum(parser.getInt());
        
        // Street name
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.getAddress().setStreetName(parser.getString());
        
        // City
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.getAddress().setCity(parser.getString());
        
        // Province
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.getAddress().setProvince(parser.getString());
        
        // Postal
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.getAddress().setPostal(parser.getString());
        
        // Emergency phone
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.setEmergencyPhone(parser.getString());
        
        // Emergency contact
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        user.setEmergencyName(parser.getString());
       
        AccountService as = new AccountService();
        if(as.registerV2(user)){
            return "account registered";
        }
        return "Username already taken.";
    }
}
