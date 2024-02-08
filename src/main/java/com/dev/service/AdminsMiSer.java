package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.model.user.Admin;
import com.dev.models.AdminsMi;
import com.dev.repository.AdminRepository;
import com.dev.repository.AdminsMiRep;
import java.util.List;
import java.util.Optional;
@Service
public class AdminsMiSer {

    @Autowired
    private AdminsMiRep annonceRepository;
    @Autowired 
    private AdminRepository adminRepository;
    
    public AdminsMi save(AdminsMi Annonce) {
        return annonceRepository.save(Annonce);
    }

    public Admin getCorrespondingAdmin(String mail, String pwd) {
        return adminRepository.findByMailAndPwd(mail, pwd).get();
    }

    public List<AdminsMi> getAll() {
        return annonceRepository.findAll();
    }
    public AdminsMi[] getTabAll(){
        List<AdminsMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        AdminsMi[] Annonces=new AdminsMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            Annonces[i]=lst.get(i);
        }
        return Annonces;
    }
    // Méthode pour récupérer un  par son ID
    public Optional<AdminsMi> getById(int id) {
        return annonceRepository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        annonceRepository.deleteById(id);
    }
}
