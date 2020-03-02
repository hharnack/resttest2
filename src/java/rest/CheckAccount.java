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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 703174
 */
@Path("verify")
public class CheckAccount {

    /**
     * Creates a new instance of CheckAccount
     */
    public CheckAccount() {
    }

    @Context
    private UriInfo context;

    /**
     * Retrieves representation of an instance of rest.CheckAccount
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
     * PUT method for updating or creating an instance of RegisterAccount
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        System.out.println(content);

        JsonParser parser = Json.createParser(new StringReader(content));

        parser.next(); // START_OBJECT

        // Username
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String parsedUserName = parser.getString();

        AccountService as = new AccountService();
        if (as.checkUsername(parsedUserName)) {
            return "Username Already Exists";
        }

        // Password
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String parsedPassword = parser.getString();

        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String parsedConfirmPassword = parser.getString();

        if (!parsedPassword.equals(parsedConfirmPassword)) {
            return "Passwords do not match";
        }

        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String parsedEmail = parser.getString();

        if (as.checkEmail(parsedEmail)) {
            return "Email Already in Use";
        }

        return "Valid";
    }
}
