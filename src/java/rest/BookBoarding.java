/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.jsonwebtoken.Claims;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.Boarding;
import services.AppointmentService;
import services.JWT;

/**
 * REST Web Service
 *
 * @author 640195
 */
@Path("bookboarding")
public class BookBoarding {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of registerBoarding
     */
    public BookBoarding() {
    }

    /**
     * Retrieves representation of an instance of rest.registerBoarding
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of registerBoarding
     * @param content representation for the resource
     * @return 
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJSON(String content) {
        //gets the token from the json
        String token = JWT.getToken(content);
        //return the token decoded
         Claims claims;
        try{
        claims = JWT.decodeJWT(token);
        } catch(Exception e){
            return "Authentication error, bad token";
        } 
        //create appointment object from json
        Gson gson = new Gson();
        Boarding bAppt = gson.fromJson(content, Boarding.class);
        bAppt.setAmountPaid(0);
        bAppt.setIsApproved(false);
        bAppt.setIsCancelled(false);
        bAppt.setIsPaid(false);
        bAppt.setType("boarding");
        bAppt.setUsername(claims.get("username", String.class));
        AppointmentService as = new AppointmentService();
        if(as.insert(bAppt)){
            return "Successfully added appointment";
        } else {
            return "failed to add appointment";
        }
    }
}
