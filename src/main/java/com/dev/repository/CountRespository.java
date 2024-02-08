package com.dev.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.dev.models.UserCount;

@Repository
public class CountRespository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<UserCount> executerRequeteNative(String requete) {
        return (List<UserCount>) entityManager.createNativeQuery(requete, UserCount.class).getResultList();
    }

    public List<UserCount> getCountUser() {
        String query = "select * from v_count_user";
        System.out.println(query);
        return executerRequeteNative(query);
    }
}