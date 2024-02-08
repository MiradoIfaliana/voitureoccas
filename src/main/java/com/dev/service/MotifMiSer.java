package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.MotifMi;
import com.dev.repository.MotifMiRep;
import java.util.List;
import java.util.Optional;
@Service
public class MotifMiSer {

    @Autowired
    private MotifMiRep repository;
    
    public MotifMi save(MotifMi Motif) {
        return repository.save(Motif);
    }
    public List<MotifMi> getAll() {
        return repository.findAll();
    }
    public MotifMi[] getTabAll(){
        List<MotifMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        MotifMi[] tabs=new MotifMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            tabs[i]=lst.get(i);
        }
        return tabs;
    }
    public MotifMi getMotifCommission(){
        List<MotifMi> lm=repository.getMotifCommission();
        if(lm.isEmpty()==true){ return null; }
        else{ return lm.get(0); }
    }
    // Méthode pour récupérer un  par son ID
    public Optional<MotifMi> getById(int id) {
        return repository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        repository.deleteById(id);
    }
}
