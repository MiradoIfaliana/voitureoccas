package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.LieuMi;
import com.dev.repository.LieuMiRep;
import java.util.List;
import java.util.Optional;
@Service
public class LieuMiSer {

    @Autowired
    private LieuMiRep repository;
    
    public LieuMi save(LieuMi Motif) {
        return repository.save(Motif);
    }
    public List<LieuMi> getAll() {
        return repository.findAll();
    }
    public LieuMi[] getTabAll(){
        List<LieuMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        LieuMi[] tabs=new LieuMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            tabs[i]=lst.get(i);
        }
        return tabs;
    }

    // Méthode pour récupérer un  par son ID
    public Optional<LieuMi> getById(int id) {
        return repository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        repository.deleteById(id);
    }
}
