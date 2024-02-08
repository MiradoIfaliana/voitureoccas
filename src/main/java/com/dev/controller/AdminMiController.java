package com.dev.controller;

import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.body.*;
import com.dev.exception.ExceptionCar;
import com.dev.models.*;
import com.dev.service.AdminsMiSer;
import com.dev.service.AnnonceMiSer;
import com.dev.service.AnnoncedetailMi_vSer;
import com.dev.service.AnnoncefavorisMiSer;
import com.dev.service.ModelsMi_vSer;
import com.dev.service.RegletauxMiSer;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/adminmir")
public class AdminMiController {
    
    @Autowired
    private AnnonceMiSer annonceMiSer;
    @Autowired
    private AnnoncedetailMi_vSer annoncedetailMi_vSer;
    @Autowired
    private RegletauxMiSer regletauxMiSer;
    @Autowired
    private AdminsMiSer adminsMiSer;
    @Autowired
    private ModelsMi_vSer modelsMi_vSer;

    @GetMapping(path = "/hello" , produces = "application/json")
    public String getHello(){
        return "Hello Mirado!!";
    }
    @GetMapping("/hello1")
    public String getHello1(){
        return "Hello All !!";
    }

    //Mandeha
    @GetMapping("/getAnnoncesNonValider")//ok
    public Hashtable <String,Object> getAnnoncesNonValider(@RequestParam int nbaffiche,@RequestParam int numlinebeforefirst) {
        Hashtable <String,Object> response=new Hashtable<>();
        try{
            List<AnnoncedetailMi_v> lstA= annoncedetailMi_vSer.getAllEncoursByNbafficheByNumlineBeforFirst(nbaffiche,numlinebeforefirst );
            List<AnnonceBodyMi> lstAB=new AnnonceBodyMi().createListByListAnnoncedetailMi_v(lstA);
            response.put("message","ok");
            response.put("canPrev",annoncedetailMi_vSer.canPrev_Encours( nbaffiche, numlinebeforefirst));
            response.put("canNext",annoncedetailMi_vSer.canNext_Encours( nbaffiche, numlinebeforefirst));
            if(lstAB!=null){
                if(lstAB.isEmpty()==false){
                response.put("status",200);
                response.put("data",lstAB);
                }else{
                    response.put("status",201);
                }
            }else{
                response.put("status",201);
            }
        }catch(Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message","error");
            response.put("cause",e.getMessage());
        }
        
        return response;
    }

    //Mandeha
    @PostMapping("/validerAnnonce")//ok
    public Hashtable <String,Object> validerAnnonce( @RequestParam int idadmin,@RequestParam int idannonce) {   
        Hashtable <String,Object> response=new Hashtable<>();
        
        try{
            annonceMiSer.valider(idannonce,idadmin);
            response.put("status",200);
            response.put("message","succes");
        }catch(ExceptionCar ec){
            ec.printStackTrace();
            response.put("status",500);
            response.put("message",ec.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message","error");
            response.put("cause",e.getMessage());
        }
        return response;
    }

    //Mandeha 
    @GetMapping("/refuserAnnonce") 
    public Hashtable <String,Object> refuserAnnonce( @RequestParam int idadmin,@RequestParam int idannonce) {  
        Hashtable <String,Object> response=new Hashtable<>();  
        try{
          annonceMiSer.refuser(idannonce, idadmin);
          response.put("status",200);
          response.put("message","succes");
        }catch(ExceptionCar ec){
            ec.printStackTrace();
            response.put("status",500);
            response.put("message",ec.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message","error");
            response.put("cause",e.getMessage());
        }
        return response;
    }

    //-------------------recherche
    @PostMapping("/searchOnNonValider")//ok
    public Hashtable <String,Object> searchOnNonValider( @RequestBody SearchPub search) {
        Hashtable <String,Object> response=new Hashtable<>(); 
        try{
            List<AnnoncedetailMi_v> lstA= annoncedetailMi_vSer.getSearchAllEncoursByNbafficheByNumlineBeforFirst( search.getWord(), search.getIdmarque(), search.getIdmodel() , search.getNbplace(), search.getPrix1(), search.getPrix2(),search.getAnneefab(), search.getIdcategories());
            List<AnnonceBodyMi> lstAB=new AnnonceBodyMi().createListByListAnnoncedetailMi_v(lstA);
            response.put("message","ok");
            if(lstAB!=null){
                if(lstAB.isEmpty()==false){
                response.put("status",200);
                response.put("data",lstAB);
                }else{
                    response.put("status",201);
                }
            }else{
                response.put("status",201);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }
    //-------------------------------------------------------------------------
    //mety
    @GetMapping("/changetauxcommision")//ok
    public Hashtable <String,Object> changetauxcommision( @RequestParam float tauxpourcent) {
        Hashtable <String,Object> response=new Hashtable<>(); 
        try{
            regletauxMiSer.modifeOrCreateIfNotExist(tauxpourcent);
            response.put("status",200);
            response.put("message","succes");
        }catch(ExceptionCar ec){
            ec.printStackTrace();
            response.put("status",500);
            response.put("message",ec.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message","error");
            response.put("cause",e.getMessage());
        }
        return response;
    }

    @PostMapping("/logAdmin")
    public Hashtable <String,Object> loginAdmin(@RequestParam String mail, @RequestParam String pwd) {
        Hashtable <String,Object> response=new Hashtable<>();
        try {
            response.put("data", adminsMiSer.getCorrespondingAdmin(mail, pwd));
            response.put("status",200);
            response.put("message","ok");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @GetMapping("getDetailAnnonce")
    public Hashtable <String,Object> getDetailAnnonce( @RequestParam int iduser, @RequestParam int idannonce) {
        Hashtable <String,Object> response=new Hashtable<>(); 
        try{
            AnnonceBodyMi a=annoncedetailMi_vSer.getByIdannonceByIduser(idannonce, iduser);
            response.put("status",200);
            response.put("message","ok");
            if(a!=null){
                response.put("data",a);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }

    @GetMapping("getRegletauxCommission")
    public Hashtable <String,Object> getRegletauxCommission( ) {
        Hashtable <String,Object> response=new Hashtable<>(); 
        try{
            RegletauxMi regletauxMi=regletauxMiSer.getRegletauxMi_commission();
            
            response.put("message","ok");
            if(regletauxMi!=null){
                response.put("status",200);
                response.put("data",regletauxMi);
            }
            else{
                response.put("status",201);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }


    
}
