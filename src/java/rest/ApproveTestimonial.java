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
import services.JWT;
import services.TestimonialService;

/**
 *
 * @author 703174
 */
@Path("ApproveTestimonial")
public class ApproveTestimonial {
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String contents) {
        JsonParser parser = Json.createParser(new StringReader(contents));

        parser.next(); // START_OBJECT

        parser.next(); // KEY_NAME
        parser.next(); // VALUE_STRING
        Claims claims;
        try {
            claims = JWT.decodeJWT(parser.getString());
        } catch (Exception e) {
            return "Authentication error, bad token";
        }
        
        parser.next(); // KEY_NAME
        parser.next(); // VALUE_STRING
        
        if (new TestimonialService().approve(parser.getInt())) {
            return "yes";
        }
        
        return "no";
    }
}
