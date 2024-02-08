package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.ModelcategorieMi;
import com.dev.repository.ModelcategorieMiRep;
import java.util.List;
import java.util.Optional;
@Service
public class ModelcategorieMiSer {

    @Autowired
    private ModelcategorieMiRep repository;
    
    public ModelcategorieMi save(ModelcategorieMi Motif) {
        return repository.save(Motif);
    }
    public List<ModelcategorieMi> getAll() {
        return repository.findAll();
    }
    public ModelcategorieMi[] getTabAll(){
        List<ModelcategorieMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        ModelcategorieMi[] tabs=new ModelcategorieMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            tabs[i]=lst.get(i);
        }
        return tabs;
    }
    // Méthode pour récupérer un  par son ID
    public Optional<ModelcategorieMi> getById(int id) {
        return repository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        repository.deleteById(id);
    }
}
