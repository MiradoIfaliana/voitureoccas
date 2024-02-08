package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.VenduMi;
import com.dev.repository.VenduMiRep;
import java.util.List;
import java.util.Optional;
@Service
public class VenduMiSer {

    @Autowired
    private VenduMiRep repository;
    
    public VenduMi save(VenduMi Motif) {
        return repository.save(Motif);
    }
    public List<VenduMi> getAll() {
        return repository.findAll();
    }
    public VenduMi[] getTabAll(){
        List<VenduMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        VenduMi[] tabs=new VenduMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            tabs[i]=lst.get(i);
        }
        return tabs;
    }
    // Méthode pour récupérer un  par son ID
    public Optional<VenduMi> getById(int id) {
        return repository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        repository.deleteById(id);
    }
}
