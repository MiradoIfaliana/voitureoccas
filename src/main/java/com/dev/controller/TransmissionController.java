package com.dev.controller;

import java.util.Hashtable;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.transmission.Transmission;
import com.dev.service.TransmissionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transmission")
@CrossOrigin("*")
public class TransmissionController {
    private final TransmissionService transmissionService;

    @GetMapping(path = "/allTransmission", produces = "application/json")
    public Hashtable <String,Object> getAllTransmission() {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            response.put("data", transmissionService.findAllTransmission());
            response.put("status",200);
            response.put("message","ok");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @PostMapping("/insertTransmission")
    public Hashtable <String,Object> insertTransmission(@RequestBody Transmission transmission) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            transmissionService.save(transmission);
            response.put("status",200);
            response.put("message","success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @PostMapping("/updateTransmission")
    public Hashtable <String,Object> updateTransmission(@RequestParam int idTransmission, @RequestParam String nomTransmission) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            transmissionService.update(idTransmission, nomTransmission);
            response.put("status",200);
            response.put("message","success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }  

    @GetMapping("/findTransmissionById")
    public Hashtable <String,Object> findTransmissionById(@RequestParam int idTransmission) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            response.put("data", transmissionService.findById(idTransmission).get());
            response.put("status",200);
            response.put("message","ok");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @GetMapping("/deleteTransmission")
    public Hashtable <String,Object> deleteTransmission(@RequestParam int idTransmission) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            transmissionService.delete(idTransmission);
            response.put("status",200);
            response.put("message","success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }


}
