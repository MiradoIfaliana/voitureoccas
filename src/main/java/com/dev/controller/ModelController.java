package com.dev.controller;

import java.sql.Date;
import java.util.Hashtable;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dev.model.models.Model;
import com.dev.model.models.model.ModelGet;
import com.dev.service.ModelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/model")
@CrossOrigin("*")
public class ModelController {
    private final ModelService modelService;

    @GetMapping(path = "/allModel", produces = "application/json")
    public Hashtable <String,Object> getAllModel() {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            response.put("data", modelService.findAllModel());
            response.put("status",200);
            response.put("message","ok");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @PostMapping("/insertModel")
    public Hashtable <String,Object> insertModel(@RequestBody ModelGet modelGet) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            modelService.save(modelGet);
            response.put("status",200);
            response.put("message","success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @PostMapping("/updateModel")
    public Model updateModel(@RequestParam int idModel, @RequestParam String nomModel, @RequestParam double vitesse, @RequestParam int idTransmission, @RequestParam Date dateSortie, @RequestParam int idMarque) {
        return modelService.update(idModel, nomModel, vitesse, idTransmission, dateSortie, idMarque);
    }

    @GetMapping("/findModelById")
    public Hashtable <String,Object> findModelById(@RequestParam int idModel) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            response.put("data", modelService.findModelById(idModel).get());
            response.put("status",200);
            response.put("message","ok");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @GetMapping("/deleteModel")
    public Hashtable <String,Object> deleteModel(@RequestParam int idModel) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            modelService.delete(idModel);
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
