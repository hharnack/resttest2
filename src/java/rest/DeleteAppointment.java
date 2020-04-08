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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import services.AppointmentService;
import services.JWT;

/**
 * REST Web Service
 *
 * @author 640195
 */
@Path("deleteAppointment")
public class DeleteAppointment {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DeleteAppointment
     */
    public DeleteAppointment() {
    }

    /**
     * Retrieves representation of an instance of rest.DeleteAppointment
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of DeleteAppointment
     * @param content representation for the resource
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
        AppointmentService as = new AppointmentService();
        if(as.delete(parser.getInt())){
            return "Deleted";
        } else {
            return "Failed to delete";
        }
    }
}
