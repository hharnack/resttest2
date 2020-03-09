/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.jsonwebtoken.Claims;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import models.Dog;
import services.DogService;
import services.JWT;

/**
 * REST Web Service
 *
 * @author 640195
 */
@Path("calculatecost")
public class CalculateCost {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CalculateCost
     */
    public CalculateCost() {
    }

    /**
     * Retrieves representation of an instance of rest.
     *
     * @param token
     * @param dogid
     * @param startTime
     * @param endTime
     * @param type
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("token") String token, @PathParam("dogid") ArrayList<Integer> dogid, @PathParam("startTime") String startTime, @PathParam("endTime") String endTime, @PathParam("type") String type) {

        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return "Authentication error, bad token";
        }
        String username = claims.get("username", String.class);
        Date start = null;
        Date end = null;
        try {
            start = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").parse(startTime);
            end =new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").parse(endTime);
        } catch (ParseException ex) {
            Logger.getLogger(CalculateCost.class.getName()).log(Level.SEVERE, null, ex);
        }
        long diffInMillies = Math.abs(end.getTime() - start.getTime());
        long diffHours = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        System.out.println(diffHours);
        DogService ds = new DogService();
        for (int x = 0; x < dogid.size(); x++) {
            Dog dog = ds.getDogByID(dogid.get(x));

            switch (type) {
                case "boarding":

                    break;
                case "training":

                    break;
                case "daycare":

                    break;
                default:
                    break;
            }
        }
        return "";
    }

    /**
     * PUT method for updating or creating an instance of CalculateCost
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
