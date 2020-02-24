package rest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.User;
import services.AccountService;

/**
 *
 * @author 703174
 */
@Path("register")
public class RegisterAccount {

    /**
     * Creates a new instance of RegisterAccount
     */
    public RegisterAccount() {
    }

    @Context
    private UriInfo context;

    /**
     * Retrieves representation of an instance of rest.RegisterAccountV2
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "Boo";
    }

    /**
     * PUT method for updating or creating an instance of RegisterAccountV2
     *
     * @param content representation for the resource
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        System.out.println(content);
        User user = new User();

        JsonParser parser = Json.createParser(new StringReader(content));

        parser.next(); // START_OBJECT

        // { username , password , fname , lname , email, appt/house, building, street, city, province, postcode, phone, emergencyphone, emergencyname });
        // Username
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        user.setUsername(parser.getString());

        // Password
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        user.setPassword(parser.getString()); // Password first

        // First Name
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        user.setFirstName(parser.getString());

        // Last Name
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        user.setLastName(parser.getString());

        // Email
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        user.setEmail(parser.getString());

        // Appt/House number
        parser.next();       // KEY_NAME
        parser.next();
        String houseNum = parser.getString();
        user.getAddress().setHouseNum(houseNum);

        // Appt/House number
        parser.next();       // KEY_NAME
        parser.next();
        user.getAddress().setHouseNum(parser.getString());

        // Building number
        parser.next();
        parser.next();
        parser.getString();
        user.getAddress().setBuildingNum(parser.getString());

        // City
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        user.getAddress().setCity(parser.getString());

        // Province
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        user.getAddress().setProvince(parser.getString());

        // Postal
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        user.getAddress().setPostal(parser.getString());

        // Phone
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        user.setPhoneNumber(parser.getString());

        // Emergency phone
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        user.setEmergencyPhone(parser.getString());

        // Emergency name
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        user.setEmergencyName(parser.getString());

        AccountService as = new AccountService();
        if (as.register(user)) {
            return "account registered";
        }
        return "Username already taken.";
    }
}
