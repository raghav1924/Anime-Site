package com.miniProject.authApp.services;


import com.miniProject.authApp.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CToken implements IToken{

    @Override
    public Map<String, String> genToken(User user) {

        Map<String,String> result=new HashMap<>();
        Map<String,Object> userData=new HashMap<>();
        user.setPassword("");
        userData.put("userEmail",user.getEmail());
        userData.put("userRole",user.getRole());

        String tokenGen= Jwts.builder().setClaims(userData).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS512,"animeUniverse").compact();
        result.put("token",tokenGen);
        result.put("userEmail",user.getEmail());
        result.put("userRole",user.getRole());
        return result;
    }
}
