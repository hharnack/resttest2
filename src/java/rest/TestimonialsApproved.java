package rest;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Testimonial;
import services.TestimonialService;

/**
 * API that allows for retrieving all approved testimonials from the database.
 *
 * @author Hans Cabrera
 */
@Path("Testimonials")
public class TestimonialsApproved {

    /**
     * API that allows for retrieving all approved testimonials from the
     * database.
     *
     * @return A list of all approved testimonials.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Testimonial> getJson() {
        return new TestimonialService().getApproved();
    }
}
