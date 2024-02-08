package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.RegletauxMi;
import com.dev.repository.RegletauxMiRep;
import java.util.List;
import java.util.Optional;
@Service
public class RegletauxMiSer {

    @Autowired
    private RegletauxMiRep repository;
    
    public RegletauxMi save(RegletauxMi Regletaux) {
        return repository.save(Regletaux);
    }
    public List<RegletauxMi> getAll() {
        return repository.findAll();
    }
    public RegletauxMi[] getTabAll(){
        List<RegletauxMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        RegletauxMi[] tabs=new RegletauxMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            tabs[i]=lst.get(i);
        }
        return tabs;
    }
    public double getTauxCommision(){
       List<Double> tc= repository.getTauxCommision();
       if(tc.isEmpty()==true){ return 0; }
       else return tc.get(0);
    }
    public RegletauxMi getRegletauxMi_commission(){
        List<RegletauxMi> lst= repository.getRegletaux_Commision();
        if(lst.isEmpty()==true){ return null; }
        else{ return lst.get(0); }
     }
 
     // idregletaux | coderegle |  nomregle  | tauxpourcent
     // -------------+-----------+------------+--------------
     //            1 | C000      | commission |          0.1
     public void modifeOrCreateIfNotExist(float tauxSansSur100)throws Exception{
         RegletauxMi r=getRegletauxMi_commission();
         if(r==null){
             r=new RegletauxMi(0, "C000", "commission", tauxSansSur100);
         }else{
             r.setTauxpourcent(tauxSansSur100);
         }
         repository.save(r);
     }
    // Méthode pour récupérer un  par son ID
    public Optional<RegletauxMi> getById(int id) {
        return repository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        repository.deleteById(id);
    }
}
