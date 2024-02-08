package com.dev.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.config.JwtService;
import com.dev.model.message.Message;
import com.dev.model.message.user.UserMess;
import com.dev.model.user.User;
import com.dev.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping(path = "/envoyerMessage")
    public Hashtable <String,Object> envoyerMessage(@RequestHeader Map<String, String> headers, @RequestParam int idReceive, @RequestParam String contenu) throws Exception {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User userSend=userService.findByEmail(email).get();
            User userReceive=userService.findById(idReceive).get();
            userService.envoyerMessage(userSend, userReceive, contenu, Timestamp.valueOf(LocalDateTime.now()));
            response.put("status",200);
            response.put("message","success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @GetMapping(path = "/allMessage")
    public Hashtable <String,Object> getAllMessage(@RequestHeader Map<String, String> headers, @RequestParam int idReceive) 
    throws Exception {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User userSend=userService.findByEmail(email).get();
            User userReceive=userService.findById(idReceive).get();
            System.out.println("users : "+userSend+" "+userReceive);
            response.put("data", userService.findByUserSendAndUserReceive(userSend, userReceive));
            response.put("status",200);
            response.put("message","ok");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @GetMapping(path = "/allUserDiscuss")
    public Hashtable <String,Object> getAllPersonneDiscuss(@RequestHeader Map<String, String> headers) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User user=userService.findByEmail(email).get();
            System.out.println(user);
            response.put("data", userService.findDistinctUsersForUser(user));
            response.put("status",200);
            response.put("message","ok");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }
    @GetMapping("/findUserConnected")
    public Hashtable <String,Object>  getUserConnected(@RequestHeader Map<String, String> headers) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            response.put("data", userService.findByEmail(email).get());
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
