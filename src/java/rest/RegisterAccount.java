package rest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        User user = gson.fromJson(content, User.class);
        AccountService as = new AccountService();
        if (as.register(user)) {
            return "account registered";
        }
        return "Username already taken.";
    }
}
