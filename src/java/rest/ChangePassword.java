/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.jsonwebtoken.Claims;
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
import models.User;
import services.AccountService;
import services.JWT;

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
        
        parser.next(); // START_OBJECT
        
        // Token
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String token = parser.getString();
        
        // Username
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String oldPassword = parser.getString();

        // Password First
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String newPassword = parser.getString(); // Password first
        
        // Password Confirm
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String confirmPassword = parser.getString(); // Password first
        
        Claims claims = JWT.decodeJWT(token);
        String username = claims.getSubject();
        
        AccountService as = new AccountService();
        User user = as.getUser(username);
        String currentPassword = user.getPassword();
        
        if (!oldPassword.equals(currentPassword)){
            return "Old password is incorrect";
        }
        
        if (!newPassword.equals(confirmPassword)) {
            return "New passwords do not match";
        }
        
        if (as.changePassword(username, newPassword)) {
            return "Password changed";
        }
        
        return null;
    }
    
}
