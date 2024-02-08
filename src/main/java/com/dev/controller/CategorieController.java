package com.dev.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dev.model.categorie.Categorie;
import com.dev.service.CategorieService;
import lombok.RequiredArgsConstructor;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categorie")
@CrossOrigin("*")
public class CategorieController {
    private final CategorieService categorieService;

    @GetMapping(path = "/allCategorie", produces = "application/json")
    public Hashtable <String,Object> getAllCategorie() {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            response.put("data", categorieService.findAllCategorie());
            response.put("status",200);
            response.put("message","ok");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @PostMapping("/insertCategorie")
    public Hashtable <String,Object> insertCategorie(@RequestBody Categorie categorie) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            categorieService.save(categorie);
            response.put("status",200);
            response.put("message","success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @GetMapping("/updateCategorie")
    public Hashtable <String,Object> updateCategorie(@RequestParam int idCategorie, @RequestParam String nomCategorie) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            categorieService.update(idCategorie, nomCategorie);
            response.put("status",200);
            response.put("message","success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @GetMapping("/deleteCategorie")
    public Hashtable <String,Object> deleteCategorie(@RequestParam int idCategorie) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            categorieService.delete(idCategorie);
            response.put("status",200);
            response.put("message","success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @GetMapping("/findCategorieById")
    public Hashtable <String,Object> findCategorieById(@RequestParam int idCategorie) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            response.put("data", categorieService.findById(idCategorie).get());
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
