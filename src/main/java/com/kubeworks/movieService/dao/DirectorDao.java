package com.kubeworks.movieService.dao;

import com.kubeworks.movieService.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorDao extends JpaRepository<Director, Integer> {

    Director getDirectorByDirectorId(int directorId);
}
