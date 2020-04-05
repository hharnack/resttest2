package rest;

import io.jsonwebtoken.Claims;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.User;
import services.AccountService;
import services.JWT;

/**
 * API that allows an administrator to retrieve all users from the database.
 *
 * @author Hans Cabrera
 */
@Path("RetrieveUsers")
public class RetrieveUsers {

    /**
     * API that allows an administrator to retrieve all users from the database.
     *
     * @param token The authentication token created on login.
     * @return A list of all users in the database.
     */
    @GET
    @Path("{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getJson(@PathParam("token") String token) {
        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return null;
        }
        if (claims.get("isAdmin", Boolean.class)) {
            return new AccountService().getUsers();
        }

        return null;
    }
}
