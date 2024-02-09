package com.dev.controller;

import java.util.Hashtable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dev.config.JwtService;
import com.dev.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/signinlogin")
@RequiredArgsConstructor
public class UserController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping(path = "/register" , produces = "application/json")
    public Hashtable <String,Object> regist(@RequestBody RegisterRequest request){
        return authenticationService.register(request);
    }

    @PostMapping(path="/authentication" , produces="application/json")
    public Hashtable <String,Object> authenticate(@RequestBody AuthenticationRequest request){
        return authenticationService.authenticate(request);
    }

    @GetMapping("/findUserById")
    public Hashtable <String,Object> findUserById(@RequestParam int idUser) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            response.put("data", userService.findById(idUser).get());
            response.put("status",200);
            response.put("message","ok");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }
}
