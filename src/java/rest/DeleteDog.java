/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.jsonwebtoken.Claims;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import services.DogService;
import services.JWT;

/**
 *
 * @author 703174
 */
@Path("deleteDog")
public class DeleteDog {
    
    @PUT
    @Path("{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(@PathParam("token") String token) {
        Claims claims;
        try{
        claims = JWT.decodeJWT(token);
        } catch(Exception e){
            return "Authentication error, bad token";
        }
        
        if (new DogService().delete(claims.get("petID", Integer.class))) {
            return "yes";
        }
       
        return "no";
    }
}
