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
 * API that allows a user to delete a dog from their account.
 *
 * @author Hans Cabrera
 */
@Path("deleteDog")
public class DeleteDog {

    /**
     * API that allows a user to delete a dog from their account.
     *
     * @param content JSON containing the user's login token and dog
     * information.
     * @return A string containing the type of error if the change was
     * successful.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        JsonParser parser = Json.createParser(new StringReader(content));

        parser.next(); // START_OBJECT

        parser.next(); // KEY_NAME
        parser.next(); // VALUE_STRING

        try {
            Claims claims = JWT.decodeJWT(parser.getString());
        } catch (Exception e) {
            return "Authentication error";
        }

        parser.next(); // KEY_NAME
        parser.next(); // VALUE_STRING
        if (new DogService().delete(parser.getInt())) {
            return "yes";
        }
        return "no";
    }
}
