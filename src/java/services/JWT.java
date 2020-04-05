package services;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

import io.jsonwebtoken.*;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import models.User;

/**
 * Class responsible for creating a signed JWT for user with authentication
 * @author 640195
 */
public class JWT {

    private static String SECRET_KEY = "oeRaYY7Wo24sDqKSX3IM9ASGmdGPmkTd9jo1QTy4b7P9Ze5_9hKolVX8xNrQDcNRfVEdTZNOuOyqEGhXEbdJI-ZQ19k_o9MI0y3eZN2lp9jow55FfXMiINEdt1XR85VipRLSOkT6kSpzs2x-jbLDiz9iFVzkd81YKxMgPA7VfZeQUm4n-mOmnWMaVX30zGFU4L3oPBctYKkl4dYfqYWqRNfrgPJVi5DGFjywgxx0ASEiJHtV72paI3fDR2XwlSkyhhmY-ICjCRmsJN4fX1pdoL8a18-aQrvyu4j0Os6dVPYIoPvvY0SAZtWYKHfM15g7A3HD4cVREf9cUsprCRK93w";

    /**
     *  Creates the JWT and builds into it an expiry, username, and is admin boolean
     * @param username
     * @param ttlMillis
     * @return builder.compact() the completed token as a string
     */
    public static String createJWT(String username, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        
        AccountService as = new AccountService();
        User user = as.getUser(username);
        JwtBuilder builder = Jwts.builder().claim("username", username)
                .claim("isAdmin", user.isAdmin())
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, signingKey);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        return builder.compact();
    }

    /**
     * Decodes a token and verifies the signature is authentic
     * @param jwt
     * @return claims a object that holds the data of the JWT
     */
    public static Claims decodeJWT(String jwt) {

        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    /**
     * For use just to simplify some JSON parsing, gets and return the token from JSON if its the first parameter
     * @param content
     * @return
     */
    public static String getToken(String content) {
        JsonParser parser = Json.createParser(new StringReader(content));

        parser.next(); // START_OBJECT

        parser.next(); // KEY_NAME
        parser.next(); // VALUE_STRING
        String token = parser.getString();
        parser.close();
        return token;
    }

}
