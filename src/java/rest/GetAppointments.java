/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

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
@Path("getappointments")
public class GetAppointments {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GetAppointments
     */
    public GetAppointments() {
    }

    /**
     * Retrieves representation of an instance of rest.GetAppointments
     * @param token
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Appointment> getJson(@PathParam("token") String token) {

        //return the token decoded
        Claims claims;
        try{
        claims = JWT.decodeJWT(token);
        } catch(Exception e){
            return null;
        }
        AppointmentService as = new AppointmentService();
        String username = claims.get("username", String.class);
        return as.getAppointmentsByUsername(username);
    }

    /**
     * PUT method for updating or creating an instance of GetAppointments
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
