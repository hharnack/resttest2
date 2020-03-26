/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.jsonwebtoken.Claims;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import models.Appointment;
import services.AppointmentService;
import services.JWT;

/**
 * REST Web Service
 *
 * @author 640195
 */
@Path("getAllAppointments")
public class GetAllAppointments {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GetAllAppointments
     */
    public GetAllAppointments() {
    }

    /**
     * Retrieves representation of an instance of rest.GetAllAppointments
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GetAllAppointments
     * @param content representation for the resource
     */
    @GET
    @Path("{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("token") String token) {
        //return the token decoded
        Claims claims;
        try{
        claims = JWT.decodeJWT(token);
        } catch(Exception e){
            return "Authentication Error: Bad Token";
        }
        AppointmentService as = new AppointmentService();
        ArrayList<Appointment> aList = as.getAllAppointments(); 
       Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
       String gsonList = gson.toJson(aList);
        return gsonList;
    }
}
