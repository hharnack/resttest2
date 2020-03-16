/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.JsonObject;
import io.jsonwebtoken.Claims;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.Dog;
import services.DogService;
import services.JWT;

/**
 * REST Web Service
 *
 * @author 640195
 */
@Path("calculatecost")
public class CalculateCost {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CalculateCost
     */
    public CalculateCost() {
    }

    /**
     * PUT method for updating or creating an instance of CalculateCost
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        JsonObject returnJson = new JsonObject();
        String message;
        JsonParser parser = Json.createParser(new StringReader(content));
        parser.next(); // START_OBJECT

        // token
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String token = parser.getString();
        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return "Authentication error, bad token";
        }
        String username = claims.get("username", String.class);
        //ids
        try {
            parser.next();       // KEY_NAME
            parser.next();       // VALUE_STRING
            String idsString = parser.getString();
            String[] idsTemp = idsString.split(",");
            int[] dogIds = new int[idsTemp.length];
            for (int x = 0; x < idsTemp.length; x++) {
                dogIds[x] = Integer.parseInt(idsTemp[x]);
            }

            //startTime
            parser.next();       // KEY_NAME
            parser.next();       // VALUE_STRING
            String startTimeString = parser.getString();
            String[] startTimeTemp = startTimeString.split(" ");
            String startTimeT = startTimeTemp[0] + "T" + startTimeTemp[1];
            //endTime
            parser.next();       // KEY_NAME
            parser.next();       // VALUE_STRING
            String endTimeString = parser.getString();
            //time between calculations
            String[] endTimeTemp = endTimeString.split(" ");
            String endTimeT = endTimeTemp[0] + "T" + endTimeTemp[1];
            LocalDateTime dateTimeStart = LocalDateTime.parse(startTimeT);
            LocalDateTime dateTimeEnd = LocalDateTime.parse(endTimeT);
            long secondsEnd = dateTimeEnd.toEpochSecond(ZoneOffset.UTC);
            long secondsStart = dateTimeStart.toEpochSecond(ZoneOffset.UTC);
            double appointmentHours = (secondsEnd - secondsStart) / 3600;
            long days = ChronoUnit.DAYS.between(dateTimeStart, dateTimeEnd);
            
            //grooming
            //type
            parser.next();       // KEY_NAME
            parser.next();       // VALUE_STRING
            boolean grooming = (parser.getString().equals("true"));
            //type
            parser.next();       // KEY_NAME
            parser.next();       // VALUE_STRING
            String type = parser.getString();
            double total = 0;
            double grandTotal = 0;
            message = "Error with cost estimate";
            DogService ds = new DogService();
            switch (type) {
                case "boarding":
                    double firstPrice;
                    double extraPrice;
                    
                    if(days < 1){
                    days = 1;
                    }
                    for (int x = 0; x < dogIds.length; x++) {
                        firstPrice=50;
                        extraPrice=40;
                        Dog dog = ds.getDogByID(dogIds[x]);
                        LocalDate dogBirth = dog.getDateOfBirth().toLocalDate();  
                        LocalDate timeOfAppt =  dateTimeStart.toLocalDate();
                        if(ChronoUnit.DAYS.between(dogBirth, timeOfAppt) <= 365){
                            firstPrice=55;
                            extraPrice=45;
                        }
                        if (x == 0) {
                            total += days * firstPrice;
                        } else {
                            total += days * extraPrice;
                        }
                    }
                    if(grooming){
                            total += 50;
                      };
                    message = "Cost estimate successful";
                    break;
                case "training":
                    Dog dog = ds.getDogByID(dogIds[0]);
                    if (dog.isTrainingDone()) {
                        total += appointmentHours * 70;
                    } else {
                        total += 130;
                        if (appointmentHours > 1.5) {
                            total += (appointmentHours - 1.5) * 70;
                        }
                    }
                    message = "Cost estimate successful";
                    break;
                case "daycare":
                    for (int x = 0; x < dogIds.length; x++) {
                        if (x == 0) {
                            total += 50;
                        } else {
                            total += 40;
                        }
                    }
                    message = "Cost estimate successful";
                    break;
                default:
                    break;
            }
            grandTotal = total * 1.05;
            returnJson.addProperty("message", message);
            returnJson.addProperty("total", grandTotal);
            return returnJson.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
//            message = "error with cost estimate";
//            returnJson.addProperty("message", message);
//            returnJson.addProperty("total", 0);
//            return returnJson.toString();
        }
    }
}
