package com.kubeworks.movieService.business.abstracts;

import com.kubeworks.movieService.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getall();

    Category getCategoryById(int categoryId);
}
