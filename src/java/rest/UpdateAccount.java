/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.jsonwebtoken.Claims;
import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import models.User;
import services.AccountService;
import services.JWT;

/**
 * API that allows a user to update their account information.
 *
 * @author Hans Cabrera
 */
@Path("update")
public class UpdateAccount {

    /**
     * API that allows a user to update their account information.
     *
     * @param content JSON containing an authentication token and updated user
     * information.
     * @return A string containing details of any error or if the update was
     * successful.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {  
        System.out.println(content);
        JsonParser parser = Json.createParser(new StringReader(content));
        parser.next(); // START_OBJECT
        // token
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        parser.getString(); //token
        // email
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String parsedEmail = parser.getString();
        // username
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String parsedUserName = parser.getString();
        System.out.println(parsedEmail);
        System.out.println(parsedUserName);
        
        AccountService as = new AccountService();
        User currentUser = as.getUser(parsedUserName);
        String currentEmail = currentUser.getEmail();

        if (!parsedEmail.equals(currentEmail) && as.checkEmail(parsedEmail)) {
            return "Email Already in Use";
        }
        
        Claims claims;
        try {
            claims = JWT.decodeJWT(JWT.getToken(content));
        } catch (Exception e) {
            return "Authentication error, bad token";
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        User user = gson.fromJson(content, User.class);
        //AccountService as = new AccountService();
        if (as.updateUser(user)) {
            return "Updated";
        }

        return "Not Updated";
    }
}
