/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.jsonwebtoken.Claims;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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

    /**
     * Retrieves representation of an instance of rest.
     *
     * @param token
     * @param idString
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{token}/{idString}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dog getJson(@PathParam("token") String token, @PathParam("idString") String idString) {
        
        try {
            Claims claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return null;
        }

        int idNumber = Integer.parseInt(idString);
        return new DogService().getDogByID(idNumber);
    }

}
