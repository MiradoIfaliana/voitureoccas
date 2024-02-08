package com.dev.models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name="lieu")
public class LieuMi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idlieu;
    String nomlieu;
    
    public LieuMi() {
    }
    public int getIdlieu() {
        return idlieu;
    }
    public void setIdlieu(int idlieu) {
        this.idlieu = idlieu;
    }
    public String getNomlieu() {
        return nomlieu;
    }
    public void setNomlieu(String nomlieu) {
        this.nomlieu = nomlieu;
    }

    
}
