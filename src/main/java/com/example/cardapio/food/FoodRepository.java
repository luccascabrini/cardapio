package com.example.cardapio.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query(value = "SELECT * FROM foods WHERE similarity(title, :title) > 0.2", nativeQuery = true)
    List<Food> findByTitle(@Param("title") String title);

}
