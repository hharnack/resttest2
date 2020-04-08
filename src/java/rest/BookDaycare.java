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
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.Daycare;
import services.AppointmentService;
import services.JWT;

/**
 * REST Web Service
 *
 * @author 640195
 */
@Path("bookdaycare")
public class BookDaycare {
    /**
     * PUT method for updating or creating an instance of BookDaycare
     * @param content representation for the resource
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

        //create appointment object from json
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Daycare dAppt = gson.fromJson(content, Daycare.class);
        if(claims.get("isAdmin", Boolean.class) == true){
               //keep GSON username
        } else {
            //change to token username
             dAppt.setUsername(claims.get("username", String.class));
        }
        dAppt.setType("daycare");
        if (dAppt.getTotal() == dAppt.getAmountPaid()) {
            dAppt.setIsPaid(true);
        }
        AppointmentService as = new AppointmentService();
        if(as.insert(dAppt)){
            return "Succsessfully added appointment";
        }else{
            return "failed to add appointment";
        }
    }
}
