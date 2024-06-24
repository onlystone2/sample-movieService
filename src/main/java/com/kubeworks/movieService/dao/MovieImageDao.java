package com.kubeworks.movieService.dao;

import com.kubeworks.movieService.entity.MovieImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieImageDao extends JpaRepository<MovieImage, Integer> {
}
