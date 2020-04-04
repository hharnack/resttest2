package rest;

import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import services.AccountService;

/**
 * API that allows for a user to check if an account under their desired
 * username and password already exists.
 *
 * @author Hans Cabrera
 */
@Path("verify")
public class CheckAccount {

    /**
     * API that allows for a user to check if an account under their desired
     * username and password already exists.
     *
     * @param content JSON with the desired username, password, and email
     * address.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        System.out.println(content);

        JsonParser parser = Json.createParser(new StringReader(content));

        parser.next(); // START_OBJECT

        // Username
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String parsedUserName = parser.getString();

        AccountService as = new AccountService();
        if (as.checkUsername(parsedUserName)) {
            return "Username Already Exists";
        }

        // Password
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String parsedPassword = parser.getString();

        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String parsedConfirmPassword = parser.getString();

        if (!parsedPassword.equals(parsedConfirmPassword)) {
            return "Passwords do not match";
        }

        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String parsedEmail = parser.getString();

        if (as.checkEmail(parsedEmail)) {
            return "Email Already in Use";
        }

        return "Valid";
    }
}
