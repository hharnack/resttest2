package rest;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.Boarding;
import services.AppointmentService;
import services.JWT;

/**
 * REST Web Service
 *
 * @author 640195
 */
@Path("bookboarding")
public class BookBoarding {
    /**
     * PUT method for updating or creating an instance of registerBoarding
     * @param content representation for the resource
     * @return 
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJSON(String content) {
        //gets the token from the json
        String token = JWT.getToken(content);
        //return the token decoded
         Claims claims;
        try{
        claims = JWT.decodeJWT(token);
        } catch(Exception e){
            return "Authentication error, bad token";
        } 
        //create appointment object from json
        Gson gson = new Gson();
        Boarding bAppt = gson.fromJson(content, Boarding.class);
        bAppt.setAmountPaid(0);
        bAppt.setType("boarding");
        if(claims.get("isAdmin", Boolean.class) == true){
               //keep GSON username
        } else {
            //change to token username
             bAppt.setUsername(claims.get("username", String.class));
        }
        AppointmentService as = new AppointmentService();
        if(as.insert(bAppt)){
            return "Successfully added appointment";
        } else {
            return "failed to add appointment";
        }
    }
}
