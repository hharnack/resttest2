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
 * API that allows for an administrator to delete a testimonial from the
 * database.
 *
 * @author Hans Cabrera
 */
@Path("DeleteTestimonial")
public class DeleteTestimonial {

    /**
     * API that allows for an administrator to delete a testimonial from the
     * database.
     *
     * @param token The authentication token generated on login.
     * @param testimonialID The id number of the testimonial to delete.
     * @return A String containing error details or if the delete was
     * successful.
     */
    @PUT
    @Path("{token}/{testimonialID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJSON(@PathParam("token") String token, @PathParam("testimonialID") String testimonialID) {

        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return "Authentication error";
        }
        if (!claims.get("admin", Boolean.class)) {
            return "not admin";
        }

        if (new TestimonialService().disapprove(Integer.parseInt(testimonialID))) {
            return "deleted";
        }

        return "not deleted";
    }
}
