package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.models.*;;

public interface SoldeuserMiRep extends JpaRepository<SoldeuserMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    // ---select * from Soldeuser where iduser='' and etats=0;-->throw new ExceptionCar("session plus valide");
    @Query(value = "select * from soldeuser where iduser= :iduser " , nativeQuery = true )
    List <SoldeuserMi> getSoldeByIduser( @Param("iduser")int iduser) ;
}