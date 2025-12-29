package com.gestiontickets.core_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiontickets.core_api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

    List<Category> findByActiveTrue();
    
}
