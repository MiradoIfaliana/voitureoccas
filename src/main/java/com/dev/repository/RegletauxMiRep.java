package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dev.models.*;;

public interface RegletauxMiRep extends JpaRepository<RegletauxMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    // ---select * from Regletaux where iduser='' and etats=0;-->throw new ExceptionCar("session plus valide");
    @Query(value = "select tauxpourcent from regletaux where coderegle=\'C000\' " , nativeQuery = true )
    List <Double> getTauxCommision() ;
    @Query(value = "select * from regletaux where coderegle=\'C000\' " , nativeQuery = true )
    List <RegletauxMi> getRegletaux_Commision() ;
}