package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.models.AnnoncevalidationMi;
import com.dev.repository.AnnoncevalidationMiRep;
import java.util.List;
import java.util.Optional;
@Service
public class AnnoncevalidationMiSer {

    @Autowired
    private AnnoncevalidationMiRep annonceRepository;

    public AnnoncevalidationMi save(AnnoncevalidationMi Annonce) {
        return annonceRepository.save(Annonce);
    }
    public List<AnnoncevalidationMi> getAll() {
        return annonceRepository.findAll();
    }
    public AnnoncevalidationMi[] getTabAll(){
        List<AnnoncevalidationMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        AnnoncevalidationMi[] Annonces=new AnnoncevalidationMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            Annonces[i]=lst.get(i);
        }
        return Annonces;
    }
    // Méthode pour récupérer un  par son ID
    public Optional<AnnoncevalidationMi> getById(int id) {
        return annonceRepository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        annonceRepository.deleteById(id);
    }
}
