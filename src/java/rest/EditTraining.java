package rest;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.Training;
import services.AppointmentService;
import services.JWT;

/**
 * REST Web Service
 *
 * @author 640195
 */
@Path("edittraining")
public class EditTraining {

    /**
     * PUT method for updating or creating an instance of EditTraining
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        //gets the token from the json
        String token = JWT.getToken(content);
        //return the token decoded
        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return "Authentication error, bad token";
        }
        //create appointment object from json
        Gson gson = new Gson();
        Training tAppt = gson.fromJson(content, Training.class);
        if (claims.get("isAdmin", Boolean.class)) {
            //keep normal value
        } else {
            tAppt.setIsApproved(false);
        }
        if (tAppt.getTotal() == tAppt.getAmountPaid()) {
            tAppt.setIsPaid(true);
        }
        AppointmentService as = new AppointmentService();
        if (as.update(tAppt)) {
            return "Appointment updated";
        } else {
            return "Failed to update";
        }
    }
}
