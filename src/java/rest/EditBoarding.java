/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
@Path("editboarding")
public class EditBoarding {
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EditBoarding
     */
    public EditBoarding() {
    }

    /**
     * Retrieves representation of an instance of rest.EditBoarding
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of EditBoarding
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        //gets the token from the json
        String token = JWT.getToken(content);
        //return the token decoded
        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return "Authentication error, bad token";
        }
        //create appointment object from json
        Gson gson = new Gson();
        Boarding bAppt = gson.fromJson(content, Boarding.class);
        if (claims.get("isAdmin", Boolean.class)) {
            //keep normal value
        } else {
            bAppt.setIsApproved(false);
        }
        if (bAppt.getTotal() == bAppt.getAmountPaid()) {
            bAppt.setIsPaid(true);
        }
        AppointmentService as = new AppointmentService();
        if (as.update(bAppt)) {
            return "Appointment updated";
        } else {
            return "Failed to update";
        }
    }
}
