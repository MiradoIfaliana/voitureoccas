package com.dev.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.dev.models.MarqueStat;

@Repository
public class MarqueStatRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<MarqueStat> executerRequeteNative(String requete) {
        return (List<MarqueStat>) entityManager.createNativeQuery(requete, MarqueStat.class).getResultList();
    }

    public List<MarqueStat> getMarqueStat(int annee) {
        String query = "SELECT union_result.idmarque , max(vendue) as vendue , marque.nommarque FROM (select * from v_marque_default UNION SELECT  marque.idmarque , count(idannonce) AS vendue FROM marque  left join v_models_vendu ON (marque.idmarque = v_models_vendu.idmarque) WHERE Extract( year from datevente) = '"
                + annee
                + "' GROUP BY marque.idmarque ) as union_result join marque on (union_result.idmarque = marque.idmarque) group by union_result.idmarque , marque.nommarque";
        System.out.println(query);
        return executerRequeteNative(query);
    }
}