package com.dev.models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="annoncefavoris")
public class AnnoncefavorisMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idannoncefavoris; 
    int iduser; 
    int idannonce; 
    public AnnoncefavorisMi(){ }
    
    public AnnoncefavorisMi(int idannoncefavoris, int iduser, int idannonce) {
        setIdannoncefavoris(idannoncefavoris);
        setIduser(iduser);
        setIdannonce(idannonce);
    }
    public int getIdannoncefavoris(){
        return this.idannoncefavoris;
    }
    public void setIdannoncefavoris(int idannoncefavoris){
        this.idannoncefavoris=idannoncefavoris;
    }
    public int getIduser(){
        return this.iduser;
    }
    public void setIduser(int iduser){
        this.iduser=iduser;
    }
    public int getIdannonce(){
        return this.idannonce;
    }
    public void setIdannonce(int idannonce){
        this.idannonce=idannonce;
    }

}
