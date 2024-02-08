package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.SoldesiteMi;
import com.dev.repository.SoldesiteMiRep;
import java.util.List;
import java.util.Optional;
@Service
public class SoldesiteMiSer {

    @Autowired
    private SoldesiteMiRep repository;
    
    public SoldesiteMi save(SoldesiteMi Soldesite) {
        return repository.save(Soldesite);
    }
    public List<SoldesiteMi> getAll() {
        return repository.findAll();
    }
    public SoldesiteMi[] getTabAll(){
        List<SoldesiteMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        SoldesiteMi[] tabs=new SoldesiteMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            tabs[i]=lst.get(i);
        }
        return tabs;
    }
    public SoldesiteMi getSoldesiteMi(){
        List<SoldesiteMi> ls=repository.findAll();
        if(ls.isEmpty()==true){ return null; }
        else{ return ls.get(0); }
    }
    // Méthode pour récupérer un  par son ID
    public Optional<SoldesiteMi> getById(int id) {
        return repository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        repository.deleteById(id);
    }
}
