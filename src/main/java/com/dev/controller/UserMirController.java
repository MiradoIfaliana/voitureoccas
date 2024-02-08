package com.dev.controller;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dev.body.*;
import com.dev.config.JwtService;
import com.dev.exception.ExceptionCar;
import com.dev.model.user.User;
import com.dev.models.*;
import com.dev.service.VoitureinfoMiSer;

import lombok.RequiredArgsConstructor;

import com.dev.service.ActivityUserAnnonce_vSer;
import com.dev.service.AnnonceMiSer;
import com.dev.service.AnnoncedetailMi_vSer;
import com.dev.service.AnnoncefavorisMiSer;
import com.dev.service.CreditersoldeuserMiSer;
import com.dev.service.LieuMiSer;
import com.dev.service.ModelsMi_vSer;
import com.dev.service.SoldeuserMiSer;
import com.dev.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/usermir")
@RequiredArgsConstructor
public class UserMirController {
    
    @Autowired
    private VoitureinfoMiSer voitureinfoMiSer;
    @Autowired
    private AnnonceMiSer annonceMiSer;
    @Autowired
    private AnnoncedetailMi_vSer annoncedetailMi_vSer;
    @Autowired
    private AnnoncefavorisMiSer annoncefavorisMiSer;
    @Autowired
    private CreditersoldeuserMiSer creditersoldeuserMiSer;
    @Autowired
    private SoldeuserMiSer soldeuserMiSer;
    @Autowired
    private ActivityUserAnnonce_vSer activityUserAnnonce_vSer;
    @Autowired
    private ModelsMi_vSer modelsMi_vSer;
    @Autowired
    private LieuMiSer lieuMiSer;

    private final UserService userService;
    private final JwtService jwtService;


    @GetMapping(path = "/hello" , produces = "application/json")
    public String getHello(){
        return "Hello Mirado!!";
    }
    @GetMapping("/hello1")
    public String getHello1(){
        return "Hello All !!";
    }
    //Mandeha
    @PostMapping("/ajoutinfocar")//ok
    public Hashtable <String,Object> ajoutinfocar(@RequestHeader Map<String, String> headers, @RequestBody InfoCar infoCar) {
        Hashtable <String,Object> response=new Hashtable<>();
        
        try{
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User user=userService.findByEmail(email).get();
            voitureinfoMiSer.saveByInfoCar(infoCar,user.getId());
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

    //mandeha
    @GetMapping("/getVoitureInfoOfUser")//ok
    public Hashtable <String,Object>  getVoitureInfoOfUser(@RequestHeader Map<String, String> headers){
        Hashtable <String,Object> response=new Hashtable<>();
        
        try{
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User user=userService.findByEmail(email).get();
            List<VoitureinfoMi> lst=voitureinfoMiSer.getListByIduser(user.getId());
            response.put("message","succes");
            if(lst!=null){
                if(lst.isEmpty()==false){
                response.put("status",200);
                response.put("voitures",lst);
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
        //mandeha
    @GetMapping("/getAllLieu")//ok
        public Hashtable <String,Object>  getAllLieu(){
            Hashtable <String,Object> response=new Hashtable<>();
            
            try{
                List<LieuMi> lst=lieuMiSer.getAll();
                response.put("message","succes");
                if(lst!=null){
                    if(lst.isEmpty()==false){
                    response.put("status",200);
                    response.put("lieux",lst);
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

    @PostMapping("/creersoldecompte")//ok
    public Hashtable <String,Object>  creercompte(@RequestHeader Map<String, String> headers){
        Hashtable <String,Object> response=new Hashtable<>();
        
        try{
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User user=userService.findByEmail(email).get();
            soldeuserMiSer.createSoldeUserIfExiste(user.getId());
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
    
    @PostMapping("/ajoutannonce") //ok
    public Hashtable <String,Object> ajoutannonce2(@RequestHeader Map<String, String> headers ,@RequestParam int idvoitureinfo,@RequestParam int idlieu,@RequestParam double prixvente,@RequestParam String description,@RequestParam MultipartFile[] files) {
        Hashtable <String,Object> response=new Hashtable<>();
        
        try{
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User user=userService.findByEmail(email).get();
            Annoncesave annoncesave=new Annoncesave(idvoitureinfo, idlieu, prixvente, description, files);
            annonceMiSer.insertAnnonce2(annoncesave,user.getId());
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
    @GetMapping(path="/getPubAnnonces",produces = "application/json") //ok
    public Hashtable<String,Object> getPubAnnoces( @RequestParam int iduser,@RequestParam int nbaffiche,@RequestParam int numlinebeforefirst) {
        Hashtable <String,Object> response=new Hashtable<>();
        try{
            List<AnnoncedetailMi_v> lstA= annoncedetailMi_vSer.getAllByNotIduserByNbafficheByNumlineBeforFirst(iduser, nbaffiche, numlinebeforefirst);
            List<AnnonceBodyMi> lstAB=new AnnonceBodyMi().createListByListAnnoncedetailMi_v(lstA);
            response.put("message","ok");
            response.put("canPrev",annoncedetailMi_vSer.canPrev_ByNotIduser(iduser, nbaffiche, numlinebeforefirst));
            response.put("canNext",annoncedetailMi_vSer.canNext_ByNotIduser(iduser, nbaffiche, numlinebeforefirst));
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
    //Mandeha
    @GetMapping("/getMesAnnonces")//ok
    public Hashtable <String,Object> getMesAnnoces( @RequestHeader Map<String, String> headers,@RequestParam int nbaffiche,@RequestParam int numlinebeforefirst) {
        Hashtable <String,Object> response=new Hashtable<>();
        try{
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User user=userService.findByEmail(email).get();
            List<AnnoncedetailMi_v> lstA= annoncedetailMi_vSer.getAllByIduserByNbafficheByNumlineBeforFirst(user.getId(), nbaffiche, numlinebeforefirst);
            List<AnnonceBodyMi> lstAB=new AnnonceBodyMi().createListByListAnnoncedetailMi_v(lstA);
            response.put("message","ok");
            response.put("canPrev",annoncedetailMi_vSer.canPrev_ByIduser(user.getId(), nbaffiche, numlinebeforefirst));
            response.put("canNext",annoncedetailMi_vSer.canNext_ByIduser(user.getId(), nbaffiche, numlinebeforefirst));
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
    //Mandeha
    @GetMapping("/getMesAnnoncesFavoris")//ok
    public Hashtable <String,Object> getMesAnnocesFavoris( @RequestHeader Map<String, String> headers,@RequestParam int nbaffiche,@RequestParam int numlinebeforefirst) {
        Hashtable <String,Object> response=new Hashtable<>();
        try{
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User user=userService.findByEmail(email).get();
            List<AnnoncedetailMi_v> lstA= annoncedetailMi_vSer.getAllFavorisByIduserByNbafficheByNumlineBeforFirst(user.getId(), nbaffiche, numlinebeforefirst);
            List<AnnonceBodyMi> lstAB=new AnnonceBodyMi().createListByListAnnoncedetailMi_v(lstA);
            
            response.put("message","ok");
            response.put("canPrev",annoncedetailMi_vSer.canPrev_FavorisByIduser(user.getId(), nbaffiche, numlinebeforefirst));
            response.put("canNext",annoncedetailMi_vSer.canNext_FavorisByIduser(user.getId(), nbaffiche, numlinebeforefirst));
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
    //mandeha
    @GetMapping("/favorisation")//ok
    public Hashtable <String,Object> getPubAnnoces( @RequestHeader Map<String, String> headers,@RequestParam int idannonce) {
        Hashtable <String,Object> response=new Hashtable<>();
        
        try{
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User user=userService.findByEmail(email).get();
            annoncefavorisMiSer.verifeInsert(user.getId(), idannonce);
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
    @PostMapping("/creditercompte")//ok
    public Hashtable <String,Object> creditercompte(@RequestHeader Map<String, String> headers,@RequestParam String code) {   
        Hashtable <String,Object> response=new Hashtable<>();
        
        try{
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User user=userService.findByEmail(email).get();
            creditersoldeuserMiSer.crediterByIduserByCodecredit( user.getId(),code);
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
    //mandeha
    @GetMapping("/changerStatusAnnonce") //ok
    public Hashtable <String,Object> changerStatusAnnonce( @RequestHeader Map<String, String> headers,@RequestParam int idannonce,@RequestParam String datevente) {  
        Hashtable <String,Object> response=new Hashtable<>(); 
        
        try{
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User user=userService.findByEmail(email).get();
            annonceMiSer.changerstatusMyAnnonce(user.getId(), idannonce, datevente);
            response.put("status",200);
            response.put("message","succes");
        }
        catch(ExceptionCar ec){
            ec.printStackTrace();
            response.put("status",500);
            response.put("message",ec.getMessage());
        }
        catch(Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message","error");
            response.put("cause",e.getMessage());
        }
        return response;
    }
    
    @PostMapping("/searchOnPubAnnonce")//okok?
    public Hashtable <String,Object> searchOnPubAnnonce( @RequestBody Search search) {
        System.out.println("tonngaaaaa1111");
        Hashtable <String,Object> response=new Hashtable<>(); 
        try{
            List<AnnoncedetailMi_v> lstA= annoncedetailMi_vSer.getSearchAllByNotIduserByNbafficheByNumlineBeforFirst(search.getIduser(), search.getWord(), search.getIdmarque(), search.getIdmodel(), search.getNbplace(), search.getPrix1(), search.getPrix2(),search.getAnneefab(), search.getIdcategories());
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
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response;
    }
    @GetMapping("getModelsParMarque")
    public Hashtable <String,Object> getModelsParMarques(@RequestParam int idmarque) {
        Hashtable <String,Object> response=new Hashtable<>(); 
        try{
            MarqueModelsMi data=modelsMi_vSer.getMarqueModelsMiByIdMarque(idmarque);
            response.put("message","ok");
            if(data!=null){
                response.put("status",200);
                response.put("data",data);
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
    @GetMapping("getModelsParMarques")
    public Hashtable <String,Object> getModelsParMarques() {
        Hashtable <String,Object> response=new Hashtable<>(); 
        try{
            List<MarqueModelsMi> lst=modelsMi_vSer.getAllMarqueModelsMi();
            response.put("message","ok");
            if(lst!=null){
                if(lst.isEmpty()==false){
                response.put("status",200);
                response.put("data",lst);
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
    @PostMapping("/searchOnMesAnnonces")//ok
    public Hashtable <String,Object> searchOnMesAnnonces( @RequestHeader Map<String, String> headers, @RequestBody Search search) {
        Hashtable <String,Object> response=new Hashtable<>(); 
        try{
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User user=userService.findByEmail(email).get();
            List<AnnoncedetailMi_v> lstA= annoncedetailMi_vSer.getSearchAllByIduserByNbafficheByNumlineBeforFirst(user.getId(), search.getWord(), search.getIdmarque(), search.getIdmodel(), search.getNbplace(), search.getPrix1(), search.getPrix2(),search.getAnneefab(), search.getIdcategories());
            List<AnnonceBodyMi> lstAB=new AnnonceBodyMi().createListByListAnnoncedetailMi_v(lstA);
            response.put("status",200);
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
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response; 
    }
    @PostMapping("/activityUserAnnonce")//ok
    public Hashtable <String,Object> activityUserAnnonce( @RequestHeader Map<String, String> headers) {
        Hashtable <String,Object> response=new Hashtable<>(); 
        try{
            String email= jwtService.extractUserMail(headers.get("authorization").substring(7));
            User user=userService.findByEmail(email).get();
            ActivityUserAnnonce_v ac=activityUserAnnonce_vSer.getByIduser(user.getId());
            
            response.put("message","ok");
            if(ac!=null){
                response.put("status",200);
                response.put("data",ac);
            }else{
                response.put("status",201);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("status",500);
            response.put("message",e.getMessage());
        }
        return response; 
    }
}
