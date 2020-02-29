/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.jsonwebtoken.Claims;
import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import models.User;
import services.AccountService;
import services.JWT;

/**
 *
 * @author 703174
 */
@Path("RetrieveUser")
public class RetrieveUser {

    @Context
    private UriInfo context;

    /**
     * Retrieves representation of an instance of rest.
     *
     * @param token
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("token") String token) {

        Claims claims = JWT.decodeJWT(token);
        String username = claims.getSubject();
        
        AccountService as = new AccountService();
        // TODO query database and send JSON use .toJSON() method provided
        return as.getUser(username).toJSON().toString();
    }
}
