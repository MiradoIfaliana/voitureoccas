package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.models.*;;

public interface AnnoncevalidationMiRep extends JpaRepository<AnnoncevalidationMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    @Query(value = "select * from annoncevalidation where idannonce = :idannonce" , nativeQuery = true )
    List <AnnoncevalidationMi> getListByIdannonce( @Param("idannonce")int idannonce) ;
}