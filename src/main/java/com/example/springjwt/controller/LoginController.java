package com.example.springjwt.controller;

import com.example.springjwt.entity.LoginEntity;
import com.example.springjwt.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/v2/auth/login")
    public String generateToken(@RequestBody LoginEntity loginEntity) throws Exception {
        try {
            log.info("endpoint hit");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginEntity.getPhone(), loginEntity.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid Phone Number / Password!!");
        }
        return jwtUtil.generateToken(loginEntity.getPhone());
    }

}
