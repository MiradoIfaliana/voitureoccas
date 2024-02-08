package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.models.*;;

public interface AdminsMiRep extends JpaRepository<AdminsMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    // 
}