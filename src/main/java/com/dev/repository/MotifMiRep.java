package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.models.*;;

public interface MotifMiRep extends JpaRepository<MotifMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    // ---select * from Motif where iduser='' and etats=0;-->throw new ExceptionCar("session plus valide");
    @Query(value = "select * from Motif where codemotif=\'C000\'" , nativeQuery = true )
    List <MotifMi> getMotifCommission() ;
}