package com.kubeworks.movieService.dao;

import com.kubeworks.movieService.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

    Category getCategoryByCategoryId(int categoryId);
}
