package com.dev.models;
import java.sql.Timestamp;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="soldeuser")
public class SoldeuserMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idsoldeuser; 
    double solde; 
    Timestamp dateupdate; 
    int iduser; 

    public SoldeuserMi(){ }
    
    public int getIdsoldeuser(){
        return this.idsoldeuser;
    }
    public void setIdsoldeuser(int idsoldeuser){
        this.idsoldeuser=idsoldeuser;
    }
    public double getSolde(){
        return this.solde;
    }
    public void setSolde(double solde){
        this.solde=solde;
    }
    public Timestamp getDateupdate(){
        return this.dateupdate;
    }
    public void setDateupdate(Timestamp dateupdate){
        this.dateupdate=dateupdate;
    }
    public int getIduser(){
        return this.iduser;
    }
    public void setIduser(int iduser){
        this.iduser=iduser;
    }

}
