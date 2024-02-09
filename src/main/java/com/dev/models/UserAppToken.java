package com.dev.models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="userapptoken")
public class UserAppToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int iduserapptoken ;
    int iduser;
    String  notiftoken ;
    int notifstate = 1;

    public UserAppToken() {
    }

    public UserAppToken(int iduserapptoken, int iduser, String notiftoken, int notifstate) throws Exception{
        setIduserapptoken(iduserapptoken);;
        setIduser(iduser);
        setNotiftoken(notiftoken);
        setNotifstate(notifstate);
    }

    public int getIduserapptoken() {
        return iduserapptoken;
    }
    public void setIduserapptoken(int iduserapptoken) {
        this.iduserapptoken = iduserapptoken;
    }
    public int getIduser() {
        return iduser;
    }
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    public String getNotiftoken() {
        return notiftoken;
    }
    public void setNotiftoken(String notiftoken) {
        this.notiftoken = notiftoken;
    }
    public int getNotifstate() {
        return notifstate;
    }
    public void setNotifstate(int notifstate) {
        this.notifstate = notifstate;
    }

    

}
