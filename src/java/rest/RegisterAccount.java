/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

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
import services.AccountService;

/**
 * REST Web Service
 *
 * @author 553185
 */
@Path("register")
public class RegisterAccount {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RegisterAccount
     */
    public RegisterAccount() {
    }

    /**
     * Retrieves representation of an instance of rest.RegisterAccount
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
     * PUT method for updating or creating an instance of RegisterAccount
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        System.out.println(content);
        
        JsonParser parser = Json.createParser(new StringReader(content));
        
        JsonParser.Event event = parser.next(); // START_OBJECT
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        String parsedName = parser.getString();
        
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        String parsedPassword = parser.getString();
        
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        String parsedConfirmPassword = parser.getString();
        
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        String parsedFirstName = parser.getString();
        
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        String parsedLastName = parser.getString();
        
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        String parsedEmail = parser.getString();
        
        System.out.println(parsedName);
        System.out.println(parsedPassword);
         System.out.println(parsedConfirmPassword);
        System.out.println(parsedFirstName);
        System.out.println(parsedLastName);
        System.out.println(parsedEmail);

        AccountService as = new AccountService();
        boolean registered = false;
        
        if (!(as.validatePassword(parsedPassword, parsedConfirmPassword))) {
            return "Passwords do not match";
        };
        
        System.out.print("before register");
        registered = as.register(parsedName, parsedPassword, parsedFirstName, parsedLastName, parsedEmail);
        System.out.print("after register");
        if(registered){
            return "account registered";
        }
        return "Username already taken.";
    }
}
