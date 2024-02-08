package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.models.TokenuserMi;
import com.dev.repository.TokenuserMiRep;
import java.util.List;
import java.util.Optional;
@Service
public class TokenuserMiSer {

    @Autowired
    private TokenuserMiRep tokenuserRepository;
    
    public TokenuserMi save(TokenuserMi tokenuser) {
        return tokenuserRepository.save(tokenuser);
    }
    public List<TokenuserMi> getAll() {
        return tokenuserRepository.findAll();
    }
    public TokenuserMi[] getTabAll(){
        List<TokenuserMi> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        TokenuserMi[] tokenusers=new TokenuserMi[lst.size()];
        for(int i=0;i<lst.size();i++){
            tokenusers[i]=lst.get(i);
        }
        return tokenusers;
    }
    public List<TokenuserMi> getConnecteeByIduser(int iduser){
        return tokenuserRepository.getListConnecteeByIduser(iduser);
    }
    public boolean estConnecter(int iduser){
        if(tokenuserRepository.getListConnecteeByIduser(iduser).isEmpty()==true){ return false; }
        else { return true; }
    }
    // Méthode pour récupérer un  par son ID
    public Optional<TokenuserMi> getById(int id) {
        return tokenuserRepository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        tokenuserRepository.deleteById(id);
    }
}
