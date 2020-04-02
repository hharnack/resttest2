package rest;

import io.jsonwebtoken.Claims;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import services.JWT;
import services.TestimonialService;

/**
 * API that allows for an administrator to approve a testimonial.
 *
 * @author Hans Cabrera
 */
@Path("ApproveTestimonial")
public class ApproveTestimonial {

    /**
     * API that allows for an administrator to approve a testimonial.
     *
     * @param token the token generated upon logging in.
     * @param testimonialID the id number of the testimonial to approve.
     * @return A string to indicate and token error, authentication error, a successful update, or unsuccessful update.
     */
    @PUT
    @Path("{token}/{testimonialID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(@PathParam("token") String token, @PathParam("testimonialID") String testimonialID) {
        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return "Authentication error, bad token";
        }

        if (!claims.get("isAdmin", Boolean.class)) {
            return "not admin";
        }

        if (new TestimonialService().approve(Integer.parseInt(testimonialID))) {
            return "yes";
        }

        return "no";
    }
}
