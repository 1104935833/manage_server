package hxc.manage.common;


import com.sun.jdi.LongValue;
import hxc.manage.model.User;
import hxc.manage.model.UserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtTokenProvider {

    Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Autowired
    private AuthParameters authParameters;

    /**

     * Generate token for user login.

     *

     * @param authentication

     * @return return a token string.

     */

    public String createJwtToken(Authentication authentication) {

        //user name
//        String username = ((User) authentication.getPrincipal()).getWorkID();
//        String userId = ((User) authentication.getPrincipal()).getUser_id();
        //expire time
        Date expireTime =new Date(System.currentTimeMillis()+authParameters.getTokenExpiredMs());

        Map<String,Object> claims = new HashMap<>();
        claims.put("user",((User) authentication.getPrincipal()));
        //create token

        String token = Jwts.builder()
//                .setSubject(username+"-"+userId)
                .setClaims(claims)
                .setExpiration(expireTime)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, authParameters.getJwtTokenSecret())
                .compact();
        return token;

    }

    /**

     * validate token eligible.

     * if Jwts can parse the token string and no throw any exception, then the token is eligible.

     * @param token a jws string.

     */

    public boolean validateToken(String token) {

        String VALIDATE_FAILED ="validate failed : ";

        try {
            Jwts.parser()
                    .setSigningKey(authParameters.getJwtTokenSecret())
                    .parseClaimsJws(token);

            return true;

        }catch (Exception ex) {

            //ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, //IllegalArgumentException

            logger.error(VALIDATE_FAILED + ex.getMessage());

            return false;

        }

    }

    public User getUserFromToken(String token) {
        HashMap claims = (HashMap) getUserFromJwt(token).get("user");
        HashMap<String,Object> map = claims;
        User user = new User();
        user.setId(Long.valueOf((int) claims.get("id")));
        user.setGender(String.valueOf(claims.get("gender")));
        user.setNote(String.valueOf(claims.get("note")));
        user.setEmail(String.valueOf(claims.get("email")));
        user.setPhone(String.valueOf(claims.get("phone")));
        user.setOffice_id(String.valueOf(claims.get("office_id")));
        user.setWorkID(String.valueOf(claims.get("workID")));
//        user.setEnable((int) claims.get("enable"));
        user.setUser_id(String.valueOf(claims.get("user_id")));
        user.setTree(String.valueOf(claims.get("tree")));
        user.setRoles((List) claims.get("roles"));
        return user;
    }
    /**
     * Get user name from Jwt, the user name have set to jwt when generate token.
     *
     * @param token jwt token.
     * @return user name.
     */
    private Claims getUserFromJwt(String token) {
        return Jwts.parser().setSigningKey(authParameters.getJwtTokenSecret())
                .parseClaimsJws(token)
                .getBody();
//                .getSubject();
    }

}
