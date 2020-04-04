package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.jsonwebtoken.Claims;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import models.Testimonial;
import services.JWT;
import services.TestimonialService;

/**
 *
 * @author 703174
 */
@Path("SubmitTestimonial")
public class SubmitTestimonial {
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String contents) {
        Claims claims;
        try {
            claims = JWT.decodeJWT(JWT.getToken(contents));
        } catch (Exception e) {
            return "Authentication error, bad token";
        }
        Gson gson = new GsonBuilder().create();
        Testimonial testimonial = gson.fromJson(contents, Testimonial.class);
        testimonial.setUsername(claims.get("username", String.class));
        if (new TestimonialService().insert(testimonial)) {
            return "yes";
        }
        return "no";
    }
}
