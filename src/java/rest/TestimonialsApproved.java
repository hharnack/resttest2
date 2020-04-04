package rest;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Testimonial;
import services.TestimonialService;

/**
 *
 * @author 703174
 */
@Path("Testimonials")
public class TestimonialsApproved {

    /**
     * 
     * @return all approved testimonials
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Testimonial> getJson() {
        return new TestimonialService().getApproved();
    }
}
