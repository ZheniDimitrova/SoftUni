package com.example.coffeeshop_e_prep.repository;

import com.example.coffeeshop_e_prep.model.entity.Category;
import com.example.coffeeshop_e_prep.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryNameEnum name);
}
