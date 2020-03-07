/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.jsonwebtoken.Claims;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import services.DogService;
import services.JWT;
import models.Dog;

/**
 * REST Web Service
 *
 * @author 769217
 */
@Path("RetrieveDogs")
public class RetrieveDogs {

    @Context
    private UriInfo context;

    @GET
    @Path("{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dog> getJson(@PathParam("token") String token) {
        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return null;
        }
        String username = claims.get("username", String.class);
        DogService ds = new DogService();
        List<Dog> dogList = ds.getDogsByUsername(username);
        return dogList;
    }

    /**
     * PUT method for updating or creating an instance of RetrieveDogs
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
