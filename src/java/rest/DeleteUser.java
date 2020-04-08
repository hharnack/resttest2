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
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import services.AccountService;
import services.JWT;

/**
 * API that allows an administrator to perform a soft delete on an account.
 *
 * @author Hans Cabrera
 */
@Path("DeleteUser")
public class DeleteUser {

    /**
     * API that allows an administrator to perform a soft delete on an account.
     *
     * @param content JSON containing the token and the username to delete.
     * @return Any errors or if the operation was successful.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        JsonParser parser = Json.createParser(new StringReader(content));
        parser.next(); // START_OBJECT

        parser.next(); // KEY_NAME
        parser.next(); // VALUE_STRING

        Claims claims;
        try {
            claims = JWT.decodeJWT(parser.getString());
        } catch (Exception e) {
            return "Authentication error, bad token";
        }

        if (!claims.get("isAdmin", Boolean.class)) {
            return "not admin";
        }

        parser.next(); // KEY_NAME
        parser.next(); // VALUE_STRING

        if (new AccountService().delete(parser.getString())) {
            return "yes";
        }

        return "no";
    }
}