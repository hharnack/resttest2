package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.jsonwebtoken.Claims;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import models.User;
import services.AccountService;
import services.JWT;

/**
 * API that allows a user to update their account information.
 *
 * @author Hans Cabrera
 */
@Path("update")
public class UpdateAccount {

    /**
     * API that allows a user to update their account information.
     *
     * @param content JSON containing an authentication token and updated user
     * information.
     * @return A string containing details of any error or if the update was
     * successful.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        Claims claims;
        try {
            claims = JWT.decodeJWT(JWT.getToken(content));
        } catch (Exception e) {
            return "Authentication error, bad token";
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        User user = gson.fromJson(content, User.class);
        AccountService as = new AccountService();
        if (as.updateUser(user)) {
            return "Updated";
        }

        return "Not Updated";
    }
}
