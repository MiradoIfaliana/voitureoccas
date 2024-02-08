package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.models.AnnoncerefusMi;
import com.dev.repository.AnnoncerefusMiRep;

import java.util.List;
import java.util.Optional;
@Service
public class AnnoncerefusMiSer {

    @Autowired
    private AnnoncerefusMiRep annonceRepository;

    public AnnoncerefusMi save(AnnoncerefusMi Annonce) {
        return annonceRepository.save(Annonce);
    }
    public List<AnnoncerefusMi> getAll() {
        return annonceRepository.findAll();
    }
    public AnnoncerefusMi[] getTabAll(){
        List<AnnoncerefusMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        AnnoncerefusMi[] Annonces=new AnnoncerefusMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            Annonces[i]=lst.get(i);
        }
        return Annonces;
    }
    // Méthode pour récupérer un  par son ID
    public Optional<AnnoncerefusMi> getById(int id) {
        return annonceRepository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        annonceRepository.deleteById(id);
    }
}
