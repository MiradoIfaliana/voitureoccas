package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.CategorievoitureMi;
import com.dev.repository.CategorievoitureMiRep;

import java.util.List;
import java.util.Optional;
@Service
public class CategorievoitureMiSer {

    @Autowired
    private CategorievoitureMiRep categorievoitureRepository;

    public CategorievoitureMi save(CategorievoitureMi categorievoiture) {
        return categorievoitureRepository.save(categorievoiture);
    }
    // Méthode pour récupérer tous les 
    public List<CategorievoitureMi> getAll() {
        return categorievoitureRepository.findAll();
    }
    public CategorievoitureMi[] getTabAll(){
        List<CategorievoitureMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        CategorievoitureMi[] categorievoitures=new CategorievoitureMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            categorievoitures[i]=lst.get(i);
        }
        return categorievoitures;
    }
    // Méthode pour récupérer un categorie par son ID
    public Optional<CategorievoitureMi> getById(int id) {
        return categorievoitureRepository.findById(id);
    }
    // Méthode pour supprimer un categorie par son ID
    public void deletecategorie(int id) {
        categorievoitureRepository.deleteById(id);
    }
}
