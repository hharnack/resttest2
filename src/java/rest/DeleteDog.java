/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.jsonwebtoken.Claims;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import services.DogService;
import services.JWT;

/**
 *
 * @author 703174
 */
public class DeleteDog {
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        String token = JWT.getToken(content);
        //return the token decoded
        try{
        Claims claims = JWT.decodeJWT(token);
        } catch(Exception e){
            return "Authentication error, bad token";
        }
        
        if (new DogService().delete(0)) {
            // chef boyardee
        }
       
        return "a";
    }
}
