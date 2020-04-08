/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.jsonwebtoken.Claims;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import models.Dog;
import models.Vaccines;
import models.Veterinarian;
import services.DogService;
import services.JWT;

/**
 * API that allows a user to update dog information.
 *
 * @author Hans Cabrera
 */
@Path("updateDog")
public class UpdateDog {

    /**
     * API that allows a user to update dog information.
     *
     * @param content JSON containing an authentication token and updated dog
     * information.
     * @return A string containing details of any error or if the update was
     * successful.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        String token = JWT.getToken(content);
        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return "Authentication error, bad token";
        }
        String username = claims.get("username", String.class);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Dog dog = gson.fromJson(content, Dog.class);
        dog.setOwner(username);
        dog.setVeterinarian(gson.fromJson(content, Veterinarian.class));
        dog.setVaccines(gson.fromJson(content, Vaccines.class));
        DogService ds = new DogService();
        if (ds.updateDog(dog)) {
            return "Updated";
        }

        return "Not Updated";
    }
}
