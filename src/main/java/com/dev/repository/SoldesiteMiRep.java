package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.models.*;;

public interface SoldesiteMiRep extends JpaRepository<SoldesiteMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    // ---select * from Soldesite where iduser='' and etats=0;-->throw new ExceptionCar("session plus valide");
    @Query(value = "select * from soldesite where iduser= :iduser " , nativeQuery = true )
    List <SoldesiteMi> getSoldeByIduser( @Param("iduser")int iduser) ;
}