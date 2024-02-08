package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.AnnoncephotoMi;
import com.dev.repository.AnnoncephotoMiRep;

import java.util.List;
import java.util.Optional;
@Service
public class AnnoncephotoMiSer {

    @Autowired
    private AnnoncephotoMiRep annoncephotoRepository;

    public AnnoncephotoMi save(AnnoncephotoMi Annoncephoto) {
        return annoncephotoRepository.save(Annoncephoto);
    }
    // Méthode pour récupérer tous les s
    public List<AnnoncephotoMi> getAll() {
        return annoncephotoRepository.findAll();
    }
    public AnnoncephotoMi[] getTabAll(){
        List<AnnoncephotoMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        AnnoncephotoMi[] Annoncephotos=new AnnoncephotoMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            Annoncephotos[i]=lst.get(i);
        }
        return Annoncephotos;
    }
    // Méthode pour récupérer un  par son ID
    public Optional<AnnoncephotoMi> getById(int id) {
        return annoncephotoRepository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        annoncephotoRepository.deleteById(id);
    }
}
