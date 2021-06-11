package com.revature.spring_boot.web.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenParser {

    private Logger logger = LogManager.getLogger();
    private JwtConfig jwtConfig;

    @Autowired
    public TokenParser(JwtConfig jwtConfig){
        this.jwtConfig = jwtConfig;
    }

    public int tokenID(HttpServletRequest req) {

        try {

            String header = req.getHeader(jwtConfig.getHeader());
            if (header == null || !header.startsWith(jwtConfig.getPrefix())) {
                logger.info("No token in request!");
                return 0;
            }

            String token = header.replaceAll(jwtConfig.getPrefix(), "");

            Claims jwtClaims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSigningKey())
                    .parseClaimsJws(token)
                    .getBody();

            int id = Integer.parseInt(jwtClaims.getId());
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;

    }
}
