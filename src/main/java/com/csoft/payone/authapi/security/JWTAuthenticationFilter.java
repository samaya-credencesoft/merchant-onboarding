package com.csoft.payone.authapi.security;

import com.csoft.payone.auth.user.ApplicationUser;
import com.csoft.payone.auth.user.UserDetailsServiceImpl;
import com.csoft.payone.service.seller.Payment;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.csoft.payone.authapi.security.SecurityConstants.EXPIRATION_TIME;
import static com.csoft.payone.authapi.security.SecurityConstants.HEADER_STRING;
import static com.csoft.payone.authapi.security.SecurityConstants.SECRET;
import static com.csoft.payone.authapi.security.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    
    private UserDetailsService uds ;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager,ApplicationContext ctx) {
        this.authenticationManager = authenticationManager;
        this.uds=ctx.getBean(UserDetailsServiceImpl.class);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {

            ApplicationUser creds = new ObjectMapper()
                    .readValue(req.getInputStream(), ApplicationUser.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            uds.loadUserByUsername(creds.getUsername()).getAuthorities())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
    	String username=((User) auth.getPrincipal()).getUsername();
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        String jsonStringUserName = "user_name:"+username;
		JSONObject jsonObj = new JSONObject("{"+HEADER_STRING+":"+TOKEN_PREFIX+token+","+jsonStringUserName+"}");
		res.setContentType("text/x-json;charset=UTF-8");
		jsonObj.write(res.getWriter());

    }
}
