package com.dev.models;
import java.time.LocalDateTime;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="tokenuser")
public class TokenuserMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idtokenuser; 
    String token; 
    LocalDateTime datedebut; 
    LocalDateTime dateexp; 
    int etats; 
    int iduser; 

    public TokenuserMi(){ }
    
    public int getIdtokenuser(){
        return this.idtokenuser;
    }
    public void setIdtokenuser(int idtokenuser){
        this.idtokenuser=idtokenuser;
    }
    public String getToken(){
        return this.token;
    }
    public void setToken(String token){
        this.token=token;
    }
    public LocalDateTime getDatedebut(){
        return this.datedebut;
    }
    public void setDatedebut(LocalDateTime datedebut){
        this.datedebut=datedebut;
    }
    public LocalDateTime getDateexp(){
        return this.dateexp;
    }
    public void setDateexp(LocalDateTime dateexp){
        this.dateexp=dateexp;
    }
    public int getEtats(){
        return this.etats;
    }
    public void setEtats(int etats){
        this.etats=etats;
    }
    public int getIduser(){
        return this.iduser;
    }
    public void setIduser(int iduser){
        this.iduser=iduser;
    }

}
