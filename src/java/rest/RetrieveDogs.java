/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.jsonwebtoken.Claims;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import services.DogService;
import services.JWT;
import models.Dog;

/**
 * API that allows a user to retrieve all dogs that belong to that user fromm
 * the database.
 *
 * @author Hans Cabrera
 */
@Path("RetrieveDogs")
public class RetrieveDogs {

    /**
     * API that allows a user to retrieve all dogs that belong to that user
     * fromm the database.
     *
     * @param token the authentication token created on login.
     * @return A list of all the dogs that belong to the requesting user.
     */
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
}
