package com.dev.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dev.models.LieuStat;

@Repository
public class Statisque_lieuRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<LieuStat> executerRequeteNative(String requete) {
        return (List<LieuStat>) entityManager.createNativeQuery(requete, LieuStat.class).getResultList();
    }

    public List<LieuStat> getStatLieu(int annee) {
        String query =  "SELECT union_lieu_result.idlieu , max(vendue) as vendue, lieu.nomlieu  FROM (SELECT * FROM v_lieu_default UNION SELECT lieu.idlieu , count(idannonce) AS vendue FROM lieu  LEFT JOIN V_annonce_vendu_lieu  ON (lieu.idlieu = V_annonce_vendu_lieu.idlieu) WHERE  Extract(YEAR FROM v_annonce_vendu_lieu.datevente) = '"
                + annee
                + "'  GROUP BY lieu.idlieu  ) as union_lieu_result join lieu on (union_lieu_result.idlieu = lieu.idlieu) group by union_lieu_result.idlieu , lieu.nomlieu";
        System.out.println(query);
        return executerRequeteNative(query);
    }
}