package com.cosmink.models.Grant;
import com.cosmink.models.GrantDetails.GrantDetails;
import com.cosmink.models.User.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class GrantFactory {

    public static Grant createGrant(GrantDetails grantDetails, User user){

        Grant grant = new Grant();
        grant.setGrantDetails(grantDetails);
        grant.setToken(issueToken(grant, user));
        return grant;

    }

    private static String issueToken(Grant grant, User user){
        //TODO: ritorna token con libreria Jwts
        return Jwts.builder()
                .setId(grant.getUuid())
                .setIssuer("app-cancello")
                .setAudience("app-cancello")
                .setSubject(user.getUserCredentials().getEmail())
                .setIssuedAt(Date.from(grant.getGrantDetails().getStartDate().toInstant()))
                .setExpiration(Date.from(grant.getGrantDetails().getExpiryDate().toInstant()))
                .signWith(SignatureAlgorithm.HS256, "passwordsegreta")
                .compact();
    }
}
