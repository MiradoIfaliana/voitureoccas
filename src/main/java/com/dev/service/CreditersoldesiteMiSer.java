package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.CreditersoldesiteMi;
import com.dev.repository.CreditersoldesiteMiRep;
import java.util.List;
import java.util.Optional;
@Service
public class CreditersoldesiteMiSer {

    @Autowired
    private CreditersoldesiteMiRep repository;
    
    public CreditersoldesiteMi save(CreditersoldesiteMi Creditersoldesite) {
        return repository.save(Creditersoldesite);
    }
    public List<CreditersoldesiteMi> getAll() {
        return repository.findAll();
    }
    public CreditersoldesiteMi[] getTabAll(){
        List<CreditersoldesiteMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        CreditersoldesiteMi[] tabs=new CreditersoldesiteMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            tabs[i]=lst.get(i);
        }
        return tabs;
    }
    // Méthode pour récupérer un  par son ID
    public Optional<CreditersoldesiteMi> getById(int id) {
        return repository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        repository.deleteById(id);
    }
}
