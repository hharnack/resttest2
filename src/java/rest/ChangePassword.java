/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import services.AccountService;

/**
 *
 * @author 703174
 */
@Path("changepassword")
public class ChangePassword {

    public ChangePassword() {
    }
 
        @Context
    private UriInfo context;

    /**
     * Retrieves representation of an instance of rest.
     *
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
     * PUT method for updating or creating an instance of
     *
     * @param content representation for the resource
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        JsonParser parser = Json.createParser(new StringReader(content));
        JsonParser.Event event = parser.next(); // START_OBJECT
        
        // Username
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        String username = parser.getString();

        // Password First
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        String passwordFirst = parser.getString(); // Password first
        
        // Password Confirm
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        String passwordConfirm = parser.getString(); // Password first
        
        if (!passwordFirst.equals(passwordConfirm)) {
            return "Passwords do not match";
        }
        
        AccountService as = new AccountService();
        if (as.changePassword(username, passwordFirst)) {
            return "Password changed";
        }
        
        return null;
    }
    
}
