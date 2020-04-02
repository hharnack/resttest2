package rest;

import io.jsonwebtoken.Claims;
import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import models.User;
import services.AccountService;
import services.JWT;

/**
 * API that allows for a user to change their password.
 *
 * @author Hans Cabrera
 */
@Path("changepassword")
public class ChangePassword {

    /**
     * API that allows for a user to change their password.
     *
     * @param content JSON containing the username, old password, confirmation
     * password, and new password.
     * @return A string containing the type of error or if the change was
     * successful.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        JsonParser parser = Json.createParser(new StringReader(content));

        parser.next(); // START_OBJECT

        // Token
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String token = parser.getString();
        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return "Authentication error, bad token";
        }
        String username = claims.get("username", String.class);
        // oldpassword
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String oldPassword = parser.getString();

        // Password First
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String newPassword = parser.getString(); // Password first

        // Password Confirm
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String confirmPassword = parser.getString(); // Password first

        AccountService as = new AccountService();
        User user = as.getUser(username);
        String currentPassword = user.getPassword();

        if (!oldPassword.equals(currentPassword)) {
            return "Old password is incorrect";
        }

        if (!newPassword.equals(confirmPassword)) {
            return "New passwords do not match";
        }

        if (as.changePassword(username, newPassword)) {
            return "Password changed";
        }

        return null;
    }

}
