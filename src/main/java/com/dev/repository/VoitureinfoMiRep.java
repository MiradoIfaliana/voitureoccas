package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.models.*;;

public interface VoitureinfoMiRep extends JpaRepository<VoitureinfoMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    @Query(value = "select * from voitureinfo where iduser= :iduser" , nativeQuery = true )
    List <VoitureinfoMi> getListByIduser( @Param("iduser")int iduser) ;

}