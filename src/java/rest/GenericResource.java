/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * This is a test - Holly
 */
package rest;

import models.User;
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
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource_1
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        System.out.println("React!");
        return "hello from 1";
    }

    /**
     * PUT method for updating or creating an instance of GenericResource_1
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putText(String content) {
        System.out.println(content);
        
        JsonParser parser = Json.createParser(new StringReader(content));
        
        //JsonParserFactory factory = Json.createParserFactory();
        //JsonParser parser1 = factory.createParser(...);
        
        JsonParser.Event event = parser.next(); // START_OBJECT
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        String parsedName = parser.getString();
        event = parser.next();       // KEY_NAME
        event = parser.next();       // VALUE_STRING
        String parsedPassword = parser.getString();
        
        System.out.println(parsedName);
        System.out.println(parsedPassword);
        
        //try {
            AccountService as = new AccountService();
            User user = null;
            
            //String[] parts = parsedContent.split(" ");
            user = as.login(parsedName, parsedPassword);
            
            if(user != null){
                return "valid";
            }
            
        //} catch (IOException ex) {
            //Logger.getLogger(GenericResource_1.class.getName()).log(Level.SEVERE, null, ex);
        //}

        return "Invalid";
    }
}
