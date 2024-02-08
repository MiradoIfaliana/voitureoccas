package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.AnnonceBodyMi;
import com.dev.models.AnnoncedetailMi_v;
import com.dev.repository.AnnoncedetailMiPersoRep;
import com.dev.repository.AnnoncedetailMi_vRep;

import java.sql.Date;
import java.util.List;
@Service
public class AnnoncedetailMi_vSer {

    @Autowired
    private AnnoncedetailMi_vRep annonceRepository;
    @Autowired
    private AnnoncedetailMiPersoRep annoncedetaipersoRepository;
    public List<AnnoncedetailMi_v> getAllByNotIduserByNbafficheByNumlineBeforFirst(int iduser,int nbaffiche,int numlineBeforeFirst ){
        return annonceRepository.getByNotIduser(iduser,nbaffiche,numlineBeforeFirst);
    }//getByIduser(@Param("iduser")int iduser,@Param("nbaffiche")int nbaffiche,@Param("numlineBeforeFirst")int numlineBeforeFirst ) 
    public boolean canPrev_ByNotIduser(int iduser,int nbaffiche,int numlineBeforeFirst){
        if(numlineBeforeFirst-1<0){ return false; }
        else if(nbaffiche==0){ return false; }
        List<AnnoncedetailMi_v> list=annonceRepository.getByNotIduser(iduser, 1, numlineBeforeFirst-1);// >=1 et >1 et misy valiny  -->veut dire misy misy en arrier zany 
        if(list.isEmpty()==true){ return false; }
        return true;
    }
    public boolean canNext_ByNotIduser(int iduser,int nbaffiche,int numlineBeforeFirst){
        List<AnnoncedetailMi_v> list=annonceRepository.getByNotIduser(iduser, 1, numlineBeforeFirst+nbaffiche);// >=1 et >1 et misy valiny  -->veut dire misy misy en arrier zany 
        if(list.isEmpty()==true){ return false; }
        return true;
    }

    public List<AnnoncedetailMi_v> getAllByIduserByNbafficheByNumlineBeforFirst(int iduser,int nbaffiche,int numlineBeforeFirst ){
        return annonceRepository.getByIduser(iduser,nbaffiche,numlineBeforeFirst);
    }
    public boolean canPrev_ByIduser(int iduser,int nbaffiche,int numlineBeforeFirst){
        if(numlineBeforeFirst-1<0){ return false; }
        else if(nbaffiche==0){ return false; }
        List<AnnoncedetailMi_v> list=annonceRepository.getByIduser(iduser, 1, numlineBeforeFirst-1);// >=1 et >1 et misy valiny  -->veut dire misy misy en arrier zany 
        if(list.isEmpty()==true){ return false; }
        return true;
    }
    public boolean canNext_ByIduser(int iduser,int nbaffiche,int numlineBeforeFirst){
        List<AnnoncedetailMi_v> list=annonceRepository.getByIduser(iduser, 1, numlineBeforeFirst+nbaffiche);// >=1 et >1 et misy valiny  -->veut dire misy misy en arrier zany 
        if(list.isEmpty()==true){ return false; }
        return true;
    }
    
    public List<AnnoncedetailMi_v> getAllFavorisByIduserByNbafficheByNumlineBeforFirst(int iduser,int nbaffiche,int numlineBeforeFirst ){
        return annonceRepository.getFavorisByIduser(iduser,nbaffiche,numlineBeforeFirst);
    }
    public boolean canPrev_FavorisByIduser(int iduser,int nbaffiche,int numlineBeforeFirst){
        if(numlineBeforeFirst-1<0){ return false; }
        else if(nbaffiche==0){ return false; }
        List<AnnoncedetailMi_v> list=annonceRepository.getFavorisByIduser(iduser, 1, numlineBeforeFirst-1);// >=1 et >1 et misy valiny  -->veut dire misy misy en arrier zany 
        if(list.isEmpty()==true){ return false; }
        return true;
    }
    public boolean canNext_FavorisByIduser(int iduser,int nbaffiche,int numlineBeforeFirst){
        List<AnnoncedetailMi_v> list=annonceRepository.getFavorisByIduser(iduser, 1, numlineBeforeFirst+nbaffiche);// >=1 et >1 et misy valiny  -->veut dire misy misy en arrier zany 
        if(list.isEmpty()==true){ return false; }
        return true;
    }

    public List<AnnoncedetailMi_v> getAllEncoursByNbafficheByNumlineBeforFirst(int nbaffiche,int numlineBeforeFirst ){
        return annonceRepository.getEncours(nbaffiche, numlineBeforeFirst);
    }
    public boolean canPrev_Encours(int nbaffiche,int numlineBeforeFirst){
        if(numlineBeforeFirst-1<0){ return false; }
        else if(nbaffiche==0){ return false; }
        List<AnnoncedetailMi_v> list=annonceRepository.getEncours( 1, numlineBeforeFirst-1);// >=1 et >1 et misy valiny  -->veut dire misy misy en arrier zany 
        if(list.isEmpty()==true){ return false; }
        return true;
    }
    public boolean canNext_Encours( int nbaffiche,int numlineBeforeFirst){
        List<AnnoncedetailMi_v> list=annonceRepository.getEncours( 1, numlineBeforeFirst+nbaffiche);// >=1 et >1 et misy valiny  -->veut dire misy misy en arrier zany 
        if(list.isEmpty()==true){ return false; }
        return true;
    }

    public String createSuiteRequeteRechercher(String word,int idmarque,int idmodel,int nbplace,double prix1,double prix2,int anneefab,int[] idcategories)
    {
        String suitquery=" and ";
        if(word!=null){
            String wordNoSpace=word.replaceAll(" ","");
            if(wordNoSpace.compareTo("")!=0){
                String[] colint={ "ad_v.nombreplace","ad_v.anneefab","ad_v.prixvente","ad_v.kilometrage","ad_v.vitesse" };
                String[] coldouble={ "ad_v.nombreplace","ad_v.prixvente","ad_v.kilometrage","ad_v.vitesse" };
                String[] coldate={"TO_CHAR(ad_v.dateannonce, 'YYYY-MM-DD')","TO_CHAR(ad_v.dateannonce, 'DD-MM-YYYY')","TO_CHAR(ad_v.dateannonce, 'YYYY/MM/DD')","TO_CHAR(ad_v.dateannonce, 'DD/MM/YYYY')"};
                String[] colvarchar={ "ad_v.descriptions","ad_v.nomlieu","ad_v.nomvoiture","ad_v.nomtransmission","ad_v.nomuser","ad_v.prenomuser","ad_v.nomcarburant","ad_v.nommarque","ad_v.nommodel","ad_v.nomcategorie"};
                String[] colsearch=colvarchar;
                String compar="=";
                String entour1="\'";
                String entour2="\'";
                try{    
                    Integer.valueOf(wordNoSpace);
                    colsearch=colint;    
                    compar="=";
                    entour1="";   
                    entour2="";   
                }catch(Exception e){  
                    try{    
                        Double.valueOf(wordNoSpace);
                        colsearch=coldouble; 
                        compar="=";
                        entour1="";
                        entour2="";
                    }catch(Exception e1){ 
                        try{    
                            Date.valueOf(wordNoSpace);
                            colsearch=coldate;
                            //TO_CHAR(dateannonce, 'YYYY-MM-DD') LIKE '%2024-01-23%'
                            //TO_CHAR(timestamp_column, 'YYYY-MM-DD')
                            compar="Ilike";
                            entour1="\'%";
                            entour2="%\'";
                        }catch(Exception e2){ //rehafa tsy castable int,double,date
                            colsearch=colvarchar;
                            compar="Ilike";
                            entour1="\'%";
                            entour2="%\'";
                        }
                    }
                }
                suitquery=suitquery+" ("+colsearch[0]+" "+compar+" "+entour1+""+word+""+entour2;
                for(int i=1;i<colsearch.length;i++){
                    suitquery=suitquery+" or "+colsearch[i]+" "+compar+" "+entour1+""+word+""+entour2;
                }
                suitquery=suitquery+") and";
            }
        }
        if(idmarque!=0){ suitquery=suitquery+" ad_v.idmarque="+idmarque+" and"; }
        if(idmodel!=0){ suitquery=suitquery+" ad_v.idmodel="+idmodel+" and"; }
        if(nbplace!=0){ suitquery=suitquery+" ad_v.nombreplace="+nbplace+" and"; }
        if(anneefab!=0){ suitquery=suitquery+" ad_v.anneefab="+anneefab+" and"; }
        if(prix1>0 || prix2>0){ suitquery=suitquery+" ad_v.prixvente  between "+prix1+" and "+prix2+" and"; }
        if(idcategories!=null){ 
            for(int i=0;i<idcategories.length;i++){
                if(i==0){ suitquery=suitquery+"("; }
                suitquery=suitquery+" ad_v.idcategorie="+idcategories[i]+" or ";
            }
            if(idcategories.length!=0){
                suitquery=suitquery.substring(0,suitquery.length()-3)+")"; //esorina le "or "
            }
        }
        if(suitquery.substring(suitquery.length()-3,suitquery.length()).compareToIgnoreCase("and")==0){ 
            suitquery=suitquery.substring(0,suitquery.length()-3); //esorina ny "and" 
        }
        if(suitquery.replaceAll(" ","").compareToIgnoreCase("and")==0){ suitquery=""; } //raha tsy nisy recherche mihintsy
        return suitquery;

    }

    public List<AnnoncedetailMi_v> getSearchAllByNotIduserByNbafficheByNumlineBeforFirst(int iduser,String word,int idmarque,int idmodel,int nbplace,double prix1,double prix2,int anneefab,int[] idcategories){
        String suitequery=createSuiteRequeteRechercher(word, idmarque, idmodel,  nbplace, prix1, prix2, anneefab, idcategories);
        return annoncedetaipersoRepository.getSearchByNotIduser(iduser, suitequery);
    }//getByIduser(@Param("iduser")int iduser,@Param("nbaffiche")int nbaffiche,@Param("numlineBeforeFirst")int numlineBeforeFirst ) 

    public List<AnnoncedetailMi_v> getSearchAllByIduserByNbafficheByNumlineBeforFirst(int iduser,String word,int idmarque,int idmodel,int nbplace,double prix1,double prix2,int anneefab,int[] idcategories ){
        String suitequery=createSuiteRequeteRechercher(word, idmarque, idmodel,  nbplace, prix1, prix2,anneefab, idcategories);
        return annoncedetaipersoRepository.getSearchByIduser(iduser, suitequery);
    }

    public List<AnnoncedetailMi_v> getSearchAllEncoursByNbafficheByNumlineBeforFirst(String word,int idmarque,int idmodel,int nbplace,double prix1,double prix2,int anneefab,int[] idcategories ){
        String suitequery=createSuiteRequeteRechercher(word, idmarque, idmodel,  nbplace, prix1, prix2,anneefab, idcategories);
        return annoncedetaipersoRepository.getSearchEncours( suitequery);
    }

    public AnnonceBodyMi getByIdannonceByIduser(int idannonce,int iduser)throws Exception{
        return annonceRepository.getByIdannonce(iduser, idannonce);
    }
}

//SELECT * FROM annonce WHERE TO_CHAR(dateannonce, 'YYYY-MM-DD') LIKE '%2024-01-23%';