package com.kubeworks.movieService.dao;

import com.kubeworks.movieService.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorDao extends JpaRepository<Actor, Integer> {

    List<Actor> getActorsByMovieMovieId(int movieId);
}
