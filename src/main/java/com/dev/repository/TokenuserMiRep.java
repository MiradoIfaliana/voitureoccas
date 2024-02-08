package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.models.*;;

public interface TokenuserMiRep extends JpaRepository<TokenuserMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    // ---select * from tokenuser where iduser='' and etats=0;-->throw new ExceptionCar("session plus valide");
    @Query(value = "select * from tokenuser where iduser= :iduser and etats=0" , nativeQuery = true )
    List <TokenuserMi> getListConnecteeByIduser( @Param("iduser")int iduser) ;
}