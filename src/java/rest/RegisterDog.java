package rest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.jsonwebtoken.Claims;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import models.Dog;
import models.Vaccine;
import models.Veterinarian;
import services.DogService;
import services.JWT;

/**
 *
 * @author 703174
 */
@Path("registerDog")
public class RegisterDog {

    public RegisterDog() {

    }

    @Context
    private UriInfo context;

    /**
     * PUT method for updating or creating an instance of
     *
     * @param token
     * @param content representation for the resource
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        //gets the token from the json
        String token = JWT.getToken(content);
        //return the token decoded
         Claims claims;
        try{
        claims = JWT.decodeJWT(token);
        } catch(Exception e){
            return "Authentication error, bad token";
        } 
        //get username from decoded token
        String username = claims.get("username", String.class);
        //create dog object from json
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Dog dog = gson.fromJson(content, Dog.class);
        DogService ds = new DogService();
        boolean flag = ds.insert(username, dog);
        if(flag){
            return "Succesffuly added dog";
        } else {
            return "failed to add dog";
        }
    }
}
