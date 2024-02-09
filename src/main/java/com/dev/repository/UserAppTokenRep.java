package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.models.*;

public interface UserAppTokenRep extends JpaRepository<UserAppToken, Integer> {
    @Query(value = "select * from userapptoken where iduser= :iduser and notiftoken= :notiftoken" , nativeQuery = true )
    List <UserAppToken> getUserapptoken( @Param("iduser")int iduser, @Param("notiftoken")String notiftoken) ;
}