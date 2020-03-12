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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        JsonParser parser = Json.createParser(new StringReader(content));

        parser.next(); // START_OBJECT

        parser.next(); // KEY_NAME
        parser.next(); // VALUE_STRING
        String token = parser.getString();
        parser.next(); // KEY_NAME
        parser.next(); // VALUE_STRING
        int petID = parser.getInt();
        //return the token decoded
        try{
        Claims claims = JWT.decodeJWT(token);
        } catch(Exception e){
            return "Authentication error, bad token";
        }
        
        if (new DogService().delete(petID)) {
            return "yes";
        }
       
        return "no";
    }
}
