package com.dev.models;
import java.sql.Date;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="admins")
public class AdminsMi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idadmins; 
    String nomadmin; 
    String prenomadmin; 
    String mail; 
    Date nee; 
    String pwd; 

    public AdminsMi(){ }
    
    public int getIdadmins(){
        return this.idadmins;
    }
    public void setIdadmins(int idadmins){
        this.idadmins=idadmins;
    }
    public String getNomadmin(){
        return this.nomadmin;
    }
    public void setNomadmin(String nomadmin){
        this.nomadmin=nomadmin;
    }
    public String getPrenomadmin(){
        return this.prenomadmin;
    }
    public void setPrenomadmin(String prenomadmin){
        this.prenomadmin=prenomadmin;
    }
    public String getMail(){
        return this.mail;
    }
    public void setMail(String mail){
        this.mail=mail;
    }
    public Date getNee(){
        return this.nee;
    }
    public void setNee(Date nee){
        this.nee=nee;
    }
    public String getPwd(){
        return this.pwd;
    }
    public void setPwd(String pwd){
        this.pwd=pwd;
    }

}
