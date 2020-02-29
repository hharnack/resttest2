/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

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
     * @param content
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{content}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("content") String content) {

        String username = content;
        
        AccountService as = new AccountService();
        // TODO query database and send JSON use .toJSON() method provided
        return as.getUser(username).toJSON().toString();
    }
}
