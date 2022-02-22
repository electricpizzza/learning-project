package com.example.learning.controller;

import com.example.learning.config.JwtTokenUtil;
import com.example.learning.entity.JwtRequest;
import com.example.learning.entity.JwtResponse;
import com.example.learning.service.JWTUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private JWTUserDetailsService jwtUserDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    @RequestMapping(value = "auth",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthentificationToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername((jwtRequest.getUsername()));
        final String token = jwtTokenUtil.generateToken(userDetails);
        return  ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch(DisabledException e){
            throw  new Exception("USER_DISABLED", e);
        }catch(BadCredentialsException e){
            throw  new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
