package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.models.*;;

public interface AnnoncefavorisMiRep extends JpaRepository<AnnoncefavorisMi, Integer> {
    @Query(value = "select * from annoncefavoris where iduser = :iduser and idannonce = :idannonce" , nativeQuery = true )
    List <AnnoncefavorisMi> getListByIduserByIdannonce(@Param("iduser")int iduser, @Param("idannonce")int idannonce) ;

}