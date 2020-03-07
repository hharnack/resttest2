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
import models.Dog;
import services.DogService;
import services.JWT;

/**
 * 
 *
 * @author 703174
 */
@Path("GetDog")
public class GetDog {

    public GetDog() {
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
    public Dog putJson(String content) {
        String token = JWT.getToken(content);
        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return null;
        }
        int petID = claims.get("petID", Integer.class);
        
        return new DogService().getDogByID(petID);
    }
}
