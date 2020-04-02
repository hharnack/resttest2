package rest;

import io.jsonwebtoken.Claims;
import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.User;
import services.AccountService;
import services.JWT;

/**
 * API that allows for a user to perform a soft delete on their account.
 *
 * @author Hans Cabrera
 */
@Path("deleteAccount")
public class DeleteAccount {

    /**
     * API that allows for a user to perform a soft delete on their account.
     *
     * @param content JSON containing the username of the account to delete, and
     * password for confirmation.
     * @return A string of any errors or if the delete was successful.
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        JsonParser parser = Json.createParser(new StringReader(content));

        parser.next(); // START_OBJECT

        parser.next(); // KEY_NAME
        parser.next(); // VALUE_STRING

        try {
            Claims claims = JWT.decodeJWT(parser.getString());
        } catch (Exception e) {
            return "Authentication error";
        }

        //username
        parser.next(); // KEY_NAME
        parser.next(); // VALUE_STRING
        String username = parser.getString();

        // password
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String passwordEntered = parser.getString();

        AccountService as = new AccountService();
        User user = as.getUser(username);
        String currentPassword = user.getPassword();

        if (!passwordEntered.equals(currentPassword)) {
            return "Password is incorrect";
        }

        // TODO add account type authentication
        if (new AccountService().delete(username)) {
            return "yes";
        }
        return "no";
    }
}
