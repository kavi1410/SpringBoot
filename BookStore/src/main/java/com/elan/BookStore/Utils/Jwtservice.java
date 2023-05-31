package com.elan.BookStore.Utils;

import com.elan.BookStore.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class Jwtservice {
    static String Key_Value = "404D635166546A576E5A7234743777217A25432A462D4A614E645267556B5870";

    public String generateToken(User user){
        return generateToken(new HashMap<>(),user);
    }

    public String generateToken(Map<String, Object> extraclaims,User user){
        System.out.println("generatetoken");
        extraclaims.put("Email",user.getEmailID());
        System.out.println(Jwts.builder().setSubject(user.getUserName()).compact());
        return Jwts.builder()
                .setSubject(user.getUserName())
                .setIssuer(user.getId().toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *60))
                .signWith(SignatureAlgorithm.HS256,getSignInKey())
                .compact();

    }

    private byte[] getSignInKey() {
        return Base64Codec.BASE64.decode(Key_Value);
    }
    public String extractUsername(String token) {
        var us = extractclaims(token,Claims::getSubject);
        System.out.println("us token"+us);
        return us ;
    }

    private <T>T extractclaims(String token, Function<Claims,T>claimsTFunction ) {
        final Claims claims = extractAllclaims(token);
        return claimsTFunction.apply(claims);
    }

    private Claims extractAllclaims(String token) {
        System.out.println("extractallclaims");
            return Jwts.parser().setSigningKey(getSignInKey())
                    .parseClaimsJws(token)
                    .getBody();



    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenValid(token));
    }
    
    public boolean isTokenValid(String token){
        System.out.println("Expiration"+extractExpiration(token).before(new Date()));
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return (extractclaims(token,Claims::getExpiration));
    }
}