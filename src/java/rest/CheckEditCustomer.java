package rest;

import io.jsonwebtoken.Claims;
import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.User;
import services.AccountService;
import services.JWT;

/**
 * API that checks for user credentials before allowing any edits.
 *
 * @author Levon Rose
 */
@Path("checkEditCustomer")
public class CheckEditCustomer {

    /**
     * API that checks for user credentials before allowing any edits.
     *
     * @param content JSON containing user information.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {

        JsonParser parser = Json.createParser(new StringReader(content));

        parser.next(); // START_OBJECT
        //token
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String token = parser.getString();
        //return the token decoded
        Claims claims;
        try {
            claims = JWT.decodeJWT(token);
        } catch (Exception e) {
            return "Authentication error, bad token";
        }
        String parsedUserName = claims.get("username", String.class);
        //email
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String parsedEmail = parser.getString();

        AccountService as = new AccountService();
        User user = as.getUser(parsedUserName);
        String currentEmail = user.getEmail();

        if (!parsedEmail.equals(currentEmail) && as.checkEmail(parsedEmail)) {
            return "Email Already in Use";
        }

        return "Valid";
    }
}
