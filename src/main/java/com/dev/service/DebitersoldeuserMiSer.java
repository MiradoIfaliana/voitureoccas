package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.DebitersoldeuserMi;
import com.dev.repository.DebitersoldeuserMiRep;
import java.util.List;
import java.util.Optional;
@Service
public class DebitersoldeuserMiSer {

    @Autowired
    private DebitersoldeuserMiRep repository;
    
    public DebitersoldeuserMi save(DebitersoldeuserMi Debitersoldeuser) {
        return repository.save(Debitersoldeuser);
    }
    public List<DebitersoldeuserMi> getAll() {
        return repository.findAll();
    }
    public DebitersoldeuserMi[] getTabAll(){
        List<DebitersoldeuserMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        DebitersoldeuserMi[] tabs=new DebitersoldeuserMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            tabs[i]=lst.get(i);
        }
        return tabs;
    }
    // Méthode pour récupérer un  par son ID
    public Optional<DebitersoldeuserMi> getById(int id) {
        return repository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        repository.deleteById(id);
    }
}
