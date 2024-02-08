package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.models.LieuMi;

@Repository
public interface LieuMiRep extends JpaRepository<LieuMi, Integer> {
    
}

