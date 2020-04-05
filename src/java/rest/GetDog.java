package rest;

import io.jsonwebtoken.Claims;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Dog;
import services.DogService;
import services.JWT;

/**
 * API that allows a user to retrieve a dog from the database.
 *
 * @author Levon Rose
 */
@Path("GetDog")
public class GetDog {

    /**
     * API that allows a user to retrieve a dog from the database.
     *
     * @param token The authentication token created on login.
     * @param idString The id number of the dog to retrieve.
     * @return A dog object.
     */
    @GET
    @Path("{token}/{idString}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dog getJson(@PathParam("token") String token, @PathParam("idString") String idString) {

        try {
            Claims claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return null;
        }

        int idNumber = Integer.parseInt(idString);
        return new DogService().getDogByID(idNumber);
    }

}
