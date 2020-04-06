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
import services.JWT;
import services.TestimonialService;

/**
 *
 * @author 703174
 */
@Path("DeleteTestimonial")
public class DeleteTestimonial {
    
    @PUT
    @Path("{token}/{testimonialID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJSON(@PathParam("token") String token, @PathParam("testimonialID") String testimonialID) {
        
        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return "Authentication error";
        }
        if (!claims.get("isAdmin", Boolean.class)){
            return "not admin";
        }
        
        if (new TestimonialService().disapprove(Integer.parseInt(testimonialID))) {
            return "deleted";
        }
        
        return "not deleted";
    }
}
