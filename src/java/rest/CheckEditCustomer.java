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
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.User;
import services.AccountService;

/**
 * REST Web Service
 *
 * @author 553185
 */
@Path("checkEditCustomer")
public class CheckEditCustomer {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CheckEditCustomer
     */
    public CheckEditCustomer() {
    }

    /**
     * Retrieves representation of an instance of rest.CheckEditCustomer
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of CheckEditCustomer
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
     
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String parsedEmail = parser.getString();
        
        AccountService as = new AccountService();
        User user = as.getUser(parsedUserName);
        String currentEmail = user.getEmail();

        if (!parsedEmail.equals(currentEmail) && as.checkEmail(parsedEmail)) {
            return "Email Already in Use";
        }

        return "Valid";
    }
}
