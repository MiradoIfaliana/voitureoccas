package com.dev.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.marque.Marque;
import com.dev.service.MarqueService;

import lombok.RequiredArgsConstructor;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/marque")
@CrossOrigin("*")
public class MarqueController {
    private final MarqueService marqueService;

    @GetMapping(path = "/allMarque", produces = "application/json")
    public Hashtable <String,Object> getAllMarque() {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            response.put("data", marqueService.findAllMarque());
            response.put("status",200);
            response.put("message","ok");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @PostMapping("/insertMarque")
    public Hashtable <String,Object> insertMarque(@RequestBody Marque marque) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            marqueService.save(marque);
            response.put("status",200);
            response.put("message","success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @GetMapping("/updateMarque")
    public Hashtable <String,Object> updateMarque(@RequestParam int idMarque, @RequestParam String nomMarque) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            marqueService.update(idMarque, nomMarque);
            response.put("status",200);
            response.put("message","success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @GetMapping("/deleteMarque")
    public Hashtable <String,Object> deleteMarque(@RequestParam int idMarque) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            marqueService.delete(idMarque);
            response.put("status",200);
            response.put("message","success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    
    @GetMapping("/findMarqueById")
    public Hashtable <String,Object> findMarqueById(@RequestParam int idMarque) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            response.put("data", marqueService.findById(idMarque).get());
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
