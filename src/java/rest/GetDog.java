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
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Dog getJson(@PathParam("token") String token) {
        JsonParser parser = Json.createParser(new StringReader(token));

        parser.next();       // START_OBJECT
        //token
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        try {
            Claims claims = JWT.decodeJWT(parser.getString());
        } catch (Exception e) {
            return null;
        }
        
        parser.next();
        parser.next();
        return new DogService().getDogByID(parser.getInt());
    }

}
