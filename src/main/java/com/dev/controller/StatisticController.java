package com.dev.controller;

import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.models.LieuStat;
import com.dev.models.MarqueStat;
import com.dev.models.MoneySite;
import com.dev.models.UserCount;
import com.dev.models.VoitureCount;
import com.dev.repository.CountRespository;
import com.dev.repository.MarqueStatRepository;
import com.dev.repository.MoneyRepository;
import com.dev.repository.Statisque_lieuRepository;
import com.dev.repository.Voiture_count_resp;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/statistic")
public class StatisticController {
    
    @Autowired
    private Statisque_lieuRepository statlieu;
    @Autowired
    private MoneyRepository moneyRepository;
    @Autowired
    private MarqueStatRepository marqueStatRepository;
    @Autowired
    private CountRespository countRespository;  
    @Autowired
    private Voiture_count_resp voiture_count_resp;  
    //Mandeha
    @GetMapping("/getstatisticlieu")//ok
    public Hashtable <String,Object> getstatisticlieu(@RequestParam int annee) {
        Hashtable <String,Object> response=new Hashtable<>();
        try{
          List<LieuStat> lstS=  statlieu.getStatLieu(annee);
          response.put("status",200);
          response.put("message","ok");
          response.put("data",lstS);
        }catch(Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message","error");
            response.put("cause",e.getMessage());
        }
        
        return response;
    }
    @GetMapping("/getstatisticmoney")//ok
    public Hashtable <String,Object> getstatisticmoney(@RequestParam int annee) {
        Hashtable <String,Object> response=new Hashtable<>();
        try{
          List<MoneySite> lst=  moneyRepository.getMoneySite(annee);
          response.put("status",200);
          response.put("message","ok");
          response.put("data",lst);
        }catch(Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message","error");
            response.put("cause",e.getMessage());
        }
        
        return response;
    }
    @GetMapping("/getstatisticmarque")//ok
    public Hashtable <String,Object> getstatisticmarque(@RequestParam int annee) {
        Hashtable <String,Object> response=new Hashtable<>();
        try{
          List<MarqueStat> lstS=  marqueStatRepository.getMarqueStat(annee);
          response.put("status",200);
          response.put("message","ok");
          response.put("data",lstS);
        }catch(Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message","error");
            response.put("cause",e.getMessage());
        }
        
        return response;
    }
    @GetMapping("/getstatisticusercount")//ok
    public Hashtable <String,Object> getstatisticusercount() {
        Hashtable <String,Object> response=new Hashtable<>();
        try{
          List<UserCount> lstS=  countRespository.getCountUser();
          response.put("status",200);
          response.put("message","ok");
          response.put("data",lstS);
        }catch(Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message","error");
            response.put("cause",e.getMessage());
        }
        
        return response;
    }
    @GetMapping("/getstatisticvoiture")//ok
    public Hashtable <String,Object> getstatisticvoiture(@RequestParam int annee) {
        Hashtable <String,Object> response=new Hashtable<>();
        try{
          List<VoitureCount> lstS=  voiture_count_resp.getCountVoiture(annee);
          response.put("status",200);
          response.put("message","ok");
          response.put("data",lstS);
        }catch(Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message","error");
            response.put("cause",e.getMessage());
        }
        
        return response;
    }


}
