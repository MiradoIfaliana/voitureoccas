package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.ExceptionCar;
import com.dev.models.UserAppToken;
import com.dev.repository.UserAppTokenRep;
import java.util.List;
import java.util.Optional;
@Service
public class UserAppTokenSer {

    @Autowired
    private UserAppTokenRep repository;
    
    public UserAppToken save(UserAppToken Motif) {
        return repository.save(Motif);
    }
    public List<UserAppToken> getAll() {
        return repository.findAll();
    }
    public UserAppToken[] getTabAll(){
        List<UserAppToken> lst=getAll();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        UserAppToken[] tabs=new UserAppToken[lst.size()];
        for(int i=0;i<lst.size();i++){
            tabs[i]=lst.get(i);
        }
        return tabs;
    }
    // Méthode pour récupérer un  par son ID
    public Optional<UserAppToken> getById(int id) {
        return repository.findById(id);
    }
    // Méthode pour supprimer un  par son ID
    public void delete(int id) {
        repository.deleteById(id);
    }

    // public void save(UserAppToken Motif) {
    //     return repository.save(Motif);
    // }

    public void VerifeSave(int iduser,String notiftoken)throws Exception{
        List <UserAppToken> lu= repository.getUserapptoken( iduser,  notiftoken);
        if(lu.isEmpty()==false){ 
            throw new ExceptionCar("il existe deja le notiftoken pour cette user");
        }
        UserAppToken userapptoken=new UserAppToken(0, iduser, notiftoken, 1);
        save(userapptoken);
    }

    public void saveToNoDispo(int iduser,String notiftoken)throws Exception{
        List <UserAppToken> lu= repository.getUserapptoken( iduser,  notiftoken);
        if(lu.isEmpty()==true){ throw new ExceptionCar("l'user n'a pas cette token "); }
        UserAppToken userapptoken=lu.get(0);
        if(userapptoken.getNotifstate()!=1){ throw new ExceptionCar("cette token est deja deconnecté"); }
        userapptoken.setNotifstate(0);
        save(userapptoken);
    }
}
